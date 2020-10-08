package hackerearth;

public class Cipher {
	
	public static void main(String[] args) {
		System.out.println(encrypt("addaA333", 4));
	}
	
	private static String encrypt(String s, int k) {

        int N = s.length();
        char[] cipher = new char[N];
        for(int i = 0; i < N; i++) {
            char c = s.charAt(i);
            if(c >= 'A' && c <= 'Z') {
                c = rotate(c, 'A', k, 26);
            } else if(c >= 'a' && c <= 'z') {
            	c = rotate(c, 'a', k, 26);
            } else if(c >= '0' && c <= '9') {
            	c = rotate(c, '0', k, 10);
            }

            cipher[i] = c;

        }

        return new String(cipher);
    }
	
	private static char rotate(char c, char start, int k, int offset) {
		int val = (((int)(c - start)) + k) % offset; 
		val = val + (int) start;
		return (char)val;
	}

}
