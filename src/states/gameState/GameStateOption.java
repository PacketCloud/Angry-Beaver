package states.gameState;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Image;
import java.util.ArrayList;
import java.util.Arrays;

import fileUtility.OpenImage;
import fileUtility.Settings;
import engine.MainRuntime;

/**
 * Class GameStateOption is the Game State where the settings can be
 * accessed.
 */
public class GameStateOption extends GameStateAbstract {
	private String optionTitle = "OPTIONS";
	
	private ArrayList<ArrayList<String>> optionsText;	// Set of settings the user can choose from  
	private ArrayList<Integer> selection;	// The setting the user has chosen from
	private ArrayList<String> optionLabel;	// The category of Settings the user is choosing
	
	private int chosen = 0;
	private Image background = null;
	
	public GameStateOption(GameStateContext context) {
		super(context);
		
		// TODO: define more options in the future
		ArrayList<String> resolutionOptionsText = new ArrayList<String>(Arrays.asList("800x600", "1280x720", "1920x1080"));
		ArrayList<String> fullscreenOptionsText = new ArrayList<String>(Arrays.asList("true", "false"));
		ArrayList<String> fpsOptionsText = new ArrayList<String>(Arrays.asList("30", "60"));
		
		optionsText = new ArrayList<ArrayList<String>>();
		optionsText.add(resolutionOptionsText);
		optionsText.add(fullscreenOptionsText);
		optionsText.add(fpsOptionsText);
		
		selection = new ArrayList<>();
		for(int i = 0; i < optionsText.size(); i++) {
			selection.add(0);
		}
		
		loadCurrentSettings();
		
		optionLabel = new ArrayList<String>(Arrays.asList("Resolution : ", "Fullscreen : ", "MaxFPS : ", "Cancel", "Save Settings"));
		
		loadCurrentSettings();
	}

	public void loadCurrentSettings() {
		// Change ArrayList selection depending on what the current settings are
		Settings currentSettings = MainRuntime.getSettings();
		String width = Integer.toString((int) currentSettings.getWindowSize().getWidth());
		String height = Integer.toString((int) currentSettings.getWindowSize().getHeight());
		selection.set(0, optionsText.get(0).indexOf(width + "x" + height));
		selection.set(1, optionsText.get(1).indexOf(Boolean.toString(currentSettings.isFullscreen())));
		selection.set(2, optionsText.get(2).indexOf(Integer.toString(currentSettings.getMaxFPS())));
	}
	
	public void saveNewSettings() {
		// Compile and save settings into settings.cfg
		Settings settings = new Settings();
		settings.setTitle("Angry-Beaver");
		for(int i = 0; i < selection.size(); i++) {
			String s = optionsText.get(i).get(selection.get(i));
			System.out.println(s);
			
			if(optionLabel.get(i).startsWith("Resolution")) {
				String[] split = s.split("x");
				settings.setWindowSize(new Dimension(Integer.parseInt(split[0]), Integer.parseInt(split[1])));
				
			} else if(optionLabel.get(i).startsWith("Fullscreen")) {
				if(s.equals("On")) {
					settings.setisFullscreen(true);
				} else {
					settings.setisFullscreen(false);
				}
				
			} else if(optionLabel.get(i).startsWith("MaxFPS")) {
				settings.setMaxFPS(Integer.parseInt(s));
			}
			// As more options are added, add saving feature here
			
		}
		
		settings.saveUserSettings();
		// Restart the game to load the new settings
		context.setGameState(new GameStateExit(context));
	}
	
	@Override
	public void update() {
		System.out.println("Option");
	}

	@Override
	public void render(Graphics2D g) {
		drawBackground(g);
		
		// TODO: Positioning of text based on the window size.
		// Set options title
		Font font = new Font(titleFont, 0, titleSize);
		g.setFont(font);
		g.setColor(titleColor);
		
		g.drawString(optionTitle, 290, 150);
		
		// Set option labels
		Font font1 = new Font(textFont, 0, textSize);
		g.setFont(font1);
		
		int y = 300;
		for(int i = 0; i < optionLabel.size(); i++) {
			if (chosen == i) {
				g.setColor(selectColor);
			} else {
				g.setColor(defaultColor);
			}
			
			g.drawString(optionLabel.get(i), 550, y);
			y += 100;
		}
		
		// Set option Text
		y = 300;
		g.setColor(defaultColor);
		for(int i = 0; i < optionsText.size(); i++) {
			g.drawString(optionsText.get(i).get(selection.get(i)), 900, y);
			y += 100;
		}		
	}

	public void drawBackground(Graphics2D g) {
		if(background == null) {
			try {
				background = new OpenImage().Open("/Resources/Textures/Background/Background_MountainHorizon.png");
				//Image background = new ImageIcon(path + "/Resources/Textures/Background/Background_MountainHorizon.png").getImage();
				
			} catch (Exception e){
				System.out.println(e.toString());
			}
		}
		g.drawImage(background, 0, 0, 1920, 1080, null);
	}

	@Override
	public void up() {
		super.up();
		
		chosen--;
		if (chosen < 0) {
			chosen = optionLabel.size() - 1;
		}
	}

	@Override
	public void down() {
		super.down();
		
		chosen++;
		if (chosen >= optionLabel.size()) {
			chosen = 0;
		}
	}

	@Override
	public void right() {
		super.right();
		
		int holder = selection.get(chosen) + 1;
		if(holder >= optionsText.get(chosen).size()) {
			holder = 0;
		}
		selection.set(chosen, holder);
	}

	@Override
	public void left() {
		super.left();
		
		int holder = selection.get(chosen) - 1;
		if(holder < 0) {
			holder = optionsText.get(chosen).size() - 1;
		}
		selection.set(chosen, holder);
	}

	@Override
	public void jump() {
		super.jump();
		
		switch(chosen) {
		case 3:
			context.setGameState(new GameStateMenu(context));
			break;
		case 4:
			//Save settings
			saveNewSettings();
		}
	}
}
