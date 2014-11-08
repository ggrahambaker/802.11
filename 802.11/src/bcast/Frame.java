package bcast;
import java.util.*;

public class Frame {
	// whole message
	
	private BitSet control;
	private int destAddr;
	private int srcAddr;
	private byte[] data;
	private byte[] CRC;
	
	public Frame(){
		
	}
}
