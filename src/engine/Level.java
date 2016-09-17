package engine;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;

import javax.imageio.ImageIO;

import entities.*;

public class Level {
/* Currently one ArrayList. This is the level Singleton which
 * 	will hold a list of all Entities to draw and update on.
 * 	In order to use this class:
 * 		Level level = Level.getInstance();
 */
 
	private ArrayList<Entity> entityList = new ArrayList<Entity>();
	private ArrayList<Platform> platformList = new ArrayList<Platform>();
    private EntityPlayer player = null;
    private BufferedImage background = null;
    private LevelSettings levelSetting = null;
    private LevelHandler lHandler;
    
    public Level(LevelHandler lHander) {
    	setLevelHandler(lHandler);
    }
    
    public void setLevelHandler(LevelHandler lHandler) {
    	this.lHandler = lHandler;
    }

	public LevelSettings getLevelSetting() {
		return levelSetting;
	}

	public void setLevelSetting(LevelSettings levelSetting) {
		this.levelSetting = levelSetting;
	}

	public void setPlayer(EntityPlayer player) {
		this.player = player;
	}

	public EntityPlayer getPlayer() {
		return player;
	}

	public boolean loadLevel(String s) {
		//TODO: This should load entity information from a file
		return false;
	}
	
	public void addEntity(Entity ent) {
		entityList.add(ent);
	}
	
	public void clearLevel() {
		entityList.clear();
	}
	
	//Updates all entities to their correct location/action
	public void updateLevel(){
		player.update(levelSetting);
		for(int i = 0; i < entityList.size(); i++){
			entityList.get(i).update(levelSetting);
		}
	}
	
	//Draws all entities to Graphics
	public void drawLevel(Graphics2D g){
		//Draw Background first
		drawBackground(g);
		// Draw Entities after
		player.draw(g);
		for(int i = 0; i < entityList.size(); i++){
			entityList.get(i).draw(g);
		}
	}
	
	public void drawBackground(Graphics2D g) {
		//if (background == null), default to white
		g.setColor(Color.WHITE);
		g.fillRect(0, 0, 1280, 720);
		//g.setColor(Color.BLACK);
		//g.drawLine(0, 500, 1280, 500);
		
		//TODO: Read background image from FileUtility instead
		File file = new File("");
		String path = file.getAbsolutePath();
		BufferedImage image = null;
		try{
			image = ImageIO.read(new File(path + "/Resources/Textures/Background/ExampleBackground.png"));
			g.drawImage(image, null, 0, 0);
		} catch (Exception e){}
		
		//if (background != null, draw background image
		//g.drawImage(background, null, null, null);
	}
	
	// FOR TESTING
	public void print() {
		if(entityList == null) {
			System.out.println("Empty");
		} else {
			System.out.println("Init");
			System.out.println(entityList.get(0));
		}
	}
	
	
/*
	public static void main(String[] args) {
		Level level = Level.getInstance();
		//Entity ent = new Entity(new Point(0,0), "", "");
		level.addEntity(ent);
		level.print();
		//Level level = new Level();
		Level level2 = Level.getInstance();

		level2.print();	
	}
*/
}
