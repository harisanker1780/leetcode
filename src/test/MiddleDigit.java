package test;

public class MiddleDigit {
	
	public int middleDigit(int num) {
		
		int N = 0;
		int n = num;
		while(n > 0) {
			n = n / 10;
			N++;
		}
		
		int d = (int) Math.pow(10, N -1);
		int l = (int) Math.pow(10, (N - 1) / 2);
		
		while(d > l) {
			num = num % d;
			d = d / 10;
		}
		
		num = num / l;
		return num;
	}

	public static void main(String[] args) {
		MiddleDigit sol = new MiddleDigit();
		System.out.println(sol.middleDigit(9));
	}
}
