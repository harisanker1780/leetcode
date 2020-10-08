package hackerearth;



import java.io.BufferedReader;
import java.io.InputStreamReader;

//import for Scanner and other utility classes
import java.util.*;

public class Maximum {

	   public static void main(String args[] ) throws Exception {
		    
	        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        String line = br.readLine();                // Reading input from STDIN
	        int N = Integer.parseInt(line);

	        HashMap<Integer, ArrayList<Integer>> map = new HashMap<Integer, ArrayList<Integer>>();

	        String[] str = br.readLine().split(" ");
	        int[] a = new int[N];
	        for(int i = 0; i < N; i++) {
	            a[i] = Integer.parseInt(str[i]);
	        }

	        int T = Integer.parseInt(br.readLine().trim());
	        int[] tests = new int[T];
	        String[] strTest = br.readLine().split(" ");
	        for(int i = 0; i < T; i++) {
	            tests[i] = Integer.parseInt(strTest[i]);
	        }

	        for(int i = 0; i < T; i++) {
	            int test = tests[i];
	            if(!map.containsKey(test)) {
	                map.put(test, new ArrayList<Integer>());
	            }
	        }

	        int[] leftCount = new int[N];
	        int[] rightCount = new int[N];

	        leftCount[0] = 0;
	        
	        if(map.containsKey(a[0])) {
	            map.get(a[0]).add(0);
	        }

	        Stack<Node> stack = new Stack<Node>();
	        stack.push(new Node(a[0], 0));
	        for(int i = 1; i < N; i++) {
	            int count = 0;
	            while(!stack.isEmpty() && stack.peek().val <= a[i]) {
	                count += 1 + stack.pop().count;
	            }
	            stack.push(new Node(a[i], count));
	            leftCount[i] = count;

	            if(map.containsKey(a[i])) {
	                map.get(a[i]).add(i);
	            }
	        }

	        stack.clear();
	        stack.push(new Node(a[N - 1], 0));
	        rightCount[N - 1] = 0;

	        for(int i = N - 2; i >= 0; i--) {
	            int count = 0;
	            while(!stack.isEmpty() && stack.peek().val < a[i]) {
	                count += 1 + stack.pop().count;
	            }

	            stack.push(new Node(a[i], count));
	            rightCount[i] = count;
	        }

	        for(int i = 0; i < T; i++) {
	            int count = 0;
	            ArrayList<Integer> list = map.get(tests[i]);
	            for(Integer index : list) {
	                int L = leftCount[index];
	                int R = rightCount[index];
	                count += 1 + (L + R) + (L * R);
	            }

	            System.out.println(count);
	        }
	    }

	    static class Node {
	        int val;
	        int count;
	        public Node(int val, int count) {
	            this.val = val;
	            this.count = count;
	        }
	    }
}
