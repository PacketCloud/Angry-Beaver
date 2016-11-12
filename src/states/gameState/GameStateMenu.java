package states.gameState;

import java.awt.Graphics2D;
import java.awt.Image;
import java.io.IOException;

import javax.swing.ImageIcon;

import FileUtility.OpenImage;
import engine.LevelHandler;

public class GameStateMenu extends GameStateAbstract {

	public GameStateMenu(LevelHandler h) {
		super(h);
		
		
		// TODO Auto-generated constructor stub
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void render(Graphics2D g) {
		// TODO Auto-generated method stub
		
		OpenImage Oimage = new OpenImage();
		
		try {
			g.scale(.5, .5);

			g.drawImage(Oimage.OpenImage(""), 0,0, null);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
