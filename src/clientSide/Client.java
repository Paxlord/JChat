package clientSide;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Client {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int portNumber = 1234;
		
		PrintWriter out = null;
		BufferedReader in = null;
		BufferedReader stdIn = null;
		
		Scanner reader = new Scanner(System.in);
		
		System.out.println("Bonjour, Avant de vous connecter veuillez rentrez votre pseudo");
		String name = reader.nextLine();
		
		try {
			
			System.out.println("Essai de connexion...");
			Socket socket = new Socket("localhost", 1234);
			System.out.println("Connexion réussie");
			System.out.println("----------------------------------");
			out = new PrintWriter(socket.getOutputStream(), true);
			in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			stdIn = new BufferedReader(new InputStreamReader(System.in));
			
			ReceivingThread rt = new ReceivingThread(in);
			SendingThread st = new SendingThread(out, stdIn, name);
			
			
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
