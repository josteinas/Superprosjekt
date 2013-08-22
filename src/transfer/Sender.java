package transfer;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

import com.google.gson.JsonObject;

import fooSharing.Computer;

public class Sender {
	static int port = 10000;
	static String address = "169.254.148.182";
	static String filePath = "C:\\Users\\user\\Downloads\\tv\\Safety Not Guaranteed (2012) [1080p]\\Safety.Not.Guaranteed.2012.1080p.BRrip.x264.YIFY.mp4";
	
	private static void sendFile(Socket socket, File file) throws IOException{
		FileInputStream fStream = new FileInputStream(file);
		
		BufferedOutputStream out = new BufferedOutputStream(socket.getOutputStream());
		
		byte[] buf = new byte[1024*1024];
		int bytesRead;
		while((bytesRead = fStream.read(buf)) > 0){
			out.write(buf, 0, bytesRead);
		}
		out.close();
		socket.close();
		fStream.close(); 
		System.out.println("DONE!");
		
	}
	
	public static void sendFile(Computer computer, File file){
		try {
			Socket connection = new Socket(computer.getIp(),port);
			if(clearToSend(file.getName())){
				sendFile(connection, file);
			}
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private static boolean clearToSend(String name) {
		//TODO 
		return false;
	}

	public static void main(String[] args) throws UnknownHostException, IOException{
		Socket connection = new Socket(address, port);
		File file = new File(filePath);
		sendFile(connection, file);
	}
	
}
