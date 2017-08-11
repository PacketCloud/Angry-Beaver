package engine;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Point;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

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
	private Camera camera;
	private HeadUpDisplay HUD;
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
		camera = new Camera();
		HUD = new HeadUpDisplay();
	}
	
	/*
	 * Updates entities in the level
	 */
	public void updateLevel(){
		
		for(AbstractEntity entity : entityList){
			entity.update();
		}
		
		entityList.removeAll(removeBufferList);
		entityList.addAll(addBufferList);
		addBufferList.clear();
		removeBufferList.clear();
		
		detector.detectCollisions();
		
		camera.updateCamera();
	}
	
	/*
	 * Draws entities in the level
	 */
	public void drawLevel(Graphics2D g){
		//Draw Background first
		drawBackground(g);
		
		// Set camera
		g.translate(-camera.getX(), -camera.getY());
		
		// For temporary reference, draw the Origin (0,0)
		g.setColor(Color.CYAN);
		g.drawOval(0, 0, 3, 3);
		g.drawString("Origin", 2, -2);
		
		// Render all entities in the level
		for(AbstractEntity entity : entityList){
			entity.render(g);
		}
		
		// Render HUD 
		g.translate(camera.getX(), camera.getY());
		HUD.render(g);
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
	 * Have the Camera follow the given entity
	 */
	public void focusCamera(AbstractEntity e) {
		camera.setFocusEntity(e);
	}

	/*
	 * Have the Camera follow the given Point
	 */
	public void focusCamera(Point p) {
		camera.setFocusPoint(p);
	}
	
	public void displayHud(boolean display) {
		HUD.setDisplayHUD(display);
	}

	public void focusHUD(AbstractEntity e) {
		HUD.setFocusEntity(e);
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
