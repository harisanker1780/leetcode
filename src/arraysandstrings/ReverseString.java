package arraysandstrings;

public class ReverseString {
	
	public void reverseString(char[] s) {
        if(s == null)
        	return;
       reverse(s);
    }
	
	private void reverse(char[] array) {
		for(int i = 0; i < array.length / 2; i++) {
			swap(array, i, array.length - 1 - i);
		}
	}
	
	private void swap(char[] array, int i, int j) {
		char temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}
}
