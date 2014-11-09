package bcast;
import rf.RF;
import java.util.*;

public class Sender implements runnable{


private ArrayBlockingQueue<Frame> sendQueue;
private RF therf;

	public Sender(ArrayBlockingQueue<Frame> q, RF rf)
	{
		therf = rf;
		sendQueue = q;
	}

	public void run()
	{
		System.out.println("Sender is running");
		int sent;
		int bytes;
		while(true)
		{
			bytes = sendQueue.peek().size();
			sent = therf.transmit(sendQueue.take());

			//compares bytes sent to bytes in the packet
			if(bytes != sent)
			{
				System.err.println("Error! couldn't send all the bytes");
			}

		}
	}



}