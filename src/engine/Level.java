package engine;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;

import javax.imageio.ImageIO;

import entities.*;

public class Level { 
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
	
	public void addEntity(Entity ent) {
		entityList.add(ent);
	}
	
	public void clearLevel() {
		entityList.clear();
	}
	
	public void addPlatform(Platform plat) {
		platformList.add(plat);
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
		
		for(int i = 0; i < platformList.size(); i++){
			platformList.get(i).draw(g);
		}
		// Draw Entities after
		for(int i = 0; i < entityList.size(); i++){
			entityList.get(i).draw(g);
		}
		player.draw(g);
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
			//note: in the future, image scale and position should be dependent on window size/resolution.
			image = ImageIO.read(new File(path + "/Resources/Textures/Background/ExampleBackground.png"));
			g.scale(0.75, 0.75);
			g.drawImage(image, null, 0, 0);
			g.scale(1, 1);
		} catch (Exception e){}
		
		//if (background != null, draw background image
		//g.drawImage(background, null, null, null);
	}
}
