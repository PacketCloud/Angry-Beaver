package engine;

import java.awt.Point;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

public class MoveLeft extends AbstractAction {
	Point point;
	
	public MoveLeft(Level currentLevel) {
		point = currentLevel.getPlayer().getStatus().getHitbox().getPosition();
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		point.move(point.x - 5, point.y);
		
	}

}
