package transfer;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;


import fooSharing.Computer;

public class Sender {
	static int port = 10000;
	static String address = "127.0.0.1";
	static String filePath = "C:\\Users\\user\\test.txt";

	private static void sendFile(Socket socket, File file) throws IOException {
		FileInputStream fStream = new FileInputStream(file);

		BufferedOutputStream out = new BufferedOutputStream(
				socket.getOutputStream());
		PrintWriter pw = new PrintWriter(socket.getOutputStream());
		pw.write(filePath);
		byte[] buf = new byte[1024 * 1024];
		int bytesRead;
		while ((bytesRead = fStream.read(buf)) > 0) {
			out.write(buf, 0, bytesRead);
		}
		out.close();
		socket.close();
		fStream.close();
		System.out.println("DONE!");

	}

	public static void sendFile(Computer computer, File file) {
		try {
			Socket connection = new Socket(computer.getIp(), port);
			sendFile(connection, file);

		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static boolean clearToSend(String name) {
		// TODO
		return true;
	}

	public static void main(String[] args) throws UnknownHostException,
			IOException {
		Socket connection = new Socket(address, port);
		File file = new File(filePath);
		sendFile(connection, file);
	}

}
