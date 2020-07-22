package test;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 
 * Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right which minimizes the sum of all numbers along its path.

Note: You can only move either down or right at any point in time.

Example:

Input:
[
  [1,3,1],
  [1,5,1],
  [4,2,1]
]
Output: 7
Explanation: Because the path 1->3->1->1->1 minimizes the sum.
 *
 */
public class MinimumPathSum {
	
	public int minPathSum(int[][] grid) {
		
		if(grid == null)
			return 0;
		
		int R = grid.length;
		int C = grid[0].length;
		
		if(R == 0 || C == 0)
			return 0;
		
		boolean[][] visited = new boolean[R][C];
		int[][] distance = new int[R][C];
		
		for(int i = 0; i < R; i++) {
			for(int j = 0; j < C; j++) {
				distance[i][j] = Integer.MAX_VALUE;
			}
		}
		
		visited[0][0] = true;
		distance[0][0] = grid[0][0];
		
		PriorityQueue<Node> heap = new PriorityQueue<Node>(new Comparator<Node> () {
		    public int compare(Node a, Node b) {
		        return a.distance - b.distance;
		     }
		});
		
		heap.add(new Node(0, 0, distance[0][0]));
		
		while(!heap.isEmpty()) {
			Node n = heap.poll();
			visited[n.i][n.j] = true;
			
			if(n.i < (R - 1) && !visited[n.i + 1][n.j]
					&& distance[n.i + 1][n.j] > (distance[n.i][n.j] + grid[n.i + 1][n.j])) {
				distance[n.i + 1][n.j] = distance[n.i][n.j] + grid[n.i + 1][n.j];
				heap.add(new Node(n.i + 1, n.j, distance[n.i + 1][n.j]));
			}
			
			if(n.j < (C - 1) && !visited[n.i][n.j + 1]
					&& distance[n.i][n.j + 1] > (distance[n.i][n.j] + grid[n.i][n.j + 1])) {
				distance[n.i][n.j + 1] = distance[n.i][n.j] + grid[n.i][n.j + 1];
				heap.add(new Node(n.i, n.j + 1, distance[n.i][n.j + 1]));
			}
		}
		
		return distance[R-1][C-1];

    }
	
	class Node {
		
		int i, j, distance;
		
		public Node(int i, int j, int distance) {
			this.i = i;
			this.j = j;
			this.distance = distance;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + i;
			result = prime * result + j;
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Node other = (Node) obj;
			if (i != other.i)
				return false;
			if (j != other.j)
				return false;
			return true;
		}
	}
	
	public static void main(String[] args) {
		MinimumPathSum sol = new MinimumPathSum();
		int[][] input = {
				{1,3,1},
				{1,5,1},
				{4,2,1}
		};
		
//		int[][] input = {
//				{1, 2},
//				{5, 6},
//				{1, 1}
//				
//		};
		
		System.out.println(sol.minPathSum(input));
	}

}
