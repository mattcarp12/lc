package p424.LongestRepeatingCharacterReplacement;


import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

class Solution {
    public int characterReplacement(String s, int k) {

        // check edge case
        if (k >= s.length()) return s.length();

        // Create frequency map of first k + 1 letters of string
        char[] charArray = s.toCharArray();
        Map<Character, Integer> freqMap = new HashMap<>();
        for (char c : Arrays.copyOfRange(charArray, 0, k + 1)) {
            if (freqMap.containsKey(c)) freqMap.put(c, freqMap.get(c) + 1);
            else freqMap.put(c, 1);
        }

        // Create priority queue of the entry set of the frequcney map
        PriorityQueue<Map.Entry<Character, Integer>> pq =
                new PriorityQueue<Map.Entry<Character, Integer>>(k + 1, (a, b) -> b.getValue() - a.getValue());
        for (Map.Entry entry : freqMap.entrySet()) pq.add(entry);

        // Now the length of the window can be
        // k + # most frequent letter of first k + 1 characters
        int windowStart = 0;
        int windowEnd = k + pq.peek().getValue() - 1;

        while (++windowEnd < charArray.length) {
            Map.Entry mostFreq = pq.peek();

            // Now if the next letter past the end of the window is
            // same as most frequently occuring, can add to the window
            // size without cost
            while (charArray[windowEnd] == (Character) mostFreq.getValue()) {
                windowEnd++;
                freqMap.put(charArray[windowEnd - 1], freqMap.get(charArray[windowEnd - 1]) + 1);
            }

            // Slide the beginning of the window
            freqMap.put(charArray[windowStart], freqMap.get(charArray[windowStart++]) - 1);

            // Slide the end of the window
            if (!freqMap.containsKey(charArray[windowEnd])) {
                freqMap.put(charArray[windowEnd], 1);
            }
        }

        return windowEnd - windowStart;
    }
}
