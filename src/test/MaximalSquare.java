package test;

public class MaximalSquare {
	
	public int maximalSquare(char[][] m) {
    
		if(m == null || m.length == 0)
			return 0;
		
		int matrix[][] = new int[m.length][m[0].length];
		
		int maxSize = 0;
		for(int i = 0; i < matrix.length; i++) {
			for(int j = 0; j < matrix[0].length; j++) {
				
				matrix[i][j] = m[i][j] == '0' ? 0 : 1;
				
				if(i != 0 && j != 0 && matrix[i][j] != 0) {
					if(matrix[i - 1][j] != 0 && matrix[i][j - 1] != 0 && matrix[i - 1][j - 1] != 0) {
						int min = Math.min(matrix[i][j] + matrix[i - 1][j], matrix[i][j] + matrix[i][j - 1]);
						min = Math.min(min, matrix[i][j] + matrix[i - 1][j - 1]);
						matrix[i][j] = min;
					}
				}
				
				maxSize = Math.max(maxSize, matrix[i][j]);
			}
		}
		
		return maxSize * maxSize;
    }
	
	
	public static void main(String[] args) {
		int i = '0';
		System.out.println(i);
	}

}
