package stack;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FloodFill {
	
	public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
		return floodFill(image, sr, sc, newColor, new HashSet<Integer>());
    }
	
	private int[][] floodFill(int[][] image, int sr, int sc, int newColor, Set<Integer> visited) {
		int COLUMN = image[0].length;
		
		visited.add(value(COLUMN, sr, sc));
		
		List<int[]> neighbours = neighbours(image, sr, sc);
		for(int[] neighbour: neighbours) {
			if(!visited.contains(value(COLUMN, neighbour[0], neighbour[1]))) {
				floodFill(image, neighbour[0], neighbour[1], newColor, visited);
			}
		}
		
		image[sr][sc] = newColor;
		
		return image;
	}
	
	private List<int[]> neighbours(int[][] image, int sr, int sc) {
		int ROW = image.length;
		int COLUMN = image[0].length;
		
		List<int[]> neighbours = new ArrayList<int[]>();
		
		int value = image[sr][sc];
		
		// Top
		for(int i = sr; i >= 0; i--) {
			if(value == image[i][sc]) {
				int[] array = {i, sc};
				neighbours.add(array);
			}
			else {
				break;
			}
		}
		
		// Right
		for(int i = sc; i < COLUMN; i++) {
			if(value == image[sr][i]) {
				int[] array = {sr, i};
				neighbours.add(array);
			}
			else {
				break;
			}
		}
		
		// Bottom
		for(int i = sr; i < ROW; i++) {
			if(value == image[i][sc]) {
				int[] array = {i, sc};
				neighbours.add(array);
			}
			else {
				break;
			}
		}
		
		// Left
		for(int i = sc; i >= 0; i--) {
			if(value == image[sr][i]) {
				int[] array = {sr, i};
				neighbours.add(array);
			}
			else {
				break;
			}
		}
		
		return neighbours;
	}
	
	private int value(int column, int i, int j) {
		return (i * column) + j;
	}
	
	private static void print(int[][] array) {
		int ROW = array.length;
		int COLUMN = array[0].length;
		for(int i = 0; i < ROW; i++) {
			for(int j = 0; j < COLUMN; j++) {
				System.out.print(array[i][j] + ", ");
			}
			
			System.out.println();
		}
	}
	
	public static void main(String[] args) {
		int[][] image = {
				{1,1,1},
				{1,1,0},
				{1,0,1}
		};
		
		FloodFill solution = new FloodFill();
		int[][] result = solution.floodFill(image, 1, 1, 2);
		
		print(result);
	}
}
