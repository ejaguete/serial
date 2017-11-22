package serial;

import java.lang.reflect.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.jdom2.Document;
import org.jdom2.Element;

public class Deserializer {
	@SuppressWarnings("rawtypes")
	public Map table = new HashMap();
	
	public Deserializer() {}
	
	@SuppressWarnings("rawtypes")
	public Object deserialize(Document doc) throws Exception{
		List objects = doc.getRootElement().getChildren();
		
		createObjects(objects);
		assignValues(objects);
		// returns only first object
		return table.get("0");
		
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	private void createObjects(List objects) throws Exception{
		for(Object o : objects) {
			Element oe = (Element) objects.get(objects.indexOf(o));
			Class c = Class.forName(oe.getAttributeValue("class"));
			Object inst = null;
			if(!c.isArray()) {
		
				Constructor con = c.getDeclaredConstructor(null);
				if(!Modifier.isPublic(con.getModifiers()))
					con.setAccessible(true);
				inst = con.newInstance(null);
				
			} else
				inst = Array.newInstance(c.getComponentType(), Integer.parseInt(oe.getAttributeValue("length")));
			
			table.put(oe.getAttributeValue("id"), inst);
			}
	}
	
	@SuppressWarnings({ "rawtypes" })
	private void assignValues(List objects) throws Exception {
		for(Object o : objects) {
			// grab <object>
			Element oe = (Element) objects.get(objects.indexOf(o));
			// retrieve object w/ corresponding id
			Object inst = table.get(oe.getAttributeValue("id"));
			// grab <object>'s children elems
			List children = oe.getChildren();
			
			if(!inst.getClass().isArray()) {
				for (Object child : children) {
					// grab child element
					Element ch = (Element) children.get(children.indexOf(child));
					
					Class declaringClass = Class.forName(ch.getAttributeValue("declaringclass"));
					String fieldName = ch.getAttributeValue("name");
					Field field = declaringClass.getDeclaredField(fieldName);	
					
					Field mods = Field.class.getDeclaredField("modifiers");
					mods.setAccessible(true);
					mods.setInt(field, field.getModifiers() & ~Modifier.FINAL);
					
					if(!Modifier.isPublic(field.getModifiers()))
						field.setAccessible(true);
						
					/*
					// don't deal with final fields
					if(Modifier.isFinal(field.getModifiers()))
						continue;
					*/
					// grab field info
					Element ve = (Element) ch.getChildren().get(0);
					
					field.set(inst, value(ve,field.getType()));
					
				}
			} else {
				Class comptype = inst.getClass().getComponentType();
				for(int i=0; i<children.size();i++) 
					Array.set(inst, i, value((Element) children.get(i), comptype));
			}
			
		}
	}

	@SuppressWarnings("rawtypes")
	private Object value(Element ve, Class type) throws ClassNotFoundException {
		String vtype = ve.getName();
		if(vtype.equals("null"))
			return null;
		else if(vtype.equals("reference"))
			return table.get(ve.getText());
		else {
			if(type.equals(boolean.class))
				return Byte.valueOf(ve.getText());
			
			else if(type.equals(char.class))
				return new Character(ve.getText().charAt(0));
			
			else if(type.equals(short.class))
				return Short.valueOf(ve.getText());
			
			else if(type.equals(long.class))
				return Long.valueOf(ve.getText());
			
			else if(type.equals(int.class))
				return Integer.valueOf(ve.getText());
			
			else if(type.equals(double.class))
				return Double.valueOf(ve.getText());
			
			else if(type.equals(float.class))
				return Float.valueOf(ve.getText());
			
			else 
				return ve.getText();
		}
	}


}
