package hackerearth;

public class RemoveFriends {
	
	  public static void main(String[] args) {
		int N = 5;
		int K = 3;
		int[] array = {23, 45, 11, 77, 18};
		removeFriends(array, N, K);
	  }

	   private static void removeFriends(int[] array, int N, int K) {
	        int count = 0;
	        int newLength = N - K;
	        int i = 0;
	        while(count < newLength && i < N) {
	            if(K > 0 && i < N - 1 && array[i] < array[i + 1]) {
	                K--;
	            } else {
	                System.out.print(array[i] + " ");
	                count++;
	            }

	            i++;
	        }
	    }
}
