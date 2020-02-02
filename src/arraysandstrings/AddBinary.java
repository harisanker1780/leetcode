package arraysandstrings;

public class AddBinary {

	public String addBinary(String a, String b) {
		
		if(a == null)
			return b;
		
		if(b == null)
			return a;
		
        char[] aArray = a.toCharArray();
        char[] bArray = b.toCharArray();
        
        StringBuilder result = new StringBuilder();
        
        int i = aArray.length - 1;
        int j = bArray.length - 1;
        int carry = 0;
        while(i >= 0 || j >= 0) {
        	
        	int aValue = (i >= 0) ? (aArray[i] == '0' ? 0 : 1) : 0;
    		int bValue = (j >= 0) ? (bArray[j] == '0' ? 0 : 1) : 0;
    		
    		int nextCarry = 0;
    		int value = aValue + bValue;
    		if(value > 1) {
    			value = 0;
    			nextCarry = 1;
    		}
    		
    		value = value + carry;
    		if(value > 1) {
    			value = 0;
    			nextCarry = 1;
    		}
    		
    		carry = nextCarry;
    		result.append(value);
    		i--;
    		j--;
        }
        
        if(carry > 0) {
        	result.append(carry);
        }
        
        return reverse(result.toString());
    }
	
	private String reverse(String s) {
		if(s == null)
			return null;
		char[] array = s.toCharArray();
		for(int i = 0; i < array.length / 2; i++) {
			swap(array, i, array.length - 1 - i);
		}
		
		return new String(array);
	}
	
	private void swap(char[] array, int i, int j) {
		char temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}
	
	public static void main(String[] args) {
		AddBinary sol = new AddBinary();
		//String a = "11", b = "1";
		//String a = "1010", b = "1011";
		String a = "11", b = "10";
		System.out.println(sol.addBinary(a, b));
	}
}
