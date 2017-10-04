package engine.multiplayer;

import java.io.IOException;
import java.net.UnknownHostException;

public class ClientHandler extends MultiplayerHandler {
	private Client clientThread;
	
	public ClientHandler(String address, int port) {
		try {
			clientThread = new Client(address, port);
			//clientThread = new Client(address, port, this);
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void startSearch() {
		clientThread.start();
	}
	
	public void stopSearch() {
		clientThread.stopClient();
	}
}