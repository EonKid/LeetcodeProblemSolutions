package com.dns.dsalgoconcepts;

public class Permutation {

	public static void main(String[] args) {
		String inputString = "ABC";
		permute("", inputString);

	}
	
	public static void permute(String outputString, String nextString) {
		if (nextString.length() == 0) {
			System.out.println("[" + outputString + "]");
		}else {
			for (int i = 0; i < nextString.length(); i++) {
				String currentString = outputString + nextString.charAt(i);
				String restString = nextString.substring(0, i) + nextString.substring(i + 1);
				permute(currentString, restString);
			}
		}
	}

	
}
