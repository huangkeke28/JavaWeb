package pratice0607;

import java.util.Stack;

public class Solution {
    //用两个栈实现队列
    public static Stack<Integer> s1 = new Stack<>();
    public static Stack<Integer> s2 = new Stack<>();

    public static void push(int x) {
        s1.push(x);
    }

    public static Integer pop() {
        while (!s1.isEmpty()) {
            s2.push(s1.pop());
        } // 1 2  3  4
        int result = s2.pop(); // 4 3 2 1
        while (!s2.isEmpty()) {
            s1.push(s2.pop());
        }
        return result;

    }

}
