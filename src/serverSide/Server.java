package serverSide;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class Server {
	
	static ArrayList<Socket> clientList = new ArrayList<Socket>();
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int portnumber = 1234;
		
		try {
			ServerSocket socket = new ServerSocket(portnumber);
			acceptClients(socket);
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}
	
	public static void acceptClients(ServerSocket socket) {
		
		while(true) {
			
			try {
				Socket clientSocket = socket.accept();
				clientList.add(clientSocket);
				
				
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			if(clientList.size() == 2 ) {
				break;
			}
			
			
		}
		
		creerCommunicationThreads();
		
	}
	
	public static void creerCommunicationThreads() {
		
		ServerThread t1 = new ServerThread(clientList.get(0), clientList.get(1));
		ServerThread t2 = new ServerThread(clientList.get(1), clientList.get(0));
		
		
	}

	
	
}
