package stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * https://leetcode.com/problems/valid-parentheses/
 */
public class ValidParentheses {
    public static void main(String[] args) {
        String s = "()[]{}";
        System.out.println(isValid(s));
    }

    public static boolean isValid(String s) {
        // create stack for tracking
        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()) {
            // if it is opening parentheses push it to stack
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            } else {
                // if parentheses is closing parentheses check appropriate one
                if (
                        stack.isEmpty() ||
                                (c == ')' && stack.pop() != '(') ||
                                (c == ']' && stack.pop() != '[') ||
                                (c == '}' && stack.pop() != '{')

                ) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}
