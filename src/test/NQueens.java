package test;

import java.util.ArrayList;

public class NQueens {
	
	public static void main(String[] args) {
		
		ArrayList<Cell> cells = new ArrayList<Cell>();
		place(4, 0, cells);
		
		for(Cell cell : cells) {
			System.out.println("{" + cell.i + ", " + cell.j + "}");
		}
	}
	
	private static void place(int n, int row, ArrayList<Cell> cells) {
		
		if(row >= n)
			return;
		
		int j = 0;
		while(j < n) {
			if(cells.size() > row)
				break;
			
			if(canPlace(n, cells, row, j)) {
				cells.add(new Cell(row, j));
				place(n, row + 1, cells);
			}
			
			j++;
		}
		
		if(j == n && cells.size() < n)
			cells.remove(cells.size() - 1);

	}
	
	private static boolean canPlace(int n, ArrayList<Cell> cells, int i, int j) {
		for(Cell cell : cells) {
			if(cell.j == j) {
				return false;
			}
			
			if(isInDiagonal(n, cell.i, cell.j, i, j)) {
				return false;
			}
		}
		
		return true;
	}
	
	private static boolean isInDiagonal(int n, int curi, int curj, int newi, int newj) {
		
		//(i + 1), (j + 1) - Bottom right diagonal
		int i = curi;
		int j = curj;
		while(i < n && j < n) {
			if(i == newi && j == newj)
				return true;
			i++;
			j++;
		}
		
		//(i - 1), (j - 1) - Top left diagonal
		i = curi;
		j = curj;
		while(i >= 0 && j >= 0) {
			if(i == newi && j == newj)
				return true;
			i--;
			j--;
		}
		
		//(i + 1), (j - 1) - Bottom left diagonal
		i = curi;
		j = curj;
		while(i < n && j >= 0) {
			if(i == newi && j == newj)
				return true;
			i++;
			j--;
		}

		
		//(i - 1), (j + 1) - Top right diagonal
		i = curi;
		j = curj;
		while(i >= 0 && j < n) {
			if(i == newi && j == newj)
				return true;
			i--;
			j++;
		}
		
		return false;
	}
	
	static class Cell {
		
		public int i, j;
		
		public Cell(int i, int j) {
			this.i = i;
			this.j = j;
		}
	}
}
