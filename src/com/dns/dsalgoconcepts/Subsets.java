package com.dns.dsalgoconcepts;

public class Subsets {

	public static void main(String[] args) {
		subSets("", "ABC");

	}
	
	public static void subSets(String outputString, String nextString) {
		if (nextString.length() == 0) {
			System.out.println("{" + outputString + "}");
		}else {
			subSets(outputString + nextString.charAt(0), nextString.substring(1));
			subSets(outputString, nextString.substring(1));
		}
	}

}
