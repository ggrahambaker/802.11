package bcast;
import java.util.*;

public class Frame {
	// CONSTANTS 

	// whole message
	
	private byte[] control;
	private int destAddr;
	private int srcAddr;
	private byte[] data;
	private byte[] CRC;
	
	
	// constructor for CHECKPOINT 2

	public Frame(int destAddr, int scrAddr){
		contInit();
		
		checkSumInit();
		
	}


	
	// create the control portion with type Data, 
	// a sequence number of zero, and with the retry bit set to zero (off).
	private byte[] contInit(){
		byte[] control;
		BitSet temp = new BitSet(16);
		
		System.out.println(temp.toString());
		control = temp.toByteArray();
		
		return control;
	}
	
	private byte[] checkSumInit(){
		byte[] cs;
		BitSet temp = new BitSet(32);
		temp.set(0, 32, true);
		
		System.out.println(temp.toString());
		cs = temp.toByteArray();
		
		return cs;
	}
	
	public String toString(){
		String frame;
		frame = "";
		
		return frame;
	}

	public int getDestAddr()
	{
		return destAddr;
	}

	public int size()
	{
		int theSize;//the total number of bytes in the packet. This will be needed in the sender for error checking.

		return theSize;
	}
}
