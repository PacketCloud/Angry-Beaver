package engine.multiplayer;

import java.net.Socket;
import java.util.ArrayList;

/*
 * Currently not implemented but will be used in the future
 * instead of 'Client' and 'Server' classes 
 */
import states.gameState.MultiplayerInterface;

public class MultiplayerHandler {
	
	private ArrayList<Socket> players;
	private ArrayList<Thread> playerThread;	// Thread to get incoming messages
	
	private MultiplayerInterface multiplayerGameState;
	
	public MultiplayerHandler() {
		players = new ArrayList<Socket>();
		playerThread = new ArrayList<Thread>();
		
		// TODO: Handle finding players as a host or a guest
	}
	
	// Let GameState handle incoming message from players
	public void parseMessage() {
		multiplayerGameState.parseMessage();
	}
	
	// Write message to a specific player
	public void writeMessage() {
		
	}
	
	// Write message to all players
	public void writeMessageToAll() {
		
	}
	
	// Get all players in session
	public void getPlayers() {
		
	}
	
	// Remove a specific player from session
	public void removePlayer() {
		
	}
	
	// Send stop message to all players, close all multiplayer threads and sockets
	public void stop() {
		
	}
}
