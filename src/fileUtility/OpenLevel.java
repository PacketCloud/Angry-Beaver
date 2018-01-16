package fileUtility;

import java.util.HashMap;
import java.util.Map;

import behaviour.prefab.PlayerBehaviour;
import engine.Level;
import entities.AbstractEntity;
import entities.EntityFactory;

/*
 * 	OpenLevel contains a map of all Level Keys to their Directories.
 * 		It will return an Level when given a key. 
 */

public class OpenLevel {
	private Map<String, String> imageMap = new HashMap<String, String>();
	
	public OpenLevel() {
		//TODO: Initialize Key to Directory mapping for all images
	}
	
	public Level parseLevel(String levelName) {
		//TODO: Use the map to use OpenFile and parse a Level file
		Level loadedLevel = new Level();
		EntityFactory entityFactory = new EntityFactory();
		OpenFile levelFile = new OpenFile(levelName);
		int lineNumber = 0;
		while(levelFile.hasNextLine()) {
			String line = levelFile.getNextLine();
			String[] split = line.split(" ", 2); // Get the first argument
			String[] split2 = split[0].split(":", 2); // Get the setting of the first argument
			switch (split2[0]) {
			case "Entity":
				try {
					AbstractEntity entity = entityFactory.createEntity(split2[1], split[1]);
					loadedLevel.addEntity(entity);
				} catch (Exception e) {
					System.out.println("Entity " + split2[1] + " can not be created on line " + lineNumber);
				}
				break;
			case "Player":
				try {
					AbstractEntity entity = entityFactory.createEntity(split2[1], split[1]);
					entity.setBehaviour(new PlayerBehaviour());
					entity.setId("Player");
					loadedLevel.focusCamera(entity);
					loadedLevel.focusHUD(entity);
					loadedLevel.displayHud(true);
					loadedLevel.addEntity(entity);
				} catch (Exception e) {
					System.out.println("Entity " + split2[1] + " can not be created on line " + lineNumber);
				}
				break;
			case "Background":
				break;
			}
			lineNumber++;
		}
		
		levelFile.close();
		
		return loadedLevel;
	}

	public Map<String, String> getImageMap() {
		return imageMap;
	}
}
