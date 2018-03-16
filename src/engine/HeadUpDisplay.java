package engine;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Image;

import entities.AbstractEntity;
import fileUtility.Settings;
import resourceHandling.Resource;
import resourceHandling.ResourceCollection;

/**
 * Class HeadUpDisplay draws a HUD to provide information to the Player.
 */

public class HeadUpDisplay {

	protected boolean displayHUD;
	protected int scaling;	
	protected AbstractEntity focusEntity;
	
	protected ResourceCollection resourceHUD;

	
	public HeadUpDisplay() {
		displayHUD = false;
		scaling = 4;
		focusEntity = null;
		resourceHUD = new ResourceCollection("HUD");
		resourceHUD.add(new Resource("Empty Heart", "/Resources/Sprites/Misc/Hearts/Heart_Empty.png", (float) 2.5, null, true, "Empty Heart"));
		resourceHUD.add(new Resource("Full Heart", "/Resources/Sprites/Misc/Hearts/Heart_Filled.png", (float) 2.5, null, true, "Filled Heart"));
		resourceHUD.add(new Resource("Heart Default", "/Resources/Sprites/Misc/Hearts/Heart_Empty.png", (float) 2.5, null, true, "Default"));
	}

	/**
	 * Method render will draw the HUD, text, and other visual elements for the game
	 * 
	 * @param g			Graphics2D which will be drawn to
	 */
	public void render(Graphics2D g) {
		// TODO: design HUD interface
		Boolean isDevelopment = Settings.getInstance().isDevelopment();
		if(displayHUD && focusEntity != null) {
			renderHearts(g);

			if (isDevelopment) {
				g.setColor(Color.LIGHT_GRAY);
				g.setFont(new Font("Arial", 0, 24));
				g.drawString("HUD ON", 20, 100);
				
				g.drawString("Following: " + focusEntity.toString(), 20, 125);
				g.drawString("State: " + focusEntity.getState().toString(), 20, 150);
				g.drawString("Position (Top-Left Corner): " + focusEntity.getPosition().toString(), 20, 175);
				g.drawString("Health: " + focusEntity.getHealth() + "/" + focusEntity.getMaxHealth(), 20, 200);	
			}			
		} else {
			if (isDevelopment) {
				g.drawString("HUD OFF", 20, 100);
			}
		}
	}
	
	public void renderHearts(Graphics2D g) {
		int numFilledHearts = focusEntity.getHealth();
		int numEmptyHearts = focusEntity.getMaxHealth() - numFilledHearts;
		
		int xPos = 0;
		int yPos = 0;
		Image filledHeart = resourceHUD.getImageIcon("Filled Heart");
		Image emptyHeart = resourceHUD.getImageIcon("Empty Heart");
		
		for (int i = 0; i < numFilledHearts; i++) {
			g.drawImage(filledHeart, xPos, yPos,
				(int) (filledHeart.getWidth(null) * scaling),
				(int) (filledHeart.getHeight(null) * scaling), 
				null);
			xPos += (int) (filledHeart.getWidth(null) * scaling);
		}
		
		for (int i = 0; i < numEmptyHearts; i++) {
			g.drawImage(emptyHeart, xPos, yPos,
					(int) (emptyHeart.getWidth(null) * scaling),
					(int) (emptyHeart.getHeight(null) * scaling), 
					null);
			xPos += (int) (filledHeart.getWidth(null) * scaling);
		}
		
	}
	
	public void renderDetails(Graphics2D g) {
		
	}
	
	/******** Getters and Setters ********/
	
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
