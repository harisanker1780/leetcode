package epi.string;

public class SpreadSheetColumnEncoding {
	
	public static String ssEncodeColumn(int columnId) {
		return (columnId > 0) ? ssEncodeColumn(columnId / 26) + (char)((columnId % 26 == 0 ? 26 : columnId % 26) - 1 + 'A') : "" ; 
	}
	
	public static void main(String[] args) {
		System.out.println(ssEncodeColumn(52));
	}

}
