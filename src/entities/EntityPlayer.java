package entities;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Point;
import java.io.File;
import java.util.Vector;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

import engine.LevelSettings;

/*
 * EntityPlayer is the class specific to the player's character's status.
 */
public class EntityPlayer extends CombatEntity {
	
	public EntityPlayer(EntityStatus status) {
		super(status);
	}
	public EntityPlayer(Point position, Vector velocity, String type, String model, int health, int attackResistance, int knockbackResistance, int attackSpeed, int attackDamage, int attackCooldown, int attackKnockback, int walkSpeed, int jumpHeight) {
		super(position, velocity, type, model, health, attackResistance, knockbackResistance, attackSpeed, attackDamage, attackCooldown, attackKnockback, walkSpeed, jumpHeight);
		//TODO: Add EntityPlayer-specific values, methods, and add to constructor.
	}

	@Override
	public void onUpdate(LevelSettings levelSetting) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onDraw(Graphics2D g) {
		// TODO Auto-generated method stub
/*		File file = new File("");
		String path = file.getAbsolutePath();
		BufferedImage image = null;
		try{
			image = ImageIO.read(new File(path + "/Resources/Sprites/Player/Beaver_Idle_1.gif"));
			g.scale(0.5, 0.5);
			g.drawImage(image, null, 0, 0);
		} catch (Exception e){}
*/
		
		File file = new File("");
		String path = file.getAbsolutePath();
		//g.setColor(Color.RED);
		Hitbox hitbox = status.getHitbox();
		try{
			//note: in the future, scale and position of images should be dependent on window size/resolution.
			//note2: Entity images will be flipped horizontally depending on direction facing in the future.
			g.scale(2, 2);
			Image image = new ImageIcon(path + "/Resources/Sprites/Player/Beaver_Walking.gif").getImage();
			g.drawImage(image, (int) hitbox.getPosition().getX(), (int) hitbox.getPosition().getY(), null);
			g.scale(1, 1);
		} catch (Exception e){}
		//g.fillRect((int) hitbox.getPosition().getX(), (int) hitbox.getPosition().getY(), hitbox.getWidth(), hitbox.getHeight());
		//g.fillRect((int)getPosition().getX(), (int)getPosition().getY(), 100, 100);
	}

	@Override
	public void onHit() {
		// TODO Auto-generated method stub
		
	}
}
