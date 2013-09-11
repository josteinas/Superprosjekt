package transfer;

import java.net.Socket;
import java.util.Collection;
import java.util.Iterator;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

public class RequestHandler {
	
	BlockingQueue<Socket> blockingQueue; 
	
	public RequestHandler(){
		blockingQueue = new ArrayBlockingQueue<>(100); 
	}

}
