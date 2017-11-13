package serial;

import java.lang.reflect.*;
import java.util.IdentityHashMap;
import java.util.Map;

import org.jdom2.*;

public class Serializer {
	
	public Serializer() {}
	
	public Document serialize(Object o) throws Exception {
		Document doc = new Document(new Element("serial"));
		Map table = new IdentityHashMap();
		
		// record object to serialize
		String id = Integer.toString(table.size());
		table.put(o, id);
		Class c = o.getClass();
		
		// add new <object>
		Element e = new Element("object");
		e.setAttribute("class", c.getName());
		e.setAttribute("id", id);
		doc.getRootElement().addContent(e);
		return doc;
	}
}
