package com.dns.leetcode.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/roman-to-integer/description/
 */

public class PN_13_RomanToInteger {
	
    public int romanToInt(String s) {
        int result = 0;
        Map<Character, Integer> hashMap = new HashMap<>();
        hashMap.put('I', 1);
        hashMap.put('V', 5);
        hashMap.put('X', 10);
        hashMap.put('L', 50);
        hashMap.put('C', 100);
        hashMap.put('D', 500);
        hashMap.put('M', 1000);

        char[] charArray = s.toCharArray();

        for(int i = 0; i < charArray.length; i++){
            if((i < charArray.length - 1) && hashMap.get(charArray[i]) < hashMap.get(charArray[i+1])){
                result = result + hashMap.get(charArray[i + 1]) - hashMap.get(charArray[i]);
                i++;
            } else{
                result = result + hashMap.get(charArray[i]);
            }
        }
        return result;
    }

}
