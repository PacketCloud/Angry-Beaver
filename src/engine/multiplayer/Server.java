package engine.multiplayer;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class Server extends Thread {
	private ServerSocket serverSocket;
	private ArrayList<Socket> clientSockets;
	private boolean isRunning;
	
	private MultiplayerHandler mph;
	
	public Server(int port) throws IOException {
	//public Server(int port, MultiplayerHandler mph) throws IOException {
		//this.mph = mph; 
		serverSocket = new ServerSocket(port);
		clientSockets = new ArrayList<Socket>();
		isRunning = true;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(isRunning) {
			try {
				System.out.println("Waiting for client on port " + serverSocket.getLocalPort());
				
				Socket socket = serverSocket.accept();
				System.out.println("Connection to " + socket.getInetAddress().getHostName());
				
				DataOutputStream outSocket = new DataOutputStream(socket.getOutputStream());
				outSocket.writeUTF("Host - " + serverSocket.getInetAddress().getLocalHost());
				
				for(Socket s : clientSockets) {
					// Notify other clients of new client
					DataOutputStream out = new DataOutputStream(s.getOutputStream());
					out.writeUTF(socket.getInetAddress().getHostName());
					
					// Notify new client of self and other clients
					outSocket.writeUTF(s.getInetAddress().getHostName());
				}
				
				clientSockets.add(socket);
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				break;
			}
		}
		
		try {
			serverSocket.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void stopServer() {
		System.out.println("Stopping Server");
		isRunning = false;
	}
	
	public ArrayList<Socket> getClients() {
		return clientSockets;
	}
}