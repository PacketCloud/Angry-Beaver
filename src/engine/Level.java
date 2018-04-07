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
import hitbox.Hitbox;

/**
 * Class Level holds data about all entities in an instance of a game.
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
	private Boolean win;
	private Boolean lose;
	
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
		win = false;
		lose = false;
	}
	
	/**
	 * Method updateLevel will update the level one frame/tick
	 */
	public void updateLevel(){

		// Update all entities
		for(AbstractEntity entity : entityList){
			entity.update();
		}
		
		// Remove and add entities into the Level
		entityList.removeAll(removeBufferList);
		entityList.addAll(addBufferList);
		// Clear buffers
		addBufferList.clear();
		removeBufferList.clear();
		
		// Check for collisions in the Level
		detector.detectCollisions();
		
		// Update the position of the camera 
		camera.updateCamera();
		if (findByID("Player") == null) {
			setLose(true);
		}
	}
	
	/**
	 * Method drawLevel draws entities in the level
	 * 
	 * @param g		Graphics2D to be drawn on
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
	 * Currently, the background defaults to ExampleBackground.png.
	 */
	public void drawBackground(Graphics2D g) {
		// TODO: Dynamic background
		if(background == null) {
			try {
				background = new OpenImage().Open("/Resources/Textures/Background/ExampleBackground.png");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		g.drawImage(background, 0, 0, 1920, 1080, null);
	}
	
	/**
	 * Method findByID returns an entity in the Level associated with the given ID
	 * 
	 * @param id 		A String
	 * @return			An entity object with the given ID string in the Level
	 * 					Otherwise returns null 
	 */
	public AbstractEntity findByID(String id){
		return ids.getOrDefault(id, null);
	}
	
	/**
	 * @param c			A Class to be searched for within the Level
	 * @return			A list of entities of the same Class in the Level
	 * 
	 * Method findByType returns a list of entities in the Level of the same class given
	 */
	public ArrayList<AbstractEntity> findByType(Class<?> c) {
		ArrayList<AbstractEntity> list = new ArrayList<AbstractEntity>();
		for(AbstractEntity e : entityList) {
			if(c.isInstance(e)) {
				list.add(e);
			}
		}
		return list;
	}
	
	/**
	 * Method findByArea returns all entities in the Level intersecting a certain area
	 * 
	 * @param h			A Hitbox area
	 * @return			A list of entities intersecting the given hitbox in the Level
	 */
	public ArrayList<AbstractEntity> findByArea(Hitbox h) {
		ArrayList<AbstractEntity> list = new ArrayList<AbstractEntity>();
		for(AbstractEntity e : entityList) {
			if(detector.intersectsArea(e, h)) {
				list.add(e);
			}
		}
		return list;
	}
	
	/**
	 * Method focusCamera will focus the camera on the position of the given entity
	 * 
	 * @param e			An entity which the game will focus the camera on
	 */
	public void focusCamera(AbstractEntity e) {
		camera.setFocusEntity(e);
	}

	/**
	 * Method focusCamera will focus the camera on the position of the given point
	 * 
	 * @param p			A point which the game will focus the camera on
	 */
	public void focusCamera(Point p) {
		camera.setFocusPoint(p);
	}
	
	/**
	 * Method displayHud will take a boolean to turn the HUD on or off
	 * 
	 * @param display	A boolean variable to set the HUD on or off
	 */
	public void displayHud(boolean display) {
		HUD.setDisplayHUD(display);
	}

	/**
	 * Method focusHUD will focus the HUD to display the given entity's information and status
	 * 
	 * @param e			An entity which the game will focus the HUD on
	 */
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
		
		// Add gravity to all entities
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

	public Boolean isWin() {
		return win;
	}

	public void setWin(Boolean win) {
		this.win = win;
	}

	public Boolean isLose() {
		return lose;
	}

	public void setLose(Boolean lose) {
		this.lose = lose;
	}
	
}
