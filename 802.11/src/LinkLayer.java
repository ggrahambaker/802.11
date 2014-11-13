import java.util.concurrent.ArrayBlockingQueue;
import rf.RF;
public class LinkLayer {

private ArrayBlockingQueue sendQueue;

	public LinkLayer()
	{
		System.out.println("LinkLayer up and running.");
		
		sendQueue = new ArrayBlockingQueue<Frame>(10);
		RF rf = new RF(null,null);
		
		
		new Thread(new Sender(sendQueue,rf));
		new Thread(new Receiver(rf));
		
		while(true);
	}

	public int send(short dest, byte[] data, int len)
	{

		return -1;
	}

}