package p49.GroupAnagrams;

import java.util.*;

public class Solution2 {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> anagramGroups = new HashMap<>();

        for (String s : strs) {
            char[] sortedStringCharArray = s.toCharArray();
            Arrays.sort(sortedStringCharArray);
            String sortedString = new String(sortedStringCharArray);
            if (!anagramGroups.containsKey(sortedString)) {
                anagramGroups.put(sortedString, new ArrayList<>());
            }
            anagramGroups.get(sortedString).add(s);
        }
        return new ArrayList(anagramGroups.values());
    }
}