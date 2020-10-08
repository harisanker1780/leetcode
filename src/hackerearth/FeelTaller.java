package hackerearth;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class FeelTaller {
	
    public static void main(String args[] ) throws Exception {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();                // Reading input from STDIN
        int K = Integer.parseInt(line);

        String[] str = br.readLine().split(" ");
        int[] heights = new int[K];
        for(int i = 0; i < K; i++) {
            heights[i] = Integer.parseInt(str[i]);
        }
        
        int[] next = new int[K];
        Stack<Integer> stack = new Stack<Integer>();
        for(int i = 0; i < K; i++) {
        	while(!stack.isEmpty() && heights[i] > heights[stack.peek()]) {
        		next[stack.pop()] = i;
        	}
        	
        	stack.push(i);
        }
        
        while(!stack.isEmpty()) {
        	next[stack.pop()] = K;
        }
        
        int Q = Integer.parseInt(br.readLine().trim());
        for(int i = 0; i < Q; i++) {
            String[] q = br.readLine().split(" ");
            int l = Integer.parseInt(q[0]);
            int r = Integer.parseInt(q[1]);
            
            int count = 0;
            while(l <= r) {
            	l = next[l];
            	count++;
            }
            
            System.out.println(count);
        }

    }
}
