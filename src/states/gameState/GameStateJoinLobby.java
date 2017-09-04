package states.gameState;

import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Image;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import engine.multiplayer.Client;
import fileUtility.OpenImage;

public class GameStateJoinLobby extends GameStateAbstract {
	private String joinSetupTitle = "GAME LOBBY";
	private ArrayList<String> joinSetupText = new ArrayList<String>(Arrays.asList("Exit Lobby"));
	private int chosen = 0;	
	private Image background = null;
	
	private Client clientThread;
	
	public GameStateJoinLobby(GameStateContext context, String address, String port) {
		super(context);
		// TODO Auto-generated constructor stub
		try {
			clientThread = new Client(address, Integer.parseInt(port));
		} catch (NumberFormatException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			context.setGameState(new GameStateJoinSetup(context));
		}
		clientThread.start();
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void render(Graphics2D g) {
		// TODO Auto-generated method stub
		drawBackground(g);
		
		// TODO: Positioning of text based on the window size.
		// Set title
		Font font = new Font(titleFont, 0, titleSize);
		g.setFont(font);
		g.setColor(titleColor);
		
		g.drawString(joinSetupTitle, 290, 150);
		
		Font font1 = new Font(textFont, 0, textSize);
		g.setFont(font1);
		
		g.drawString("Players :", 900, 300);
		List<String> list = Collections.synchronizedList(clientThread.getPlayers());
		synchronized(list) {
			Iterator<String> iterator = list.iterator();
			for(int i = 0; iterator.hasNext(); i ++) {
				g.drawString(iterator.next(), 950, 400 + i * 100);
			}
		}
		
		for (int i = 0; i < joinSetupText.size(); i++) {
			if(chosen == i) {
				g.setColor(selectColor);
			} else {
				g.setColor(defaultColor);
			}
			
			g.drawString(joinSetupText.get(i), 550, 300 + i * 100);
		}
	}
	
	public void drawBackground(Graphics2D g) {
		if(background == null) {
			try {
				background = new OpenImage().Open("/Resources/Textures/Background/Background_MountainHorizon.png");
				
			} catch (Exception e){
				System.out.println(e.toString());
			}
		}
		g.drawImage(background, 0, 0, 1920, 1080, null);
	}

}
