package engine.multiplayer;

import java.io.IOException;

public class ServerHandler extends MultiplayerHandler {
	private Server serverThread;
	
	public ServerHandler(int port) {
		try {
			serverThread = new Server(port);
			//serverThread = new Server(port, this);;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void startServer() {
		serverThread.start();
	}
	
	public void stopServer() {
		serverThread.stopServer();
	}
}
