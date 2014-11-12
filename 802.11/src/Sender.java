import rf.RF;
import java.util.*;
import java.util.concurrent.ArrayBlockingQueue;

public class Sender implements Runnable{


private ArrayBlockingQueue<Frame> sendQueue;
private RF therf;

	public Sender(ArrayBlockingQueue<Frame> q, RF rf) {
		therf = rf;
		sendQueue = q;
	}

	public void run() {
		System.out.println("Sender is running");
		
		
//		int bytes;
//		while(true) {
//			bytes = sendQueue.size();
//			sent = therf.transmit(sendQueue.take());
//
//			//compares bytes sent to bytes in the packet
//			if(bytes != sent)
//			{
//				System.err.println("Error! couldn't send all the bytes");
//			}
//
//		}
		
	}



}