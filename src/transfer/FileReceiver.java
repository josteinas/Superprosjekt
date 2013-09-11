package transfer;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.Socket;

public class FileReceiver implements Runnable{
	
	Socket socket; 
	File file; 

	public FileReceiver(Socket socket, File file){
		this.socket = socket;
		this.file = file;  
	}
	
	public void run() {
		long start = System.currentTimeMillis(); 
		FileOutputStream fileOutputStream = null;
		try {
			//Read the incoming Json
			InputStreamReader ir = new InputStreamReader(socket.getInputStream());
			BufferedReader br = new BufferedReader(ir);
			System.out.println(br.readLine());
			//TODO block for accept and send a signal to start transfer
			//Read the file from the stream
			InputStream inputStream = socket.getInputStream();
			fileOutputStream = new FileOutputStream(file);
			byte[] byteArray = new byte[1024*1024];
			int length; 
			while((length = inputStream.read(byteArray)) != -1){
				System.out.println(length);
				fileOutputStream.write(byteArray, 0, length); 
				
			}
			fileOutputStream.flush(); 
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			try {
				socket.close();
			} catch (IOException e1) {
			} 
			try {
				fileOutputStream.close();
			} catch (IOException e) {
			} 
		}
		long end = System.currentTimeMillis(); 
		System.out.println(end-start);
	}

}
