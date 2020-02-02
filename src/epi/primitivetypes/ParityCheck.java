package epi.primitivetypes;

public class ParityCheck {

	public static short parity(long x) {
		short parity = 0;
		while(x != 0) {
			if(x % 2 == 1)
				parity++;
			x = x>>1;
		}
		return parity;
	}
	
	public static short parityXOR(long x) {
		x ^= x >>> 32;
		x ^= x >>> 16;
		x ^= x >>> 8;
		x ^= x >>> 4;
		x ^= x >>> 2;
		x ^= x >>> 1;
		
		return (short) (x & 0x1);
	}
	
	public static void main(String[] args) {
		System.out.println(parityXOR(6));
		System.out.println(2^1);
	}
}
