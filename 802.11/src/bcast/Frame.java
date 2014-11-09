package bcast;
import java.util.*;

public class Frame {
	// whole message
	
	private byte[] control;
	private int destAddr;
	private int srcAddr;
	private byte[] data;
	private byte[] CRC;
	
	
	// constructor for CHECKPOINT 2
	// create a frame with type Data, 
	// a sequence number of zero, and with the retry bit set to zero (off).
	public Frame(){
		contInit();
		
	}
	
	private byte[] contInit(){
		byte[] control;
		BitSet temp = new BitSet(16);
		// temp.set(0, true);
		
		System.out.println(temp.toString());
		control = temp.toByteArray();
		
		return control;
	}
	
	public String toString(){
		String frame;
		frame = "";
		
		return frame;
	}
}
