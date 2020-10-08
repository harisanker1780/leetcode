package hackerearth;

public class BestIndex {
	
	public static void main(String[] args) {
		
		int N = 7;
		int[] array = {898, -891, -604, -343, -280, 876, 538};
		System.out.println(bestIndex(array, N));
	}

    private static int bestIndex(int[] array, int N) {

        // Get Total Sum
        int totalSum = 0;
        for(int i = 0; i < array.length; i++) {
            totalSum += array[i];
        }

        int maxSum = Integer.MIN_VALUE;
        int leftSum = 0;
        for(int start = 0; start < N; start++) {
            int length = N - start;
            int count = 1;
            while((length - count) >= 0) {
                length = length - count;
                count++;
            }

            int rightSum = 0;
            for(int i = N - length; i < N; i++) {
                rightSum += array[i];
            }
            
            int sum = ((totalSum - leftSum) - rightSum);
            if(sum > maxSum) {
                maxSum = sum;
            }

            leftSum += array[start];
        }

        return maxSum;
    }
}
