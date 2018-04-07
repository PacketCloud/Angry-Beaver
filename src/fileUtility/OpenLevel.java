package fileUtility;

import java.util.HashMap;
import java.util.Map;

import behaviour.prefab.PlayerBehaviour;
import engine.Level;
import entities.AbstractEntity;
import entities.EntityFactory;

/** 
 * Class OpenLevel parses a text file to build a Level 
 */
public class OpenLevel {
	private Map<String, String> imageMap = new HashMap<String, String>();
	
	public OpenLevel() {
	}
	/**
	 * Method parseLevel takes in a String levelName, opens the text file of that level,
	 * and parses the file into a Level class.
	 * 
	 * @param levelName		A String of the text file name
	 * @return				A Level instance
	 */
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
