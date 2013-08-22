package fooSharing;

import java.io.File;
import java.net.Socket;

public class TransferRequest {
	
	Socket socket;
	String filename;
	Computer computer;
	int size;	
	File location;
	
	public TransferRequest() {
		
	}
	
	
	public TransferRequest(Socket socket, String filename, int size) {
		this.socket = socket;
		this.filename = filename;
		this.size = size;
	}
	public Socket getSocket() {
		return socket;
	}
	
	public String getFilename(){
		return filename;
	}
	
	public int getSize() {
		return size;
	}
	
	public File getLocation() {
		return location;
	}


	public void setLocation(File location) {
		this.location = location;
	}

	public Computer getComputer() {
		return computer;
	}
	
	
	public void setComputer(Computer computer) {
		this.computer = computer;
	}
	
	

	

}
