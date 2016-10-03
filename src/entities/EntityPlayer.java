package entities;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Point;
import java.io.File;

import javax.swing.ImageIcon;

import engine.LevelSettings;
import ResourceHandling.ResourceCollection;
import states.State;

/*
 * EntityPlayer is the class specific to the player's character's status.
 */
public class EntityPlayer extends CombatEntity {
	
	public EntityPlayer(EntityStatus status) {
		super(status);
	}
	public EntityPlayer(Point position, float velocity, String type, ResourceCollection model, String facing, State state,  int health, int attackResistance, int knockbackResistance, int attackSpeed, int attackDamage, int attackCooldown, int attackKnockback, int walkSpeed, int jumpHeight) {
		super(position, velocity, type, model, facing, state, health, attackResistance, knockbackResistance, attackSpeed, attackDamage, attackCooldown, attackKnockback, walkSpeed, jumpHeight);
		//TODO: Add EntityPlayer-specific values, methods, and add to constructor.
	}

	@Override
	public void onUpdate(LevelSettings levelSetting) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onDraw(Graphics2D g) {	
		File file = new File("");
		String path = file.getAbsolutePath();
		Hitbox hitbox = status.getHitbox();
		try{
			//note: in the future, scale and position of images should be dependent on window size/resolution.
			//note2: Entity images will be flipped horizontally depending on direction facing in the future.
			g.scale(2, 2);
			Image image = new ImageIcon(path + "/Resources/Sprites/Player/Beaver_Walking.gif").getImage();
			g.drawImage(image, (int) hitbox.getPosition().getX(), (int) hitbox.getPosition().getY(), null);
			g.scale(1, 1);
		} catch (Exception e){}
	}

	@Override
	public void onHit() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void setModel(String model) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public String getModel() {
		// TODO Auto-generated method stub
		return null;
	}
}
