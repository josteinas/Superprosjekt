package transfer;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class Sender {
	static int port = 10000;
	static String address = "169.254.148.182";
	static String filePath = "C:\\Users\\user\\Downloads\\tv\\Safety Not Guaranteed (2012) [1080p]\\Safety.Not.Guaranteed.2012.1080p.BRrip.x264.YIFY.mp4";
	
	public static void sendFile(Socket socket, File file) throws IOException{
		FileInputStream fStream = new FileInputStream(file);
		
		BufferedOutputStream out = new BufferedOutputStream(socket.getOutputStream());
		
		byte[] buf = new byte[1024*1024];
		int bytesRead;
		while((bytesRead = fStream.read(buf)) > 0){
			out.write(buf, 0, bytesRead);
		}
		out.close();
		socket.close();
		System.out.println("DONE!");
		
	}
	
	public static void main(String[] args) throws UnknownHostException, IOException{
		Socket connection = new Socket(address, port);
		File file = new File(filePath);
		sendFile(connection, file);
	}
	
}
