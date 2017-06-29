package states.gameState;

import java.awt.Font;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.ImageIcon;

import engine.LevelHandler;

public class GameStateMenu extends GameStateAbstract {
	private String menuTitle = "ANGRY BEAVER";
	private ArrayList<String> menuText  = new ArrayList<String>(Arrays.asList("Play", "Options","Exit"));
	private int chosen = 0;	
	
	private Color titleColor = Color.BLACK;
	private Color defaultColor = Color.BLACK;
	private Color selectColor = Color.RED;
	
	public GameStateMenu(LevelHandler h) {
		super(h);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		getH().repaint();
    	System.out.println("Menu");
	}

	@Override
	public void render(Graphics2D g) {
		// TODO Auto-generated method stub
		
		// TODO: Menu background?
		drawBackground(g);
		// TODO: Positioning of text based on the window size.
		//g.scale(1, 1);
		// Set title
		Font font = new Font("Arial", 0, 100);
		g.setFont(font);
		g.setColor(titleColor);
		
		g.drawString(menuTitle, 290, 150);
		
		// Set menu text
		Font font1 = new Font("Comic Sans MS", 0, 50);
		g.setFont(font1);
		
		int y = 300;
		for (int i = 0; i < menuText.size(); i++) {
			if (chosen == i) {
				g.setColor(selectColor);
			} else {
				g.setColor(defaultColor);
			}
			g.drawString(menuText.get(i), 550, y);
			y += 100;
		}
	}
 
	public void drawBackground(Graphics2D g) {
		//TODO: Read background image from FileUtility instead
		File file = new File("");
		String path = file.getAbsolutePath();
		try{
			//note: in the future, image scale and position should be dependent on window size/resolution.
			Image background = new ImageIcon(path + "/Resources/Textures/Background/Background_MountainHorizon.png").getImage();
			g.drawImage(background, 0, 0, 1920, 1080, null);
		} catch (Exception e){
			System.out.println(e.toString());
		}
	}
	
	@Override
	public void jump() {
		// TODO Auto-generated method stub
		super.jump();
		switch(chosen) {
		case 0:
			getH().getGameState().stateRun();
			break;
		case 1:
			break;
		case 2:
			getH().getGameState().stateStop();
		}
	}

	@Override
	public void up() {
		// TODO Auto-generated method stub
		super.up();
		
		chosen--;
		if (chosen < 0) {
			chosen = menuText.size() - 1;
		}
	}

	@Override
	public void down() {
		// TODO Auto-generated method stub
		super.down();
		
		chosen++;
		if (chosen >= menuText.size()) {
			chosen = 0;
		}
	}
}
