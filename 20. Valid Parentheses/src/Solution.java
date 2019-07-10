import java.util.HashMap;
import java.util.Stack;

class Solution {

    static public boolean isValid(String s) {
        HashMap hash = new HashMap();
        hash.put(')', '(');
        hash.put('}', '{');
        hash.put(']', '[');
        Stack stack = new Stack();
        for (char c : s.toCharArray()) {
            if (hash.containsValue(c)) {
                stack.push(c);
            } else if (!stack.empty() && stack.peek() == hash.get(c)) {
                stack.pop();
            } else if (hash.containsKey(c)) return false;
        }
        return stack.empty();
    }


    public static void main(String[] args) {
        String s = "(([]){})";
        boolean val = isValid(s);
        System.out.println(val);
    }
}