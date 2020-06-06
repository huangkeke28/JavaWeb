package pratice0605;

import java.util.Stack;

public class Parenthesis {
    public boolean chkParenthesis(String A, int n) {
        Stack<Character> stack = new Stack<>();
        if (A == null || A.length() != n) {
            return false;
        }
        for (int i = 0; i < n; i++) {
            char c = A.charAt(i);
            if ('(' == c) {
                stack.push(c);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                stack.pop();
            }
        }
        if (stack.isEmpty()) {
            return true;
        }
        return false;
    }
}
