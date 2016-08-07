package entities;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

import engine.LevelSettings;

/*
 * EntityPlayer is the class specific to the player's character's status.
 */
public class EntityPlayer extends CombatEntity {
	
	public EntityPlayer(Point position, String type, String model, int health, int attackResistance, int knockbackResistance, int attackSpeed, int attackDamage, int attackCooldown, int attackKnockback, int walkSpeed, int jumpHeight) {
		super(position, type, model, health, attackResistance, knockbackResistance, attackSpeed, attackDamage, attackCooldown, attackKnockback, walkSpeed, jumpHeight);
		//TODO: Add EntityPlayer-specific values, methods, and add to constructor.
	}

	@Override
	public void onUpdate(LevelSettings levelSetting) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onDraw(Graphics2D g) {
		// TODO Auto-generated method stub
		File file = new File("");
		String path = file.getAbsolutePath();
		BufferedImage image = null;
		try{
			image = ImageIO.read(new File(path + "/Resources/Sprites/Player/Beaver_Idle_1.gif"));
			g.scale(0.5, 0.5);
			g.drawImage(image, null, 0, 0);
		} catch (Exception e){}

		//g.setColor(Color.RED);
		//g.fillRect((int)getPosition().getX(), (int)getPosition().getY(), 100, 100);
	}

	@Override
	public void onHit() {
		// TODO Auto-generated method stub
		
	}
}
