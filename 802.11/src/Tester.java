import java.util.BitSet;

import rf.RF;
public class Tester {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		System.out.println("HAIIS");
		
		byte[] cs;
		BitSet temp = new BitSet(160);
		temp.set(0, 80, true);
		
		// System.out.println(temp.toString());
		cs = temp.toByteArray();
		

		Frame f = new Frame((short)100, (short)200, cs, cs.length);
		f.printFields();
		System.out.println(f.toString());

	}

}
