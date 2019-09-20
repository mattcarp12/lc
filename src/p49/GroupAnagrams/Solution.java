package p49.GroupAnagrams;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, Map<Character, Integer>> masterTable = makeMasterTable(strs);
        Map<String, List<String>> anagramGroups = new HashMap<>();
        boolean added;
        for (String s : strs) {
            added = false;
            for (String t : anagramGroups.keySet()) {
                if (t.equals(s) || areAnagrams(s, t, masterTable)) {
                    anagramGroups.get(t).add(s);
                    added = true;
                }
            }
            if (!added) {
                anagramGroups.put(s, new ArrayList<>());
                anagramGroups.get(s).add(s);
            }
        }
        List<List<String>> solution = new ArrayList<>();
        for (List<String> group : anagramGroups.values()) {
            solution.add(group);
        }
        return solution;
    }

    private Map<Character, Integer> makeHashTable(String s) {
        Map<Character, Integer> stringTable = new HashMap<>();
        for (Character c : s.toCharArray()) {
            if (!stringTable.containsKey(c))
                stringTable.put(c, 1);
            else stringTable.put(c, stringTable.get(c) + 1);
        }
        return stringTable;
    }

    private boolean areAnagrams(String s, String t, Map<String, Map<Character, Integer>> masterTable) {
        return masterTable.get(s).equals(masterTable.get(t));
    }

    private Map<String, Map<Character, Integer>> makeMasterTable(String[] strs) {
        Map<String, Map<Character, Integer>> masterTable = new HashMap<>();
        for (String s : strs) {
            masterTable.put(s, makeHashTable(s));
        }
        return masterTable;
    }
}