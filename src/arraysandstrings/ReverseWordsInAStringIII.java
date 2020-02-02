package arraysandstrings;

public class ReverseWordsInAStringIII {

	public String reverseWords(String s) {
		if(s == null)
			return null;
		
		if(s.length() == 0)
			return "";
		
		char[] result = s.toCharArray();
		
		int j = 0;
		int i = 0;
		while(j < result.length) {
			while(j < result.length && result[j] != ' ')
				j++;
			reverse(result, i, j - 1);
			i = j + 1;
			j = i + 1;
		}
		
		return new String(result);
    }
	
	private void reverse(char[] array, int start, int end) {
		for(int i = start; i < (start + end + 1) / 2; i++) {
			swap(array, i, start + end - i);
		}
	}
	
	private void swap(char[] array, int i, int j) {
		char temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}
	
	public static void main(String[] args) {
		ReverseWordsInAStringIII sol = new ReverseWordsInAStringIII();
		System.out.println(sol.reverseWords("Let's take LeetCode contest"));
	}
}
