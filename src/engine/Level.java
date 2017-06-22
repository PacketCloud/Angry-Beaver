package engine;

import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Point;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;
import javax.swing.ImageIcon;

import entities.*;

public class Level { 
	private ArrayList<Entity> entityList = new ArrayList<Entity>();
	private ArrayList<Platform> platformList = new ArrayList<Platform>();
    private Entity player = null;
    private Image background = null;
    //private LevelSettings levelSetting = null;
    private Point offset;

    public Level(Dimension windowSize) {
    	// Current rough working of Camera
		setOffset(new Point(windowSize.width/2, windowSize.height/2));
	}
/*
 * Not currently in use
	public LevelSettings getLevelSetting() {
		return levelSetting;
	}

	public void setLevelSetting(LevelSettings levelSetting) {
		this.levelSetting = levelSetting;
	}
*/	
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
		player.update();
		for(int i = 0; i < entityList.size(); i++){
			entityList.get(i).update();
		}
	}
	
	//Draws all entities to Graphics
	public void drawLevel(Graphics2D g){
		//Draw Background first
		drawBackground(g);
		
		g.translate(getOffset().x, getOffset().y);
		
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
		//g.setColor(Color.WHITE);
		//g.fillRect(0, 0, 1280, 720);
		
		//TODO: Read background image from FileUtility instead
		File file = new File("");
		String path = file.getAbsolutePath();
		try{
			//note: in the future, image scale and position should be dependent on window size/resolution.
			if(background == null) {
				background = new ImageIcon(path + "/Resources/Textures/Background/ExampleBackground.png").getImage();
			}
			
			g.scale(0.75, 0.75);
			g.drawImage(background, 0, 0, null);
			g.scale(1, 1);
		} catch (Exception e){}
		
		//if (background != null, draw background image
		//g.drawImage(background, null, null, null);
	}
	
	public void setPlayer(Entity player) {
		this.player = player;
	}
	public ArrayList<Entity> getEntityList() {
		return entityList;
	}
	public void setEntityList(ArrayList<Entity> entityList) {
		this.entityList = entityList;
	}
	public ArrayList<Platform> getPlatformList() {
		return platformList;
	}
	public void setPlatformList(ArrayList<Platform> platformList) {
		this.platformList = platformList;
	}
	public Image getBackground() {
		return background;
	}
	public void setBackground(Image background) {
		this.background = background;
	}
	public Entity getPlayer() {
		return player;
	}
	public Point getOffset() {
		return offset;
	}
	public void setOffset(Point offset) {
		this.offset = offset;
	}
}
