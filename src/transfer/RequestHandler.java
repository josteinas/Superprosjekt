package transfer;

import java.net.Socket;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class RequestHandler implements Runnable{
	
	private static BlockingQueue<Socket> blockingQueue; 
	
	public RequestHandler(){
		if (blockingQueue != null){
			System.out.println("Trying to create a new blockingQueue");
		}else {
			blockingQueue = new ArrayBlockingQueue<>(100); 
		}
	}

	@Override
	public void run() {
		while(true){
			if(blockingQueue.isEmpty()){
				try {
					wait(50);
				} catch (InterruptedException e) {
					System.out.println("InterruptedException in RequestHandler ");
				} 
			}else {
				//TODO
			}
		}
	}
	
	public static BlockingQueue<Socket> getBlockingQueue(){
		if(blockingQueue == null){
			(new Thread(new RequestHandler())).start(); 
		}
		return blockingQueue;
	}
	
	public static void addSocket(Socket socket){
		if(blockingQueue == null){
			(new Thread(new RequestHandler())).start(); 
		}
		blockingQueue.add(socket);
	}

}
