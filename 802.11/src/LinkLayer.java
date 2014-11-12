import java.util.concurrent.ArrayBlockingQueue;
import rf.RF;
public class LinkLayer {

private ArrayBlockingQueue sendQueue;

	public LinkLayer()
	{
		System.out.println("LinkLayer up and running.");
	}

	public int send(short dest, byte[] data, int len)
	{

		return -1;
	}

}