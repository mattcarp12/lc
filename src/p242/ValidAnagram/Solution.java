package p242.ValidAnagram;

public class Solution {

    public static boolean isAnagram(String s, String t) {
        int[] mapS = countLetters(s), mapT = countLetters(t);
        boolean result = true;
        for (int i = 0; i < 128; i++) {
            result = result && (mapS[i] == mapT[i]);
        }
        return result;
    }

    public static int[] countLetters(String s) {
        int[] map = new int[128];
        for (Character c : s.toCharArray()) {
            map[(int) c]++;
        }
        return map;
    }

    public static void main(String[] args) {
        String s = "anagram";
        String t = "nagaram";
        isAnagram(s, t);
    }

}
