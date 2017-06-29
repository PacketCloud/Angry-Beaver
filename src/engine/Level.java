package engine;

import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Point;
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

    public Level() {
    	// Current rough working of Camera
    	
    	Dimension windowSize = MainRuntime.getSettings().getWindowSize();
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
