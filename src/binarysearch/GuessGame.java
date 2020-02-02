package binarysearch;

public class GuessGame {
	
	public static int NUM = 8;
	
	 public int guessNumber(int n) {
        int start = 0;
        int end  = Integer.MAX_VALUE;
        while(start <= end) {
        	int mid = start + (end - start) / 2;
        	int result = guess(mid);
        	if(result == 0) {
        		return mid;
        	}
        	else if(result < 0) {
        		end = mid - 1;
        	}
        	else if(result > 0) {
        		start = mid + 1;
        	}
        }
        
        return -1;
	 }
	 
	 int guess(int num) {
		 if(num == NUM)
			 return 0;
		 else if(NUM < num)
			 return -1;
		 else 
			 return 1;
	 }
	 
	public static void main(String[] args) {
		GuessGame sol = new GuessGame();
		System.out.println(sol.guessNumber(1));
	}
}
