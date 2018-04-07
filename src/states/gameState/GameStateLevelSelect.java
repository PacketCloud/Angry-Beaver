package states.gameState;

import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Image;
import java.io.File;
import java.io.FilenameFilter;
import java.util.LinkedHashMap;
import java.util.Map;

import fileUtility.OpenImage;

/**
 * Class GameStateLevelSelect is the Game State in which the Player
 * selects a level from.
 * 
 * This state will provide the Player with a list of found level files
 * from the directory "/Levels". The Player can choose from the list 
 * of levels to play from.
 */
public class GameStateLevelSelect extends GameStateAbstract {
	private String levelSelectTitle = "LEVEL SELECTION";
	private Map<Integer, String> levelMap;
	private int chosen = 0;	
	private Image background = null;
	
	public GameStateLevelSelect(GameStateContext context) {
		super(context);
		// TODO Auto-generated constructor stub
		// Search "/Levels" for level files

		levelMap = new LinkedHashMap<Integer, String>();
		// Find all levels and put them in the map
		File[] levels = findLevels();
		for(int i = 0; i < levels.length; i++) {
			levelMap.put(i + 1, levels[i].getName());
		}
	}

	public File[] findLevels() {
		// Search "/Levels" for level files
		
		
		File absFile = new File("");
		String absPath = absFile.getAbsolutePath();
		
		File dir = new File(absPath + "/Levels");

		File[] matches = dir.listFiles(new FilenameFilter() {
			public boolean accept(File dir, String name) {
				// Dependent on the naming scheme we give Level files
				return name.startsWith("Level");
		  }
		});
		
		return matches;
	}
	
	@Override
	public void update() {
		// TODO Auto-generated method stub
		System.out.println("Level Select");
	}

	@Override
	public void render(Graphics2D g) {
		// TODO Auto-generated method stub
		drawBackground(g);
		
		// TODO: Positioning of text based on the window size.
		// Find Levels
		Font font = new Font(titleFont, 0, titleSize);
		g.setFont(font);
		g.setColor(titleColor);
		
		g.drawString(levelSelectTitle, 290, 150);
		
		// Set selection text
		Font font1 = new Font(textFont, 0, textSize);
		g.setFont(font1);
		
		for (int i = 0; i < levelMap.size(); i++) {
			if (chosen == i) {
				g.setColor(selectColor);
			} else {
				g.setColor(defaultColor);
			}
			g.drawString(levelMap.get(i + 1), 550, (i * 100) + 300);
		}
	}

	public void drawBackground(Graphics2D g) {
		if(background == null) {
			try {
				background = new OpenImage().Open("/Resources/Textures/Background/Background_MountainHorizon.png");
				//Image background = new ImageIcon(path + "/Resources/Textures/Background/Background_MountainHorizon.png").getImage();
				
			} catch (Exception e) {
				System.out.println(e.toString());
			}
		}
		g.drawImage(background, 0, 0, 1920, 1080, null);
	}

	@Override
	public void up() {
		// TODO Auto-generated method stub
		super.up();
		
		chosen--;
		if(chosen < 0) {
			chosen = levelMap.size() - 1;
		}
	}

	@Override
	public void down() {
		// TODO Auto-generated method stub
		super.down();
		
		chosen++;
		if(chosen >= levelMap.size()) {
			chosen = 0;
		}
	}

	@Override
	public void jump() {
		// TODO Auto-generated method stub
		super.jump();
		
		System.out.println("Level Selected: " + levelMap.get(chosen + 1));
		context.setGameState(new GameStateRun(context, "/Levels/" + levelMap.get(chosen + 1)));
	}
}
