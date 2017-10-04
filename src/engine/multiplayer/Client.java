package engine.multiplayer;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;

public class Client extends Thread {
	Socket client;
	private String address;
	private int port;
	private ArrayList<String> players;
	private boolean isRunning;
	
	private MultiplayerHandler mph;
	
	public Client (String address, int port) throws UnknownHostException, IOException {
	//public Client (String address, int port, MultiplayerHandler mph) throws UnknownHostException, IOException {
		// this.mph = mph;
		this.address = address;
		this.port = port;
		players = new ArrayList<String>();
		isRunning = true;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		super.run();
		System.out.println("Connecting to " + address);

		try {
			client = new Socket(address, port);
			System.out.println("Connected to " + address);
			
			// Grab data on players who are in the lobby
			while(isRunning) {
				DataInputStream in = new DataInputStream(client.getInputStream());
				players.add(in.readUTF());
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();			
		}
	}
	
	public void stopClient() {
		System.out.println("Stopping Client");
		isRunning = false;
	}
	
	public ArrayList<String> getPlayers() {
		return players;
	}
}
