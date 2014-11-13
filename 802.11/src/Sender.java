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
		int bytes;
		int sent;
		while(true) {
			while(sendQueue.peek() != null){
			//wait until the rf channel is clear before begin sending
			while(therf.inUse()){
				Thread.sleep(100);
			}
			
			
			bytes = sendQueue.size();
			sent = therf.transmit(sendQueue.take().getByteArray());

			//compares bytes sent to bytes in the packet
			if(bytes != sent)
			{
				System.err.println("Error! couldn't send all the bytes");
			}else{
				System.err.println("Sent a packet");
			}
			
			Thread.sleep(250);
			}

		}
		
	}



}