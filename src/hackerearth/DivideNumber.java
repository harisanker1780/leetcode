package hackerearth;

import java.util.ArrayList;
import java.util.List;

public class DivideNumber {
	
	public static void main(String[] args) {
		long N = 20;
		long[] factors = factors(N);
        long result = divide(N, 4, N, factors, 0, 1);
        System.out.println(result);
	}

	 private static long divide(long N, int rCount, long rNum, long[] factors, long fIndex, long result) {

		  	if(rNum <= 0) {
	            return -1;
	        }
		  
	        if(rCount == 1) {
	            if(N % rNum == 0) {
	                return result * rNum;
	            } else {
	                return -1;
	             }
	        }

	        long max = -1;
	        for(int i = (int)fIndex; i < factors.length; i++) {
	            long f = factors[i];
	            long r = divide(N, rCount - 1, rNum - f, factors, i, result * f);
	            if(r > max) {
	                max = r;
	            }
	        }

	        return max;
	    }

	    private static long[] factors(long N) {
	        List<Long> factors = new ArrayList<Long>();
	        for (long i=1; i<=Math.sqrt(N); i++) 
	        { 
	            if (N%i==0) 
	            { 
	                if (N/i == i)  {
	                    factors.add(i);
	                } else {
	                    factors.add(i);
	                    factors.add(N/i);
	                }
	            } 
	        } 

	        long[] array = new long[factors.size()];
	        for(int i = 0; i < factors.size(); i++) {
	            array[i] = factors.get(i);
	        }
	        
	        return array;
	    }
}
