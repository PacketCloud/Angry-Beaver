package states.gameState;

import java.awt.Graphics2D;

/**
 * Class GameStateStop is the Game State which signifies the
 * game handler to stop running and close the game.
 */
public class GameStateStop extends GameStateAbstract {

	public GameStateStop(GameStateContext context) {
		super(context);
	}

	@Override
	public void update() {
		System.out.println("Stopping");
	}

	@Override
	public void render(Graphics2D g) {
	}
}
