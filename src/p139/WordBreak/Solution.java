package p139.WordBreak;

import java.util.*;

public class Solution {
    Set<String> wordSet;
    public boolean wordBreak2(String s, List<String> wordDict) {
        wordSet = new HashSet(wordDict);
        return wordBreakCheck(s);
    }

    private boolean wordBreakCheck(String s) {
        if (s.length() == 0) return true;
        int i = 1; int n = s.length();
        String t = s.substring(0,i++);
        while (!wordSet.contains(t) && i < n + 1) {
            t = s.substring(0, i++);
        }
        System.out.println(t);
        if (wordSet.contains(t)) return wordBreakCheck(s.substring(i - 1));
        return false;
    }

    public boolean wordBreak(String s, List<String> wordDict) {
        HashSet<String> set = new HashSet<>(wordDict);
        HashMap<String, Boolean> map = new HashMap<>();
        return helper(s, map, set);
    }

    boolean helper(String s, HashMap<String, Boolean> map, HashSet<String> set){
        if(s.length() == 0) return true;
        if(map.containsKey(s)) return map.get(s);
        for(int i = 0; i < s.length(); i++){
            if(set.contains(s.substring(0, i +1)) && helper(s.substring(i + 1), map, set)){
                map.put(s, true);
                return map.get(s);
            }
        }

        map.put(s, false);
        return map.get(s);
    }

    public static void main(String... args) {
        Solution s = new Solution();
        List<String> wordList = new ArrayList<>();
        wordList.add("aaa");
        wordList.add("aaaa");
        s.wordBreak("aaaaaaa", wordList);
    }
}
