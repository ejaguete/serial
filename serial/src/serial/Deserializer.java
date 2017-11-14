package serial;

import java.lang.reflect.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.jdom2.Document;
import org.jdom2.Element;

public class Deserializer {
	Map table = new HashMap();
	
	public Deserializer() {}
	
	public Object deserialize(Document doc) throws Exception{
		List objects = doc.getRootElement().getChildren();
		
		createObjects(objects);
		assignValues(objects);
		return table.get("0");
		
	}

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
				inst = Array.newInstance(c.getComponentType(), 
						Integer.parseInt(oe.getAttributeValue("length")));
			table.put(oe.getAttributeValue("id"), inst);
			}
	}
	
	private void assignValues(List objects) throws Exception {
		for(Object o : objects) {
			Element oe = (Element) objects.get(objects.indexOf(o));
			Object inst = table.get(oe.getAttributeValue("id"));
			List fes = oe.getChildren();
			if(!inst.getClass().isArray()) {
				for (Object f: fes) {
					Element fe = (Element) fes.get(fes.indexOf(f));
					Class declaringClass = Class.forName(fe.getAttributeValue("declaringclass"));
					String fieldName = fe.getAttributeValue("name");
					Field field = declaringClass.getDeclaredField(fieldName);
					if(!Modifier.isPublic(field.getModifiers()))
						field.setAccessible(true);
					Element ve = (Element) fe.getChildren().get(0);
					field.set(inst, value());
				}
			} else {
				Class comptype = inst.getClass().getComponentType();
				for(Object a : objects) 
					Array.set(inst, objects.indexOf(a), value());
			}
			
		}
	}

	private Object value() {
		// TODO Auto-generated method stub
		return null;
	}


}
