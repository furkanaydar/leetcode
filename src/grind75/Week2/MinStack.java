package grind75.Week2;

import java.util.PriorityQueue;

class MinStack {
    Integer[] elements;
    int elementsSize;

    Integer[] minElements;
    int minElementsSize;

    public MinStack() {
        this.elements = new Integer[30000];
        this.elementsSize=0;
        this.minElements = new Integer[30000];
        this.minElementsSize = 0;
    }

    public void push(int val) {
        elements[elementsSize++]=val;

        if (minElementsSize==0 || minElements[minElementsSize-1]>=val) {
            minElements[minElementsSize++]=val;
        }
    }

    public void pop() {
        int popped = elements[elementsSize-1];
        elementsSize--;
        if (minElements[minElementsSize-1] == popped) {
            minElementsSize--;
        }
    }

    public int top() {
        return elements[elementsSize-1];
    }

    public int getMin() {
        return minElements[minElementsSize-1];
    }

    private boolean isEmpty() {
        return elementsSize == 0;
    }

    public static void main(String[] args) {
        MinStack st = new MinStack();
        st.push(-2);
        st.push(0);
        st.push(-3);
        System.out.println(st.getMin());
        st.pop();
        System.out.println(st.top());
        System.out.println(st.getMin());
    }
}
