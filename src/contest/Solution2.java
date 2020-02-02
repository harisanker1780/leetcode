package contest;

import java.util.HashMap;
import java.util.Map;

public class Solution2 {
	
	public int solution(int N, String S) {
		
		int[][] seats = new int[N][10];
		
		setReservedSeats(seats, S);
		
		int count = 0;
		for(int i = 0; i < N; i++) {
			if(seats[i][0] == 0 && seats[i][1] == 0 && seats[i][2] == 0) {
				count++;
			}
			
			if((seats[i][3] == 0 && seats[i][4] == 0 && seats[i][5] == 0) || 
					(seats[i][4] == 0 && seats[i][5] == 0 && seats[i][6] == 0)) {
				count++;
			}
			
			if(seats[i][7] == 0 && seats[i][8] == 0 && seats[i][9] == 0) {
				count++;
			}
		}
		
		return count;
    }
	
	private void setReservedSeats(int[][] seats, String S) {
		if(S != null && S.length() > 0) {
			Map<String, Integer> columnIndexMap = new HashMap<String, Integer>();
			columnIndexMap.put("A", 0);
			columnIndexMap.put("B", 1);
			columnIndexMap.put("C", 2);
			columnIndexMap.put("D", 3);
			columnIndexMap.put("E", 4);
			columnIndexMap.put("F", 5);
			columnIndexMap.put("G", 6);
			columnIndexMap.put("H", 7);
			columnIndexMap.put("J", 8);
			columnIndexMap.put("K", 9);
			
			String[] reservedSeats = S.split(" ");
			for(String s : reservedSeats) {
				s = s.trim();
				int row = Integer.parseInt(s.substring(0, s.length() - 1)) - 1;
				int column = columnIndexMap.get(s.substring(s.length() - 1, s.length()));
				seats[row][column] = 1;
			}
		}
	}
	
	public static void main(String[] args) {
		Solution2 sol = new Solution2();
		int  N = 1;
		String S = "";
		System.out.println(sol.solution(N, S));
	}
	
}
