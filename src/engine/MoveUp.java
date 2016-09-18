package engine;

import java.awt.Point;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

public class MoveUp extends AbstractAction {
	Point point;
	
	public MoveUp(Level currentLevel) {
		point = currentLevel.getPlayer().getStatus().getHitbox().getPosition();
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		point.move(point.x, point.y - 5);
		
	}

}
