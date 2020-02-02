package epi.string;

public class LookAndSay {
	
	public static String lookAndSay(int n) {
		String number = "1";
		for(int i = 1; i < n; i++) {
			number = nextNumber(number);
		}
		return number;
	}
	
	private static String nextNumber(String number) {
		char[] a = number.toCharArray();
		int i = 0;
		StringBuilder builder = new StringBuilder();
		while(i < a.length) {
			int count = 0;
			char c = a[i];
			while(i < a.length && a[i] == c) {
				count++;
				i++;
			}
			
			builder.append(count);
			builder.append(c);
		}
		
		
		return builder.toString();
	}
	
	public static void main(String[] args) {
		System.out.println(lookAndSay(8));
	}
}
