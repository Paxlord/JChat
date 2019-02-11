package clientSide;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

public class SendingThread implements Runnable{

	private PrintWriter out;
	private BufferedReader stdIn;
	private String name;
	
	public SendingThread(PrintWriter out, BufferedReader stdIn, String name) {
		
		this.out = out;
		this.name = name;
		this.stdIn = stdIn;
		
		Thread t = new Thread(this);
		t.start();
		
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		String userInput;
		try {
			while((userInput = stdIn.readLine()) != null) {
				out.println(name + " : " + userInput);
				
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

		
	
}
