package keyInputs;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

/*
 * 	PlayerInput passes the KeyBoard stroke to the LevelHandler.
 * 		The gameState of the LevelHandler will define how the stroke
 * 		will be handled when passed.
 */
public class PlayerInput extends AbstractAction{
	private Keymap map;
	private String actionType;
	
	public PlayerInput(Keymap map, String actionType) {
		this.map = map;
		this.actionType = actionType;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		map.inputAction(actionType);
	}
}
