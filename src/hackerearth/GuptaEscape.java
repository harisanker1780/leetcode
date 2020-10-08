package hackerearth;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class GuptaEscape {
	
    public static void main(String args[] ) throws Exception {
    	
    	System.out.println(Long.MAX_VALUE);

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();                // Reading input from STDIN
        
        int T = Integer.parseInt(line);
        for(int t = 0; t < T; t++) {

            PriorityQueue<Node> queue = new PriorityQueue<Node>();

            int N = Integer.parseInt(br.readLine());
            for(int i = 0; i < (N + 1); i++) {
                String[] str = br.readLine().split(" ");
                int distance = Integer.parseInt(str[0]);
                int fuel = Integer.parseInt(str[1]);

                Node node  = new Node(distance, fuel);
                queue.add(node);
            }

            queue.add(new Node(0, 0));

            PriorityQueue<Integer > fuelQueue = new PriorityQueue<Integer>(new Comparator<Integer>() {
					@Override
					public int compare(Integer o1, Integer o2) {
						if(o1 < o2) {
							return 1;
						} else if(o1 > o2) {
							return -1;
						} else {
							return 0;
						}
					}
			});
            
            int count = -1;
            int fuel = 0;
            int fuelReq = 0;
            while(!queue.isEmpty()) {
                while(!queue.isEmpty() && fuelReq <= fuel) {
                    Node node = queue.poll();
                    fuelQueue.add(node.fuel);

                    fuel = fuel - fuelReq;
                    fuelReq = node.distance - (queue.isEmpty() ? 0 : queue.peek().distance);
                }

                while(fuelReq > fuel && !queue.isEmpty() && !fuelQueue.isEmpty()) {
                	fuel += fuelQueue.poll();
                	count++;
                }
                
                if(fuelReq > fuel) {
                	break;
                }
            }

            if(queue.isEmpty()) {
                System.out.println(count);
            } else {
                System.out.println(-1);
            }
            
        }
    }

	static class Node implements Comparable<Node> {
	        public int distance;
	        public int fuel;

	        public Node(int distance, int fuel) {
	            this.distance = distance;
	            this.fuel = fuel;
	        }

			@Override
			public int compareTo(Node o) {
				  if(this.distance < o.distance) {
                      return 1;
                  } else if(this.distance > o.distance) {
                      return -1;
                  } else {
                      return 0;
                  }
			}
	}

}
