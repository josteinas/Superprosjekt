package transfer;

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
				FileReceiver fileReceiver = new FileReceiver(receiveSocket); 
				(new Thread(fileReceiver)).start();
				fileReceiver.run(); 
			}
			
		} catch (IOException e) {
			System.out.println("heihei");
		} 
	}
	
	public static void main(String[] args) {
		new Receiver(); 
	}

}
