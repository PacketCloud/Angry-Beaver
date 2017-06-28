package states.gameState;

import java.awt.Graphics2D;
import java.awt.Image;
import java.io.File;

import javax.swing.ImageIcon;

import java.awt.Color;
import java.awt.Font;

import engine.LevelHandler;

public class GameStateStart extends GameStateAbstract {
	private String startText = "PRESS ANY KEY TO START";
	
	private Color defaultColor = Color.BLACK;
	public GameStateStart(LevelHandler h) {
		super(h);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		getH().repaint();
    	System.out.println("Start");
	}

	@Override
	public void render(Graphics2D g) {
		// TODO Auto-generated method stub
		
		drawBackground(g);
		// TODO: Positioning of text based on the window size.
		
		Font font = new Font("Arial", 0, 55);
		g.setFont(font);
		g.setColor(defaultColor);
		
		g.drawString(startText, 290, 150);
	}
	
	public void drawBackground(Graphics2D g) {
		//TODO: Read background image from FileUtility instead
		File file = new File("");
		String path = file.getAbsolutePath();
		try{
			//note: in the future, image scale and position should be dependent on window size/resolution.
			Image background = new ImageIcon(path + "/Resources/Textures/Background/Background_MountainHorizon.png").getImage();
			g.drawImage(background, 0, 0, 1280, 720, null);
		} catch (Exception e){
			System.out.println(e.toString());
		}
	}

	@Override
	public void userInput(String action) {
		// TODO Auto-generated method stub
		//super.userInput(action);
		
		getH().getGameState().stateMenu();
	}
}