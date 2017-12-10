package engine;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;

import entities.AbstractEntity;

public class HeadUpDisplay {

	protected boolean displayHUD;
	
	protected AbstractEntity focusEntity;
	
	public HeadUpDisplay() {
		displayHUD = false;
		focusEntity = null;
	}

	public void render(Graphics2D g) {
		// TODO: design HUD interface
		g.setColor(Color.LIGHT_GRAY);
		g.setFont(new Font("Arial", 0, 24));

		if(displayHUD && focusEntity != null) {
			g.setColor(Color.LIGHT_GRAY);
			g.setFont(new Font("Arial", 0, 24));
			g.drawString("HUD ON", 20, 50);
			
			g.drawString("Following: " + focusEntity.toString(), 20, 75);
			g.drawString("State: " + focusEntity.getState().toString(), 20, 100);
			g.drawString("Position (Top-Left Corner): " + focusEntity.getPosition().toString(), 20, 125);
			g.drawString("Health: " + focusEntity.getHealth(), 20, 150);
		} else {
			g.drawString("HUD OFF", 20, 50);
		}
	}
	public boolean isDisplayHUD() {
		return displayHUD;
	}

	public void setDisplayHUD(boolean displayHUD) {
		this.displayHUD = displayHUD;
	}

	public AbstractEntity getFocusEntity() {
		return focusEntity;
	}

	public void setFocusEntity(AbstractEntity focusEntity) {
		this.focusEntity = focusEntity;
	}
	
	
}
