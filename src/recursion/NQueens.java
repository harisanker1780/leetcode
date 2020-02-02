package recursion;

import java.util.ArrayList;
import java.util.List;

public class NQueens {
	
	public int count = 0;
	
	public int totalNQueens(int n) {
	    
		count = 0;
		List<Pos> positions = new ArrayList<Pos>();
		nQueens(0, n, positions);
		
		return count;
	}
	
	private void nQueens(int row, int n, List<Pos> positions) {
		for(int col = 0; col < n; col++) {
			if(!isUnderAttack(row, col, n, positions)) {
				
				Pos pos = new Pos(row, col);
				
				positions.add(pos);
				
				if(row == n -1) {
					count++;
				} else {
					nQueens(row + 1, n, positions);
				}
				
				positions.remove(pos);
			}
		}
	}
	
	private boolean isUnderAttack(int row, int col, int n, List<Pos> positions) {
		for(Pos p : positions) {
			if(p.row == row || p.col == col)
				return true;
			
			// Top Left Diagonal
			for(int i = p.row, j = p.col; i >= 0 && j >=0; i--, j--) {
				if(i == row && j == col)
					return true;
			}
			
			// Top Right Diagonal
			for(int i = p.row, j = p.col; i >= 0 && j < n; i--, j++) {
				if(i == row && j == col)
					return true;
			}
			
			// Bottom Left Diagonal
			for(int i = p.row, j = p.col; i < n && j >= 0; i++, j--) {
				if(i == row && j == col)
					return true;
			}
			
			// Bottom Right Diagonal
			for(int i = p.row, j = p.col; i < n && j < n; i++, j++) {
				if(i == row && j == col)
					return true;
			}
			
		}
		
		return false;
	}
	
	class Pos {
		int row; int col;
		public Pos(int row, int col) {
			this.row = row;
			this.col = col;
		}
		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + col;
			result = prime * result + row;
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
			Pos other = (Pos) obj;
			if (col != other.col)
				return false;
			if (row != other.row)
				return false;
			return true;
		}
	}
	
	public static void main(String[] args) {
		NQueens sol = new NQueens();
		System.out.println(sol.totalNQueens(4));
	}

}
