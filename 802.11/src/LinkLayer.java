import java.util.concurrent.ArrayBlockingQueue;
import rf.RF;
import wifi.*;

public class LinkLayer {

private ArrayBlockingQueue sendQueue;
private ArrayBlockingQueue<byte[]> received;

	public LinkLayer()
	{
		System.out.println("LinkLayer up and running.");
		
		received = new ArrayBlockingQueue<byte[]>(10);
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
	
	public int recv(Transmission t){
		if(received.peek()!=null){
			Frame packet = new Frame(received.take());
		
		t.setDestAddr(packet.getDest());
		t.setSrcAddr(packet.getSrc());
		t.setData(packet.getData());
		}
	}
	
	

//    This function provides a mechanism to pass command or configuration data to an 802.11~ layer at runtime. One could use it to enable or disable debugging output on-the-fly, change system parameters, or prompt the 802.11~ layer to summarize network activity, for example. Note: User-defined command code values should be greater than 10. A compliant 802.11~ implementation must support the following commands:
//
//    Command 0: Options and settings
//        Should summarize all command options and report their current settings. The accompanying value parameter is ignored.
//
//    Command 1: Debug level.
//        The meaning of non-zero values can be implementation dependent, but passing a value of 0 should disable all debugging output.
//
//    Command 2: Slot selection.
//        If the accompanying value parameter is 0 the link layer should select slots randomly. Any other value should cause the link layer to always select maxCW.
//
//    Command 3: Beacon interval.
//        The accompanying value specifies the desired number of seconds between the start of beacon transmissions. A value of -1 should disable the sending of beacon frames. 
//	
	public int command(int cmd, int val){
		
		return 0;
	}

}