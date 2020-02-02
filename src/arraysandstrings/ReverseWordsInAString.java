package arraysandstrings;

public class ReverseWordsInAString {
	
	public String reverseWords(String s) {
		if(s == null)
			return null;
		
		if(s.length() == 0)
			return "";
		
		StringBuilder builder = new StringBuilder();
		char[] array = s.toCharArray();
		int i = 0;
		while(i < array.length) {
			while(i < array.length && array[i] == ' ')
				i++;
			while(i < array.length && array[i] != ' ')
				builder.append(array[i++]);
			while(i < array.length && array[i] == ' ')
				i++;
			
			if(i < array.length)
				builder.append(' ');
		}
		
		char[] result = builder.toString().toCharArray();
		reverse(result, 0, result.length - 1);
		
		int j = 0;
		i = 0;
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
		ReverseWordsInAString sol = new ReverseWordsInAString();
		System.out.println(sol.reverseWords("a good   example"));
	}
}
