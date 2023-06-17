package grind75.Week2;

import java.util.Map;
import java.util.Stack;
import java.util.function.BiFunction;
import java.util.function.Function;

public class EvaluateReversePolishNotation {

    public int evalRPN(String[] tokens) {
        Stack<Integer> st = new Stack<>();
        Map<String, BiFunction<Integer, Integer, Integer>> m = Map.of(
                "-", (x, y) -> x-y,
                "+", (x, y) -> x+y,
                "*", (x, y) -> x*y,
                "/", (x, y) -> x/y
        );
        for (String s: tokens) {
            if (m.containsKey(s)) {
                int n2 = st.pop();
                int n1 = st.pop();
                st.add(m.get(s).apply(n1, n2));
            } else {
                st.add(Integer.parseInt(s));
            }
        }

        return st.pop();
    }
}
