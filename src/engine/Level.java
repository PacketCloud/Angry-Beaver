package engine;

import java.awt.Graphics2D;
import java.awt.Image;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import javax.swing.ImageIcon;

import entities.AbstractEntity;

public class Level {
	private Map<String, AbstractEntity> ids = new HashMap<String, AbstractEntity>();
	private ArrayList<AbstractEntity> entityList = new ArrayList<AbstractEntity>();
	private CollisionDetector detector;
	private Image background = null;
	
	public Set<String> inputSet = new HashSet<String>();
	
	public Level() {
		detector = new CollisionDetector(this);
	}
	
	public void addEntity(AbstractEntity entity) {
		entity.setLevel(this);
		if (entity.getId() != null) {
			ids.put(entity.getId(), entity);
		}
		
		entityList.add(entity);
	}
	
	public void addInput(String action) {
		inputSet.add(action);
	}
	
	public void removeInput(String action) {
		inputSet.remove(action);
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
		for(AbstractEntity entity : entityList){
			entity.update();
		}
		//detector.detectCollisions();
	}
	
	public void drawLevel(Graphics2D g){
		//Draw Background first
		drawBackground(g);
		
		for(AbstractEntity entity : entityList){
			entity.render(g);
		}
	}
	
	public ArrayList<AbstractEntity> getEntities() {
		return entityList;
		
	}
	
	public Set<String> getInput() {
		return inputSet;
	}
}
