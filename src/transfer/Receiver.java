package transfer;

import java.io.File;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Receiver {
	
	private ServerSocket serverSocket; 

	public Receiver(){
		try {
			serverSocket = new ServerSocket(10000);
			
			while(true){
				Socket receiveSocket = serverSocket.accept(); 
				RequestParser requestParser = new RequestParser(receiveSocket); 
				(new Thread(requestParser)).start();
			}
			
		} catch (IOException e) {
			System.out.println("IOException i Receiver");
		} 
	}
	
	public static void main(String[] args) {
		new Receiver(); 
	}

}
