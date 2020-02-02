package arraysandstrings;

import java.util.Arrays;

public class PlusOne {
	 public int[] plusOne(int[] digits) {
		 if(digits == null)
			 return null;
		 
		 int r = 1;
		 for(int i = digits.length - 1; i >= 0; i--) {
			 if(digits[i] == 9 && r == 1) {
				 digits[i] = 0;
				 r = 1;
			 }
			 else {
				 digits[i] = digits[i] + r;
				 r = 0;
			 }
		 }
		 
		 if(r == 1) {
			 int result[] = new int[digits.length + 1];
			 result[0] = 1;
			 for(int i = 0; i < digits.length; i++) {
				 result[i + 1] = digits[i];
			 }
			 
			 return result;
		 }
		 else {
			 return digits;
		 }
	 }
	 
	 public static void main(String[] args) {
		 //int[] digits = {1,2,3};
		 int[] digits = {4,3,2,1};
		 
		 PlusOne sol = new PlusOne();
		 System.out.println(Arrays.toString(sol.plusOne(digits)));
	 }
}
