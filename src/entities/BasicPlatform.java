package entities;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.util.ArrayList;

import hitbox.Hitbox;
import model.AbstractModel;

public class BasicPlatform extends AbstractEntity{

	public BasicPlatform(AbstractModel model) {
		super(model, "Basic Null Entity");
		initializePlatform();
	}
	
	public void initializePlatform() {
	}

	@Override
	public void renderTexture(Graphics2D g) {
		Image texture = model.getImageIcon(state.toString());
		ArrayList<Hitbox> absoluteHitboxes = getAbsHitboxes();
		int facing = facing();
		
		// TODO: recursive drawing of textures
		if(texture != null) {
			for(Hitbox h: absoluteHitboxes) {
				g.drawImage(texture,//image to draw.
					(int) (position.getX() + (-0.5 * facing + 0.5) * texture.getWidth(null) * scaling),//x position to draw, dependent on direction facing and scale.
					(int) position.getY(),//y position to draw.
					(int) (h.getWidth() * facing * scaling),//dx position to draw, dependent on direction facing and scale.
					(int) (h.getHeight() * scaling),//dy position to draw, dependent on scale.
					null);//observer, null.
				g.setColor(Color.WHITE);
				g.drawRect(position.x, position.y , (int) (texture.getWidth(null) * scaling), (int) (texture.getHeight(null) * scaling));
			}
		}
	}

	
}
