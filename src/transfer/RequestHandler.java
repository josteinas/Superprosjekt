package transfer;

import java.net.Socket;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

public class RequestHandler implements Runnable{
	
	private static BlockingQueue<Socket> blockingQueue; 
	
	public RequestHandler(BlockingQueue<Socket> blockingQueue){
		this.blockingQueue = blockingQueue;
	}

	@Override
	public void run() {
		while(true){
			try {
				Socket client = blockingQueue.take();
				//TODO
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	

	
	public synchronized static void addSocket(Socket socket){
		try {
			while(!blockingQueue.offer(socket, 100, TimeUnit.MILLISECONDS));
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
