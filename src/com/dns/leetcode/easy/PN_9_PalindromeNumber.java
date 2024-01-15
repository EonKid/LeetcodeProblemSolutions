package com.dns.leetcode.easy;

/**
 * https://leetcode.com/problems/palindrome-number/description/
 */

public class PN_9_PalindromeNumber {
	
    public boolean isPalindrome(int x) {

        if(x < 0){
            return false;
        }

        int number = x;
        int remainder ;
        int reverse = 0;

        while(number != 0){
            remainder = number % 10;
            reverse = reverse * 10 + remainder;
            number = number / 10;
        }
        return reverse == x;
    }

}
