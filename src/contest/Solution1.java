package contest;

public class Solution1 {
	
	public String solution(int T) {
		
		int SECONDS_IN_HOUR = 3600;
		int SECONDS_IN_MINUTE = 60;
		
		int hours = 0;
		int minutes = 0;
		
		hours = T / SECONDS_IN_HOUR;
		T = T - hours * SECONDS_IN_HOUR;
		
		minutes = T / SECONDS_IN_MINUTE;
		T = T - minutes * SECONDS_IN_MINUTE;
		
		return hours + "h" + minutes + "m" + T  + "s"; 
    }
	
	public static void main(String[] args) {
		Solution1 sol = new Solution1();
		System.out.println(sol.solution(86399));
	}
}
