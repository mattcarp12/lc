package p424.LongestRepeatingCharacterReplacement;

public class Solution2 {
    public int characterReplacement(String s, int k) {
        int[] charCount = new int[26];
        int start = 0, maxCount = 0, len = s.length();
        for (int end = 0; end < len; end++) {
            maxCount = Math.max(maxCount, ++charCount[s.charAt(end) - 'A']);
            if (end - start + 1 - maxCount > k)
                charCount[s.charAt(start++) - 'A']--;
        }
        return len - start;
    }
}
