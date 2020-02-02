package contest;

public class ValidPalindromeII {
	
	public boolean validPalindrome(String s) {
		char[] array = s.toCharArray();
		return isPalindrome(array);
    }
	
	private boolean isPalindrome(char[] array) {
		int L = array.length;
		for(int i = 0; i < L / 2; i++) {
			if(array[i] != array[(L - i) - 1]) {
				return isPalindromeUtil(copy(array, i)) || isPalindromeUtil(copy(array, (L - i) - 1));
			}
		}
		
		return true;
	}
	
	private boolean isPalindromeUtil(char[] array) {
		int L = array.length;
		for(int i = 0; i < L / 2; i++) {
			if(array[i] != array[(L - i) - 1]) {
				return false;
			}
		}
		
		return true;
	}
	
	private char[] copy(char[] array, int skip) {
		char[] copy = new char[array.length - 1];
		int L = array.length;
		for(int i = 0, j = 0; i < L; i++) {
			if(i != skip) {
				copy[j++] = array[i];
			}
		}
		
		return copy;
	}
	
	public static void main(String[] args) {
		ValidPalindromeII  sol = new ValidPalindromeII();
		System.out.println(sol.validPalindrome("ab"));
	}
}
