import java.util.BitSet;
import rf.RF;

public class Tester {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("HAIIS");
		
		byte[] cs;
		BitSet temp = new BitSet(80);
		temp.set(0, 80, true);
		
		System.out.println(temp.toString());
		cs = temp.toByteArray();
		System.out.println(cs.length);
		Frame frame = new Frame((short)0, (short)0, cs, cs.length);
		frame.printFields();

		// Frame f = new Frame((short)100, (short)200, cs, cs.length);
		// f.printFields();
		// System.out.println(f.toString());

	}

}
