package engine;

import java.awt.Graphics2D;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import javax.swing.ImageIcon;

import entities.AbstractEntity;
import fileUtility.OpenImage;
import force.Force;
import force.Gravity;

/*
 * Level contains all entities
 */
public class Level {
	private Map<String, AbstractEntity> ids;
	private ArrayList<AbstractEntity> entityList;
	private ArrayList<AbstractEntity> addBufferList;
	private ArrayList<AbstractEntity> removeBufferList;
	private CollisionDetector detector;
	private Image background = null;
	
	public Set<String> inputSet;
	
	public Level() {
		ids = new HashMap<String, AbstractEntity>();
		entityList = new ArrayList<AbstractEntity>();
		addBufferList = new ArrayList<AbstractEntity>();
		removeBufferList = new ArrayList<AbstractEntity>();
		detector = new CollisionDetector(this);
		inputSet = new HashSet<String>();
	}
	
	/*
	 * Updates entities in the level
	 */
	public void updateLevel(){
		
		entityList.removeAll(removeBufferList);
		entityList.addAll(addBufferList);
		addBufferList.clear();
		
		for(AbstractEntity entity : entityList){
			entity.update();
		}
		detector.detectCollisions();
	}
	
	/*
	 * Draws entities in the level
	 */
	public void drawLevel(Graphics2D g){
		//Draw Background first
		drawBackground(g);
		
		for(AbstractEntity entity : entityList){
			entity.render(g);
		}
	}
	
	/*
	 * Draws the background based on the background set
	 * 
	 *  Currently, the background defaults to ExampleBackground.png.
	 */
	public void drawBackground(Graphics2D g) {
		if(background == null) {
			try {
				background = new OpenImage().Open("/Resources/Textures/Background/ExampleBackground.png");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		g.drawImage(background, 0, 0, 1920, 1080, null);
	}
	
	/*
	 * Get the entity associated with a given ID
	 */
	public AbstractEntity findByID(String id){
		return ids.get(id);
	}
	
	/* 
	 * Get a list of all entities in the level
	 */
	public ArrayList<AbstractEntity> getEntities() {
		return entityList;
	}
	
	/*
	 * Get a list of all keys being pressed by the user
	 */
	public Set<String> getInput() {
		return inputSet;
	}
	
	/*
	 * Adds an Entity into the level
	 */
	public void addEntity(AbstractEntity entity) {
		
		entity.setLevel(this);
		if (entity.getId() != null) {
			ids.put(entity.getId(), entity);
		}
		
		// Temporary to add gravity to all entities
		// TODO: How to initialize forces for all entities?
		Force f = new Gravity(1);
		entity.addForce(f);
		
		addBufferList.add(entity);
	}

	/*
	 * Removes an Entity from the level
	 */
	public void removeEntity(AbstractEntity entity) {		
		if(entity.getId() != null ) {
			ids.remove(entity.getId());
		}
		
		removeBufferList.add(entity);
	}
	
	/*
	 * Adds the String to the set of keys being pressed 
	 */
	public void addInput(String action) {
		inputSet.add(action);
	}

	/*
	 * Removes the String to the set of keys being pressed 
	 */
	public void removeInput(String action) {
		inputSet.remove(action);
	}
}
