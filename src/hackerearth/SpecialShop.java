package hackerearth;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class SpecialShop {
	
    public static void main(String args[] ) throws Exception {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();                // Reading input from STDIN
        int T = Integer.parseInt(line);
        for(int t = 0; t < T; t++) {
            String[] str = br.readLine().split(" ");
            int N = Integer.parseInt(str[0]);
            int A = Integer.parseInt(str[1]);
            int B = Integer.parseInt(str[2]);

            long result = search(A, B, 0, N, N);
            
            System.out.println(result);
        }
    }
    
    private static long search(int A, int B, int leftIndex, int rightIndex, int N) {
    	if(leftIndex <= rightIndex) {
    		int midIndex = (leftIndex + rightIndex) / 2;
    		long midVal = value(A, B, N, midIndex);
    		
    		long leftMidVal = midVal;
			int leftMidIndex = (leftIndex + midIndex) / 2;
			leftMidVal = value(A, B, N, leftMidIndex);
			if(leftMidVal >= midVal) {
				leftMidVal = search(A, B, leftMidIndex + 1, midIndex, N);
			} else {
				leftMidVal = search(A, B, leftMidIndex, midIndex - 1, N);
			}
    		
    		long rightMidVal = midVal;
			int rightMidIndex = (midIndex + rightIndex) / 2;
			rightMidVal = value(A, B, N, rightIndex);
			if(rightMidVal >= midVal) {
				rightMidVal = search(A, B, midIndex, rightMidIndex - 1, N);
			} else {
				rightMidVal = search(A, B, midIndex + 1, rightMidIndex, N);
			}
    		
    		return Math.min(midVal, Math.min(leftMidVal, rightMidVal));
    	}
    	
    	return Long.MAX_VALUE;
    }
    
    public static long value(int A, int B, int N, int index) {
    	long midVal = A * (long)Math.pow(index, 2) + B * (long)Math.pow(N - index, 2);
    	return midVal;
    }


}
