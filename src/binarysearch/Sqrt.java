package binarysearch;

public class Sqrt {
	
	public int mySqrt(int x) {
        return sqrt(0, x, x);
    }
	
	private int sqrt(int left, int right, int target) {
		/*while(target >= 0) {
			
			
			target = target - 1;
			left = 0;
			right = target;
		}*/
		
		while(left <= right) {
			int mid = left + ((right - left) / 2);
			int square = mid * mid;
			
			if(square == target) {
				return mid;
			}
			else if(square < target) {
				left = mid + 1;
			}
			else {
				right = mid - 1;
			}
		}
		
		return (left + ((right - left) / 2)) - 1;
	}
	
	public static void main(String[] args) {
		Sqrt sol = new Sqrt();
		System.out.println(sol.mySqrt(3));
	}

}
