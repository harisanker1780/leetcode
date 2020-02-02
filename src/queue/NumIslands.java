package queue;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class NumIslands {
	
	public int numIslands(char[][] grid) {
        
		if(grid == null)
			return 0;
		
		int numIslands = 0;
		
		int ROW = grid.length;
		if(ROW == 0) 
			return 0;
		
		int COLUMN = grid[0].length;
		if(COLUMN == 0)
			return 0;
	
		Queue<Integer> queue = new LinkedList<Integer>();
		Set<Integer> visited = new HashSet<Integer>();
		for(int i = 0; i < ROW; i++) {
			for(int j = 0; j < COLUMN; j++) {
				
				int num = num(i, j, COLUMN);
				
				if(grid[i][j] == '1' && !visited.contains(num)) {
					queue.add(num);
					visited.add(num);
					numIslands++;
				}
				
				while(!queue.isEmpty()) {
					int node = queue.poll();
					for(int ne: neighbours(node, ROW, COLUMN, grid)) {
						if(!visited.contains(ne)) {
							visited.add(ne);
							queue.add(ne);
						}
					}
				}
			}
		}
		
		return numIslands;
    }
	
	private int num(int i, int j, int col) {
		return (i * col) + j; 
	}
	
	private List<Integer> neighbours(int num, int row, int col, char[][] grid) {
		int i = num / col;
		int j = num - (i * col);
		
		List<Integer> neighbours = new ArrayList<Integer>();
		
		if(j > 0 && grid[i][j - 1] == '1')
			neighbours.add(num(i, j - 1, col));
		if(j < (col - 1) && grid[i][j + 1] == '1')
			neighbours.add(num(i, j + 1, col));
		if(i > 0 && grid[i - 1][j] == '1')
			neighbours.add(num(i - 1, j, col));
		if(i < (row - 1) && grid[i + 1][j] == '1') {
			neighbours.add(num(i + 1, j, col));
		}
		
		return neighbours;
	}
	
	public static void main(String[] args) {
		NumIslands sol = new NumIslands();
		/*char[][] input = {
				{'1', '1', '0', '0', '0'},
				{'1', '1', '0', '0', '0'},
				{'0', '0', '1', '0', '0'},
				{'0', '0', '0', '1', '1'}
		};*/
		
		/*char[][] input = {
				{'1', '1', '1', '1', '0'},
				{'1', '1', '0', '1', '0'},
				{'1', '1', '0', '0', '0'},
				{'0', '0', '0', '0', '0'}	
		};*/
		
		char[][] input = {{}};
		
		System.out.println(sol.numIslands(input));
	}
}
