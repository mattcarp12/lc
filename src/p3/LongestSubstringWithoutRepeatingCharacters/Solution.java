package p3.LongestSubstringWithoutRepeatingCharacters;

import java.util.HashSet;
import java.util.Set;

public class Solution {

	public static int lengthOfLongestSubstring(String s) {
        int p = 0;
        int maxLen = 0;
        Set<Character> set = new HashSet<>();
        
        for (int i = 0; i < s.length(); i++) {
            if (set.contains(s.charAt(i))) {
                maxLen = Math.max(maxLen, set.size());
                while (s.charAt(p) != s.charAt(i))
                    set.remove(s.charAt(p++));
                set.remove(s.charAt(p++));
            }
            set.add(s.charAt(i));
        }
        return Math.max(maxLen, set.size());
    }
	
	public static void main(String[] args) {
		String s = "aabaab!bb";
		System.out.println(lengthOfLongestSubstring(s));
	}

}
