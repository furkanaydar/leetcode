package grind75.Week4;

import java.util.Stack;

public class DailyTemperatures {

    public static int[] dailyTemperatures(int[] temperatures) {
        int[] res = new int[temperatures.length];
        Stack<Integer> st = new Stack<>();

        for (int i=0 ;i<temperatures.length; i++) {
            if (st.isEmpty()) {
                st.add(i);
                continue;
            }

            if (temperatures[st.peek()] < temperatures[i]) {
                while (!st.isEmpty() && temperatures[st.peek()] < temperatures[i]) {
                    int popped = st.pop();
                    res[popped] = i-popped;
                }
            }

            st.add(i);
        }

        return res;
    }

    public static void main(String[] args) {
        int[] in = new int[] {73,74,75,71,69,72,76,73};
        int[] in2 = new int[] {30, 40, 50, 60};

        dailyTemperatures(in);
    }
}
