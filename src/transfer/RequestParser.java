package transfer;

import java.net.Socket;

public class RequestParser implements Runnable{

	Socket socket; 
	
	public RequestParser(Socket socket){
		this.socket = socket; 
	}
	
	public void run() {
		// TODO Auto-generated method stub
		RequestHandler.addSocket(socket);
	}

}
