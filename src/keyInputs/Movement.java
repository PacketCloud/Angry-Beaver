package keyInputs;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

public class Movement extends AbstractAction {
	Keymap map;
	Integer x = 0;
	Integer y = 0;
	public Movement(Keymap map, Integer x, Integer y) {
		this.map = map;
		if (x != null) {
			this.x = x;
		} else {
			this.x = null;
		}
		if (y != null) {
			this.y = y;
		} else {
			this.y = null;
		}
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		if (x != null) {
			map.setMoveX(x);
		}
		if (y != null) {
			map.setMoveY(y);
		}
	}

}
