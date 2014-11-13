import java.util.*;
import java.util.concurrent.ArrayBlockingQueue;

import rf.RF;


public class Receiver implements Runnable {

	private RF rf;
	private ArrayBlockingQueue<byte[]> received;
	
	//receiver class constructor
	public Receiver(RF rf){
		this.rf = rf;
		received = new ArrayBlockingQueue<byte[]>(10);
	}
	
	@Override
	public void run() {
		while(true){
			
		byte[] incPacket = 	rf.receive();
		try {
			received.put(incPacket);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
			
			
		}
	}
	
	
	
	

}
