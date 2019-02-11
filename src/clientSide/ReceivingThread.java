package clientSide;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

public class ReceivingThread implements Runnable{

	BufferedReader in;
	
	public ReceivingThread(BufferedReader in) {
		
		this.in = in;
		
		Thread t = new Thread(this);
		t.start();
		
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(true) {
			
			try {
				String userInput;
				if((userInput = in.readLine()) != null) {
					System.out.println(userInput);
					
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		}
	}
	
}
