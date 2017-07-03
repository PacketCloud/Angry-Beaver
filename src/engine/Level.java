package engine;

import java.awt.Graphics2D;
import java.awt.Image;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.swing.ImageIcon;

import entities.Object;

public class Level {
	private Map<String, Object> ids = new HashMap<String, Object>();
	private ArrayList<Object> objectList = new ArrayList<Object>();
	private Image background = null;
	
	public Level() {
		
	}
	
	public void addObject(Object obj) {
		if (obj.getId() != null) {
			ids.put(obj.getId(), obj);
		}
		
		objectList.add(obj);
	}
	
	public void drawBackground(Graphics2D g) {
		//TODO: Read background image from FileUtility instead
		File file = new File("");
		String path = file.getAbsolutePath();
		try{
			if(background == null) {
				background = new ImageIcon(path + "/Resources/Textures/Background/ExampleBackground.png").getImage();
			}
			
			g.drawImage(background, 0, 0, 1920, 1080, null);
		} catch (Exception e){
			System.out.println(e.toString());
		}
	}
	
	
	public String findByID(String id){
		//TODO
		return null;
	}
	
	public void updateLevel(){
		for(Object obj : objectList){
			obj.update();
		}
	}
	
	public void drawLevel(Graphics2D g){
		//Draw Background first
		drawBackground(g);
		
		for(Object obj : objectList){
			obj.render(g);
		}
	}
}
