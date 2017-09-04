package states.gameState;

import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Image;
import java.util.ArrayList;
import java.util.Arrays;

import fileUtility.OpenImage;

public class GameStateJoinSetup extends GameStateAbstract {
	private String joinSetupTitle = "JOIN A GAME LOBBY";
	private ArrayList<String> joinSetupText = new ArrayList<String>(Arrays.asList("IP address :", "Port Number :", "Join Lobby!", "Back"));
	private int chosen = 0;	
	private Image background = null;
	
	private String address;
	private String port;
	
	public GameStateJoinSetup(GameStateContext context) {
		super(context);
		// TODO Auto-generated constructor stub
		address = "";
		port = "";
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		System.out.println("Join Setup");
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
		
		g.drawString(address, 900, 300);
		g.drawString(port, 900, 400);
		
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

	@Override
	public void up() {
		// TODO Auto-generated method stub
		super.up();
		
		chosen--;
		if (chosen < 0) {
			chosen = joinSetupText.size() - 1;
		}
	}

	@Override
	public void down() {
		// TODO Auto-generated method stub
		super.down();
		
		chosen++;
		if (chosen >= joinSetupText.size()) {
			chosen = 0;
		}
	}

	@Override
	public void jump() {
		// TODO Auto-generated method stub
		super.jump();
		
		switch(chosen) {
		case 0:
			address += ".";
			break;
		case 2:
			context.setGameState(new GameStateJoinLobby(context, address, port));
			break;
		case 3:
			context.setGameState(new GameStateMultiplayer(context));
		}
	}

	@Override
	public void num0() {
		// TODO Auto-generated method stub
		super.num0();
		
		if(chosen == 0) {
			address += "0";
		}
		if(chosen == 1) {
			port += "0";
		}
	}

	@Override
	public void num1() {
		// TODO Auto-generated method stub
		super.num1();
		if(chosen == 0) {
			address += "1";
		}
		if(chosen == 1) {
			port += "1";
		}
	}

	@Override
	public void num2() {
		// TODO Auto-generated method stub
		super.num2();
		if(chosen == 0) {
			address += "2";
		}
		if(chosen == 1) {
			port += "2";
		}
	}

	@Override
	public void num3() {
		// TODO Auto-generated method stub
		super.num3();
		if(chosen == 0) {
			address += "3";
		}
		if(chosen == 1) {
			port += "3";
		}
	}

	@Override
	public void num4() {
		// TODO Auto-generated method stub
		super.num4();
		if(chosen == 0) {
			address += "4";
		}
		if(chosen == 1) {
			port += "4";
		}
	}

	@Override
	public void num5() {
		// TODO Auto-generated method stub
		super.num5();
		if(chosen == 0) {
			address += "5";
		}
		if(chosen == 1) {
			port += "5";
		}
	}

	@Override
	public void num6() {
		// TODO Auto-generated method stub
		super.num6();
		if(chosen == 0) {
			address += "6";
		}
		if(chosen == 1) {
			port += "6";
		}
	}

	@Override
	public void num7() {
		// TODO Auto-generated method stub
		super.num7();
		if(chosen == 0) {
			address += "7";
		}
		if(chosen == 1) {
			port += "7";
		}
	}

	@Override
	public void num8() {
		// TODO Auto-generated method stub
		super.num8();
		if(chosen == 0) {
			address += "8";
		}
		if(chosen == 1) {
			port += "8";
		}
	}

	@Override
	public void num9() {
		// TODO Auto-generated method stub
		super.num9();
		if(chosen == 0) {
			address += "9";
		}
		if(chosen == 1) {
			port += "9";
		}
	}
	
}