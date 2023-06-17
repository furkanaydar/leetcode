package grind75.Week1;

import java.util.Stack;

public class QueueFromStacks {

    static class MyQueue {

        Stack<Integer> in;
        Stack<Integer> out;

        public MyQueue() {
            in = new Stack<>();
            out = new Stack<>();
        }

        public void push(int x) {
            in.push(x); // O(1)
        }

        public int pop() {
            /*
                Will fill the out once in a while, when out stack is empty.
                So if we add N elements first, then call pop() N times;
                first operation will cost O(N), while rest will cost O(1).
                N operations will cost us O(N) -> amortized cost of O(1).
             */
            if (out.isEmpty()) {
                while (!in.isEmpty()) {
                    out.push(in.pop());
                }
            }

            return out.pop();
        }

        public int peek() {
            if (out.isEmpty()) {
                while (!in.isEmpty()) {
                    out.push(in.pop());
                }
            }

            return out.peek();
        }

        public boolean empty() {
            return in.empty() && out.empty();
        }
    }
    public static void main(String[] args) {
        MyQueue mq = new MyQueue();

        mq.push(5);
        mq.push(3);
        mq.push(4);

        System.out.println(mq.peek());
        System.out.println(mq.pop());
        System.out.println(mq.peek());

        mq.push(6);

        System.out.println(mq.pop());
        System.out.println(mq.empty());
    }
}
