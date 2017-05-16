package states.gameState;

import java.awt.Font;
import java.awt.Color;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.Arrays;
import engine.LevelHandler;

public class GameStateMenu extends GameStateAbstract {
	private String titleText = "ANGRY BEAVER";
	private ArrayList<String> menuText  = new ArrayList<String>(Arrays.asList("Play", "Options","EXIT"));
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
    	System.out.println("Paused");
	}

	@Override
	public void render(Graphics2D g) {
		// TODO Auto-generated method stub
		
		// TODO: Menu background?
		// TODO: Positioning of text based on the window size.
		//getH().getWindowSize();
		
		// Set title
		Font font = new Font("Arial", 0, 100);
		g.setFont(font);
		g.setColor(titleColor);
		
		g.drawString(titleText, 290, 150);
		
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
	
	public int centerX() {
		
		return 0;
	}

}
