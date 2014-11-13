import java.nio.ByteBuffer;
import java.nio.ByteOrder;
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


	// constructor for CHECKPOINT 2

	public Frame(short destAddr, short scrAddr, byte[] data, int len){
		
		// bytes of data in frame
		this.length = len;
		
		// make the byte buffer as we go
		this.bb = ByteBuffer.allocate(MIN_SIZE + this.length);
		
		// 2 bytes
		this.control = contInit();
		this.bb.put(this.control, 0, this.control.length);
		
		// 2 bytes 
		this.destAddr = addrConverter(destAddr);
		this.bb.put(this.destAddr, 2, this.destAddr.length);
		
		// 2 bytes 
		this.srcAddr = addrConverter(scrAddr);
		this.bb.put(this.srcAddr, 4, this.srcAddr.length);
		
		// len bytes 
		this.data = data;
		this.bb.put(this.data, 6, this.data.length);
		
		// 4 bytes 
		this.crc = checkSumInit();
		this.bb.put(this.crc, (6 + this.length), this.crc.length);
		
		// now put it together
		this.frameData = this.bb.array();
	}
	
	

	

	// create the control portion with type Data, 
	// a sequence number of zero, and with the retry bit set to zero (off).
	private byte[] contInit(){
		byte[] control;
		BitSet temp = new BitSet(16);
		
		// System.out.println(temp.toString());
		control = temp.toByteArray();
		
		return control;
	}
	
	
	
	private short bytesToShort(byte b1, byte b2){
		
		ByteBuffer bb = ByteBuffer.allocate(2);
		bb.order(ByteOrder.LITTLE_ENDIAN);
		bb.put(b1);
		bb.put(b2);
		short shortVal = bb.getShort(0);
		return shortVal;
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
	public byte[] take(){
		byte[] toRet = frameData;
		return toRet;
	}



}
