package keyInputs;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

/* This class is currently not used but will be used for later reference */
public class PauseAction extends AbstractAction {
	public Keymap map;
	
	public PauseAction(Keymap map) {
		this.map = map;
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		//map.pause();
	}
	
}
