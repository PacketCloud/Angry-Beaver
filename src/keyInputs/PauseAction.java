package keyInputs;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

public class PauseAction extends AbstractAction {
	public Keymap map;
	
	public PauseAction(Keymap map) {
		this.map = map;
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		map.pause();
	}
	
}
