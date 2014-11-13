import java.nio.ByteBuffer;
import java.util.*;

public class Frame {
	// CONSTANTS 

	private static final int MIN_SIZE = 10;

	// pieces
	private int length;
	private byte[] control;
	private byte[] destAddr;
	private byte[] srcAddr;
	private byte[] data;
	private byte[] crc;

	// the whole frame
	// these 2 fields should represent the same thing
	private byte[] frameData;
	private ByteBuffer bb;
	
	public Frame(){
		
	}
	
	// constructor for CHECKPOINT 2

	public Frame(short destAddr, short scrAddr, byte[] data, int len){
		
		// bytes of data in frame
		System.out.println(data.length);
		this.length = data.length;
		
		// frameData = new byte[data.length + MIN_SIZE];
		
		// make the byte buffer as we go
		this.bb = ByteBuffer.allocate(this.length + MIN_SIZE);
		
		// 2 bytes
		this.control = contInit();
		System.out.println(this.control.length + " -- control leng");
		this.bb.put(this.control);
		
		
		// 2 bytes 
		this.destAddr = addrConverter(destAddr);
		System.out.println(this.destAddr.length + " --- dest addr");
		this.bb.put(this.destAddr);
		
		// 2 bytes 
		this.srcAddr = addrConverter(scrAddr);
		System.out.println(this.srcAddr.length + " --- src addr");
		this.bb.put(this.srcAddr);
		
		// len bytes 
		this.data = data;
		this.bb.put(this.data);
		
		// 4 bytes 
		this.crc = checkSumInit();
		this.bb.put(this.crc);
		
		// now put it together
		this.frameData = this.bb.array();
	}


	// create the control portion with type Data, 
	// a sequence number of zero, and with the retry bit set to zero (off).
	private byte[] contInit(){
		// byte[] control;// = new byte[2];
		byte[] bytes = new byte[2];
		Arrays.fill( bytes, (byte) 0 );
		return bytes;
	}
	
	private byte[] checkSumInit(){
		byte[] cs;
		BitSet temp = new BitSet(32);
		temp.set(0, 32, true);
		
		System.out.println(temp.toString());
		cs = temp.toByteArray();
		
		return cs;
	}

	private byte[] addrConverter(short mac){
		int macAddr = (int) mac;
		ByteBuffer bb = ByteBuffer.allocate(2);
		byte[] ma = ByteBuffer.allocate(4).putInt(macAddr).array();
		bb.put(ma[2]);
		bb.put(1, ma[3]);

		return bb.array();
	}

	// return this frame, with the retransmission bit changed

	public String toString(){		
		return this.bb.toString();
	}
	public void printFields(){
		System.out.println("Data length -- >" + this.length); 

		// System.out.println();
		// this.control 
		// this.destAddr
		// this.scrAddr 
		// this.data
		// this.crc 
	}
	public int size(){
		return frameData.length;
	}
	
	// get the frame data
	public byte[] getByteArray(){
		byte[] toRet = frameData;
		return toRet;
	}



}
