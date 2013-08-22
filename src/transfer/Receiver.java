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
				ReqestPasrser fileReceiver = new ReqestPasrser(receiveSocket); 
				(new Thread(fileReceiver)).start();
			}
			
		} catch (IOException e) {
			System.out.println("heihi");
		} 
	}
	
	public static void main(String[] args) {
		new Receiver(); 
	}

}
