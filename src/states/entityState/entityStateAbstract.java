package states.entityState;

import java.awt.Graphics2D;
import java.awt.Image;

import entities.AbstractEntity;

public abstract class EntityStateAbstract implements EntityStateInterface {
	protected EntityStateContext context;
	
	public EntityStateAbstract(EntityStateContext context) {
		this.context = context;
	}
	
	public void render(Graphics2D g, AbstractEntity entity) {
		Image texture = entity.getModel().getImageIcon(this.toString());
		float textureScale = entity.getModel().getImageScale(this.toString());
		g.drawImage(texture,//image to draw.
			(int) (entity.getPosition().getX() + (-0.5 * 1 + 0.5) * texture.getWidth(null) * textureScale),//x position to draw, dependent on direction facing and scale.
			(int) entity.getPosition().getY(),//y position to draw.
			(int) (texture.getWidth(null) * textureScale),//dx position to draw, dependent on direction facing and scale.
			(int) (texture.getHeight(null) * textureScale),//dy position to draw, dependent on scale.
			null);//observer, null.
	}	
}
