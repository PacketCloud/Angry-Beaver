package states.gameState;

import java.awt.Graphics2D;
import java.awt.Image;
import java.util.ArrayList;
import java.util.Arrays;

import fileUtility.OpenImage;

public class GameStateOption extends GameStateAbstract {
	private String optionTitle = "OPTIONS";
	
	// TODO: define more options in the future
	private String fullscreenText = "Fullscreen : ";
	private ArrayList<String> fullscreenOptionsText = new ArrayList<String>(Arrays.asList("On", "Off"));
	
	private String resolutionText = "Resolution : ";
	private ArrayList<String> resolutionOptionsText = new ArrayList<String>(Arrays.asList("1920x1080", "1280x720", "800x600"));
	
	private int maxFPS = 0;
	
	private int chosen = 0;
	private Image background = null;
	
	public GameStateOption(GameStateContext context) {
		super(context);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		System.out.println("Option");
	}

	@Override
	public void render(Graphics2D g) {
		// TODO Auto-generated method stub
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
		// TODO Auto-generated method stub
		super.up();
	}

	@Override
	public void down() {
		// TODO Auto-generated method stub
		super.down();
	}

	@Override
	public void right() {
		// TODO Auto-generated method stub
		super.right();
	}

	@Override
	public void left() {
		// TODO Auto-generated method stub
		super.left();
	}

	@Override
	public void jump() {
		// TODO Auto-generated method stub
		super.jump();
	}
}
