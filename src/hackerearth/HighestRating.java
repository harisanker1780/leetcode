package hackerearth;

import java.io.*;
import java.util.*;

public class HighestRating {
	
    public static void main(String[] args) throws IOException {
    	
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter wr = new PrintWriter(System.out);
         int M = Integer.parseInt(br.readLine().trim());
         int Q = Integer.parseInt(br.readLine().trim());
         int N = Integer.parseInt(br.readLine().trim());
         String[] arr_arr = br.readLine().split(" ");
         int[] arr = new int[N];
         for(int i_arr=0; i_arr<arr_arr.length; i_arr++)
         {
         	arr[i_arr] = Integer.parseInt(arr_arr[i_arr]);
         }
 
         int out_ = findHighestRating(Q, arr, M);
         System.out.println(out_);
 
         wr.close();
         br.close();
    }
 
    static int findHighestRating(int Q, int[] arr, int M){
        
        int N = arr.length;
        int maxVal = 0;
        int minVal = Integer.MAX_VALUE;
 
        // Build freq map 
        HashMap<Integer, Integer> freqMap = new HashMap<Integer, Integer>();
        for(int i = 0; i < N; i++) {
            if(!freqMap.containsKey(arr[i])) {
                freqMap.put(arr[i], 0);
            }
 
            freqMap.put(arr[i], freqMap.get(arr[i]) + 1);
 
            if(arr[i] > maxVal) {
                maxVal = arr[i];
            }
 
            if(arr[i] < minVal) {
                minVal = arr[i];
            }
        }
 
        int maxCount = 0;
        for(int i = 0; i < N; i++) {
            int val = arr[i];
            int count = freqMap.get(val);
            val += M;
            count += freqMap.containsKey(val) ? freqMap.get(val) : 0;
            int j = 1;
            while(j < Q) {
                val = val + M;
                if(val > maxVal) {
                    break;
                } else {
                    count += freqMap.containsKey(val) ? freqMap.get(val) : 0;
                }
                j++;
            }
 
            val = arr[i] - M;
            count += freqMap.containsKey(val) ? freqMap.get(val) : 0;
            j = 1;
            while(j < Q) {
                val = val - M;
                if(val < minVal) {
                    break;
                } else {
                    count += freqMap.containsKey(val) ? freqMap.get(val) : 0;
                }
                j++;
            }
 
            if(count > maxCount)
                maxCount = count;
        }
 
        return maxCount;
    }

}
