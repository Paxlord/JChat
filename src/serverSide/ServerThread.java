package serverSide;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ServerThread implements Runnable{
	
	BufferedReader in;
	PrintWriter out;
	
	
	
	public ServerThread(Socket sendingSocket, Socket receivingSocket) {
		
				
		try {
			in = new BufferedReader(new InputStreamReader(sendingSocket.getInputStream()));
			out = new PrintWriter(receivingSocket.getOutputStream(), true);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		this.start();
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		String userInput;
		try {
			while((userInput = in.readLine()) != null) {
				if(".".equals(userInput)) {
					
					System.out.println("Goodbye");
					break;
					
				}
				
				System.out.println("Ligne recu echoing back !");
				out.println(userInput);
				
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			in.close();
			out.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	public void start() {
		
		Thread t = new Thread(this);
		t.start();
		
	}

}
