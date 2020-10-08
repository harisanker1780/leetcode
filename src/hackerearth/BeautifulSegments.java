package hackerearth;

public class BeautifulSegments {
	
	public static void main(String[] args) {
		
		int[] array = {1, 1, 2, 2, 3, 2, 1, -1};
		int count = getNumOfSegments(array, 0, array.length - 1, array.length);
		System.out.println(count);
	}

	private static int getNumOfSegments(int[] array, int start, int end, int N) {
        int count = 0;

        if(start < 0 || end >= array.length || (end - start) < 2)
            return count;

        if(start < end) {
            int mid = (start + end) / 2;

            if(mid > start && mid < end) {
                
               int left =  mid;
               int right = mid;
               while(left > 0 && array[left] >= array[left - 1] && right < N - 1 
                && array[right] > array[right + 1]) {
                    count++;
                    left--;
                    right++;
                }

                count += getNumOfSegments(array, start, left, N);
                count += getNumOfSegments(array, right, end, N);
                
            }
        }

        return count;
    }
}
