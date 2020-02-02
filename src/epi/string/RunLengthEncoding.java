package epi.string;

public class RunLengthEncoding {
	
	public static String encoding(String s) {
		StringBuilder builder = new StringBuilder();
		int i = 0;
		while(i < s.length()) {
			char c = s.charAt(i);
			int count = 0;
			while(i < s.length() && c == s.charAt(i)) {
				count++;
				i++;
			}
			builder.append(count);
			builder.append(c);
		}
		
		return builder.toString();
	}
	
	
	public static String decoding(String s) {
		StringBuilder builder = new StringBuilder();
		int i = 0;
		while(i < s.length()) {
			char c = s.charAt(i);
			StringBuilder digitBuilder = new StringBuilder();
			while(i < s.length() && Character.isDigit(c)) {
				digitBuilder.append(c);
				c = s.charAt(++i);
			}
			
			int digit = Integer.parseInt(digitBuilder.toString());
			for(int j = 0; j < digit; j++) {
				builder.append(c);
			}
			 ++i;
		}
		
		return builder.toString();
	}
	
	public static void main(String[] args) {
		System.out.println(decoding("4a1b3c2a"));
	}

}
