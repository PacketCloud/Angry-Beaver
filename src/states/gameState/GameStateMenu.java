package states.gameState;

import java.awt.Font;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.awt.Rectangle;

import javax.swing.ImageIcon;
import javax.swing.KeyStroke;

import FileUtility.OpenImage;
import engine.LevelHandler;

public class GameStateMenu extends GameStateAbstract {
	public ArrayList<String> strings = new ArrayList<String>(Arrays.asList("Play", "Options","EXIT"));
	public int chosen = 0;	
	
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
		
		OpenImage Oimage = new OpenImage();
		
		try {
			Font font = new Font("Arial", 0, 100);
			g.setFont(font);
			g.drawImage(Oimage.Open(""), 0,0, null);
			
			g.setColor(Color.BLACK);

			g.drawString("ANGRY BEAVER", 290, 150);
			Font font1 = new Font("Comic Sans MS", 0, 50);
			g.setColor(Color.RED);
			g.setFont(font1);
			g.drawString("PLAY", 600, 300);
			g.drawString("OPTIONS", 550, 400);
			g.drawString("EXIT", 600, 500);

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
	//TODO:  figure out how to hightlight options in menu
	//key up down is working 
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
		if( chosen > 0){
			chosen = chosen -1;
			System.out.print(chosen);

		}
		if(chosen < 0){
			chosen = 2;
			System.out.print(chosen);

		}
	}

	@Override
	public void down() {
		// TODO Auto-generated method stub
		super.down();
		if( chosen >= 0){
			chosen = chosen +1;
			System.out.print(chosen);

		}
		if(chosen > 2 ){
			chosen = 0;
			System.out.print(chosen);

		}	}
	
	
	
	

}
