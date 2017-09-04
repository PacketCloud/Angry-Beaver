package states.gameState;

import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Image;
import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import engine.multiplayer.Server;
import fileUtility.OpenImage;

public class GameStateHostLobby extends GameStateAbstract {
	private String hostLobbyTitle = "GAME LOBBY";
	private ArrayList<String> hostLobbyText = new ArrayList<String>(Arrays.asList("Start", "Close Lobby"));
	private int chosen = 0;	
	private Image background = null;
	
	private Server serverThread;
	
	public GameStateHostLobby(GameStateContext context, String port) {
		super(context);
		// TODO Auto-generated constructor stub
		try {
			serverThread = new Server(Integer.parseInt(port));
		} catch (NumberFormatException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			context.setGameState(new GameStateHostSetup(context));
		}
		
		serverThread.start();
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		System.out.println("Host Lobby");
	}

	@Override
	public void render(Graphics2D g) {
		// TODO Auto-generated method stub
		drawBackground(g);
		
		Font font = new Font(titleFont, 0, titleSize);
		g.setFont(font);
		g.setColor(titleColor);
		
		g.drawString(hostLobbyTitle, 290, 150);
		
		Font font1 = new Font(textFont, 0, textSize);
		g.setFont(font1);
		
		g.setColor(defaultColor);
		
		g.drawString("Players :", 900, 300);
		List<Socket> list = Collections.synchronizedList(serverThread.getClients());
		
		synchronized(list) {
			Iterator<Socket> iterator = list.iterator();
			for(int i = 0; iterator.hasNext(); i ++) {
				g.drawString(iterator.next().getInetAddress().getHostName(), 950, 400 + i * 100);
			}
		}
		
		for (int i = 0; i < hostLobbyText.size(); i++) {
			if(chosen == i) {
				g.setColor(selectColor);
			} else {
				g.setColor(defaultColor);
			}
			
			g.drawString(hostLobbyText.get(i), 550, 300 + i * 100);
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

	@Override
	public void up() {
		// TODO Auto-generated method stub
		super.up();
		
		chosen--;
		if (chosen < 0) {
			chosen = hostLobbyText.size() - 1;
		}
	}

	@Override
	public void down() {
		// TODO Auto-generated method stub
		super.down();
		
		chosen++;
		if (chosen >= hostLobbyText.size()) {
			chosen = 0;
		}
	}

	@Override
	public void jump() {
		// TODO Auto-generated method stub
		super.jump();
		
		serverThread.stopServer();
		
		switch(chosen) {
		case 0:
			// context.setGameState(new GameStateHostRun(context));
			break;
		case 1:
			context.setGameState(new GameStateMultiplayer(context));
		}
	}
	
	
}
