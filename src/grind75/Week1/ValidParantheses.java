package grind75.Week1;

import java.util.Stack;

public class ValidParantheses {

    public static boolean isValid(String s) {
        Stack<Character> st = new Stack<>();

        for (Character c: s.toCharArray()) {
            if ('{' == c || '(' == c || '[' == c) {
                st.push(c);
                continue;
            }

            if (st.empty()) {
                return false;
            }

            Character popped = st.pop();

            if ((c == '}' && popped == '{') || (c == ']' && popped == '[') || (c==')' && popped == '(')) {
                continue;
            }

            return false;
        }

        return st.empty();
    }

    public static void main(String[] args) {
        System.out.println(isValid("(]"));
    }
}
