package states.entityState;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Point;

import entities.AbstractEntity;
import resourceHandling.ResourceCollection;

public abstract class EntityStateAbstract implements EntityStateInterface {
	protected EntityStateContext context;
	
	public EntityStateAbstract(EntityStateContext context) {
		this.context = context;
	}
	
	public void render(Graphics2D g, ResourceCollection model, Point pos) {
		Image texture = model.getImageIcon(stateToString());
		float textureScale = model.getImageScale(stateToString());
		int facing = context.getEntity().facing();
		System.out.println(facing);
		g.drawImage(texture,//image to draw.
			(int) (pos.getX() + (-0.5 * facing + 0.5) * texture.getWidth(null) * textureScale),//x position to draw, dependent on direction facing and scale.
			(int) pos.getY(),//y position to draw.
			(int) (texture.getWidth(null) * textureScale),//dx position to draw, dependent on direction facing and scale.
			(int) (texture.getHeight(null) * textureScale),//dy position to draw, dependent on scale.
			null);//observer, null.
	}

	public void up(AbstractEntity entity) { }

	public void down(AbstractEntity entity) { }

	public void right(AbstractEntity entity) { }

	public void left(AbstractEntity entity) { }

	public void pause(AbstractEntity entity) { }

	public void jump(AbstractEntity entity) { }
	
	public void attack(AbstractEntity entity) {	}

	public void attack2(AbstractEntity entity) { }

	public void setForNextState(AbstractEntity entity) { }

	public void checkForNextState(AbstractEntity entity) { }
}
