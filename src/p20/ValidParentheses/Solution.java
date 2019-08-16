package p20.ValidParentheses;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Solution {

	public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        Map<Character, Character> map = new HashMap<>();
        map.put(')', '(');
        map.put(']', '[');
        map.put('}', '{');
        
        for (Character c : s.toCharArray()) {
            if (map.containsKey(c)) {
                if (!stack.isEmpty() && stack.peek() == map.get(c))
                    stack.pop();
                else return false;
            } else stack.push(c);
        }
        return stack.isEmpty();
    }
	
	public static void main(String[] args) {
		String s = "(({}))";
		System.out.println(s + " are valid parentheses: " + isValid(s));
		s = "{}()[)";
		System.out.println(s + " are valid parentheses: " + isValid(s));
	}
}
