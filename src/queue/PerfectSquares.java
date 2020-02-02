package queue;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class PerfectSquares {
	
	public int numSquares(int n) {
		int minCount = Integer.MAX_VALUE;
		Queue<Node> queue = new LinkedList<Node>();
		queue.add(new Node(n, 0, 0));
		
		while(!queue.isEmpty()) {
			Node cur = queue.poll();
			if(cur.sum == n && cur.count < minCount) {
				minCount = cur.count;
			}
			
			if(cur.count + 1 < minCount) {
				List<Node> neighbours = neighbours(n, cur.value, cur.sum, cur.count); 
				for(Node node: neighbours) {
					queue.add(node);
				}
			}
		}
		
		return minCount;
    }
	
	private List<Node> neighbours(int num, int value, int sum, int count) {
		List<Node> neighbours = new ArrayList<Node>();
		int i = 1;
		while(true) {
			int pow = (int)Math.pow(i, 2);
			
			if(pow > value || (pow + sum) > num) {
				break;
			}
			
			neighbours.add(new Node(pow, count + 1, sum + pow));
			i++;
		}
		return neighbours;
	}
	
	private class Node {
		int value, count, sum;
		public Node(int value, int count, int sum) {
			this.value = value;
			this.count = count;
			this.sum = sum;
		}
	}
	
	public static void main(String[] args) {
		PerfectSquares solution = new PerfectSquares();
		System.out.println(solution.numSquares(7168));
	}
}
