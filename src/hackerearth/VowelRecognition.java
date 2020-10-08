package hackerearth;

public class VowelRecognition {
	
	public static void main(String[] args) {
		System.out.println(vowelCount("baceb"));
	}

	 private static int vowelCount(String str) {
	        int N = str.length();
	        int totalVowel = 0;
	        int[] vowelAfter  = new int[N];
	        int[] vowelBefore = new int[N];

	        for(int i = 0; i < N; i++) {
	            char c = str.charAt(i);
	            if(isVowel(c)) {
	                totalVowel++;
	            }
	        }

	        for(int i = 0; i < N; i++) {
	            char c = str.charAt(i);
	            if(isVowel(c)) {
	                vowelBefore[i] = 1;
	            }

	            if(i > 0) {
	                vowelBefore[i] +=  vowelBefore[i - 1];
	            }
	        }

	        for(int i = N - 1; i >= 0; i--) {
	            char c = str.charAt(i);
	            if(isVowel(c)) {
	                vowelAfter[i] = 1;
	            }

	            if(i < (N - 1)) {
	                vowelAfter[i] +=  vowelAfter[i + 1];
	            }
	        }

	        int sum = 0;
	        for(int i = 0; i < N; i++) {
	            for(int j = i; j < N; j++) {
	                int leftVowel = (i > 0) ? vowelBefore[i - 1] : 0;
	                int rightVowel = (j < (N - 1))  ? vowelAfter[j + 1] : 0;
	                sum += ((totalVowel - leftVowel) - rightVowel);
	            }
	        }

	        return sum;
	    }

	    private static boolean isVowel(char c) {
	        return c == 'a' || c == 'e' || c == 'i' || c == 'o'
	         || c == 'u' || c == 'A' || c == 'E' || c == 'I' || c == 'O'
	         || c == 'U'; 
	    }
}
