class Solution {
    public void reverseString(char[] s) {
        int i = 0;
        int j = s.length - 1;
        char t;
        while (i < j) {
            t = s[i];
            s[i] = s[j];
            s[j] = t;
            i++;
            j--;
        }
    }
}