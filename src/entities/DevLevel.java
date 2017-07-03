package entities;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class DevLevel {
	private Map<String, Object> ids = new HashMap<String, Object>();
	private ArrayList<String> entityList = new ArrayList<String>();
	
	public void addObject(Object obj) {
		if (obj.getId() != null) {
			ids.put(obj.getId(), obj);
		}
		
		if 
	}
	
	public String findByID(String id){
		//TODO
		return null;
	}
	
	
}
