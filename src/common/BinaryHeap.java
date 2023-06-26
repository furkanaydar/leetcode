package common;

public class BinaryHeap<T extends Comparable<T>> {
    T[] elements;
    int size;

    public BinaryHeap() {
        elements = (T[]) new Comparable[8];
        size=0;
    }

    public void insert(T element) {
        elements[size++] = element;
        int ind = size-1;
        while (ind >= 0 && element.compareTo(getParent(ind)) < 0) {
            int parentIndex = getParentIndex(ind);
            swap(ind, parentIndex);
            ind = parentIndex;
        }

        int arrLength = elements.length;
        if (size == arrLength) {
            T[] newElems = (T[]) new Comparable[arrLength*2];
            System.arraycopy(elements, 0, newElems, 0, arrLength);

            this.elements = newElems;
        }
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public T delete() {
        if (isEmpty()) {
            throw new IllegalStateException();
        }

        T deleted = elements[0];
        elements[0] = elements[--this.size];
        elements[size] = null;

        int ind = 0;
        boolean terminate=false;

        while (!terminate) {
            int leftChildIndex = getLeftChildIndex(ind);
            int rightChildIndex = getRightChildIndex(ind);

            if (leftChildIndex >= this.size) {
                break;
            }

            T leftChildren = getElement(leftChildIndex);
            int selectedChildIndex = leftChildIndex;

            if (rightChildIndex < this.size) {
                T rightChildren = getElement(rightChildIndex);
                if (rightChildren.compareTo(leftChildren) < 0) {
                    selectedChildIndex = rightChildIndex;
                }
            }

            if (getElement(ind).compareTo(getElement(selectedChildIndex)) > 0) {
                swap(ind, selectedChildIndex);
                ind = selectedChildIndex;
            } else {
                terminate = true;
            }
        }

        return deleted;
    }

    public T peek() {
        return root();
    }


    /* PRIVATE */
    private int getParentIndex(int i) {
        return (i-1)/2;
    }

    private int getRightChildIndex(int i) {
        return i*2+2;
    }

    private T getParent(int i) {
        return getElement(getParentIndex(i));
    }

    private T getLeftChild(int i) {
        return getElement(getLeftChildIndex(i));
    }

    private T getRightChild(int i) {
        return getElement(getRightChildIndex(i));
    }

    private int getLeftChildIndex(int i) {
        return i*2+1;
    }

    private T getElement(int i) {
        if (i>=size) {
            throw new IllegalStateException();
        }

        return elements[i];
    }

    private boolean isLeaf(int i) {
        return getElement(i) != null && getLeftChild(i) == null && getRightChild(i) == null;
    }

    private void swap(int i, int j) {
        T tmp = elements[j];
        elements[j] = elements[i];
        elements[i] = tmp;
    }

    private T root() {
        if (size==0) {
            return null;
        }

        return elements[0];
    }

    static class MaxHeapElem implements Comparable<MaxHeapElem> {
        int val;

        public MaxHeapElem(int val) {
            this.val = val;
        }

        @Override
        public int compareTo(MaxHeapElem o) {
            return val-o.val>0 ? -1 : 1;
        }
    }

    public static void assertMaxHeap() {
        BinaryHeap<MaxHeapElem> bh = new BinaryHeap<>();
        bh.insert(new MaxHeapElem(4));
        bh.insert(new MaxHeapElem(8));
        bh.insert(new MaxHeapElem(3));
        bh.insert(new MaxHeapElem(0));
        bh.insert(new MaxHeapElem(27));
        assert bh.peek().val == 27;
        bh.delete();
        assert bh.peek().val == 8;
        bh.delete();
        assert bh.peek().val == 4;
        assert bh.size == 3;
        bh.insert(new MaxHeapElem(22));
        bh.insert(new MaxHeapElem(22));
        bh.insert(new MaxHeapElem(10));
        bh.insert(new MaxHeapElem(33));
        bh.insert(new MaxHeapElem(55));
        bh.insert(new MaxHeapElem(44));
        int deleted = bh.delete().val;
        assert deleted == 55;
        bh.delete();
        bh.delete();
        bh.delete();
        assert bh.peek().val == 22;
    }

    public static void assertMinHeap() {
        BinaryHeap<Integer> bh = new BinaryHeap<>();
        bh.insert(4);
        bh.insert(8);
        bh.insert(3);
        bh.insert(0);
        bh.insert(27);
        assert bh.peek() == 0;
        bh.delete();
        assert bh.peek() == 3;
        bh.delete();
        assert bh.peek() == 4;
        assert bh.size == 3;
        bh.insert(22);
        bh.insert(22);
        bh.insert(10);
        bh.insert(33);
        bh.insert(55);
        bh.insert(44);
        int deleted = bh.delete();
        assert deleted == 4;
        bh.delete();
        bh.delete();
        bh.delete();
        assert bh.peek() == 22;
    }

    public static void main(String[] args) {
        assertMinHeap();
        assertMaxHeap();
    }
}
