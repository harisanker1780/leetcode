package epi.primitivetypes;

public class SwapBits {
	
	public static long swapBits(long x, int i, int j) {
		
		// Check whether the bits at positions i and j are different.
		if(((x >>> i) & 1) != ((x >>> j) & 1)) {
			long bitMask = (1L << i) | (1L << j);
			return x ^= bitMask;
		}
		
		return x;
	}
	
	public static void main(String[] args) {
		System.out.println(swapBits(73, 6, 1));
	}

}
