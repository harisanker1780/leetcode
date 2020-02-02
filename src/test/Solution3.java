package test;

import java.util.Scanner;

public class Solution3 {
	
	public static int numberOfMatches(int numberOfTeams) {
		
		if(numberOfTeams <= 1) {
			return 0;
		}
		
		return (numberOfTeams / 2) + numberOfMatches(numberOfTeams % 2 + numberOfTeams / 2);
	}
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String str1 = scanner.nextLine();
		int T = Integer.parseInt(str1);
		for(int i = 0; i < T; i++) {
			String str2 = scanner.nextLine();
			System.out.println(numberOfMatches(Integer.parseInt(str2)));
		}
	}

}
