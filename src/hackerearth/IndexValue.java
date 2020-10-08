package hackerearth;

public class IndexValue {
	
	private static int findIndex(Integer[] a, int start, int end, int K, int X) {

        int index = Integer.MAX_VALUE;
        if(start <= end) {
            int mid = (start + end) / 2;
            if(a[mid] == X) {
                index = mid;
            }

            int left = Integer.MAX_VALUE;
            int offset = (mid - start) * K;
            if(X >= a[mid] - offset && X <= a[mid] + offset) {
                left = findIndex(a, start, mid - 1, K, X);
            }

            int right = Integer.MAX_VALUE;
            offset = (end - mid) * K;
    	    if(X >= a[mid] - offset && X <= a[mid] + offset) {
                right = findIndex(a, mid + 1, end, K, X);
            }

            index = Math.min(index, Math.min(left, right));
        }

        return index;
    }
	
	public static void main(String[] args) {
		Integer nums[] = {2, 4, 6, 8, 6, 8};
		System.out.println(findIndex(nums, 0, nums.length - 1, 2, 4));
	}

}
