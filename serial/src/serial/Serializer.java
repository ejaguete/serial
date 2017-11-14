package serial;

import java.lang.reflect.*;
import java.util.IdentityHashMap;
import java.util.Map;

import org.jdom2.*;

public class Serializer {
	public Document doc = new Document(new Element("root"));
	Map table = new IdentityHashMap();
	
	public Serializer() {};
	
	public Document serialize(Object o) throws Exception {
		// record object to serialize
		String id = Integer.toString(table.size());
		table.put(o, id);
		Class c = o.getClass();
		
		// add new <object>
		Element oe = new Element("object");
		oe.setAttribute("class", c.getName());
		oe.setAttribute("id", id);
		doc.getRootElement().addContent(oe);
		
		if(!c.isArray()) {
			Field[] fields = c.getDeclaredFields();
			
			for(Field field : fields) {
				if(!Modifier.isPublic(field.getModifiers()))
					field.setAccessible(true);
				
				// add new <field>
				Element fe = new Element("field");
				fe.setAttribute("name", field.getName());
				fe.setAttribute("declaringclass", field.getDeclaringClass().getName());
				
				Class ftype = field.getType();
				Object guts = field.get(o);
				
				if(Modifier.isTransient(field.getModifiers())) 
					guts = null;
				// get field info
				fe.addContent(variable(ftype, guts));
				// add field
				oe.addContent(fe);

			}
		} else { // handle as an array
			Class comptype = c.getComponentType();
			int length = Array.getLength(o);
			oe.setAttribute("length", Integer.toString(length));
			// serialize array contents
			for(int i=0;i<length;i++) 
				oe.addContent(variable(comptype, Array.get(o, i)));
		}
		
		return doc;
	}
	
	private Element variable(Class type, Object guts) throws Exception {		
		if(guts==null)
			return new Element("null");
		else if(!type.isPrimitive()) {
			Element ref = new Element("reference");
			
			// if ref points to object already serialized grab it
			if(table.containsKey(guts))
				ref.setText(table.get(guts).toString());
			else {
				ref.setText(Integer.toString(table.size())); // new ref number
				serialize(guts);
			}
			return ref;
		} else {
			Element value = new Element("value");
			value.setText(guts.toString());
			return value;
		}

	}
}
