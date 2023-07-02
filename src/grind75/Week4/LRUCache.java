package grind75.Week4;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {

    int capacity;
    int size;
    Map<Integer, DoublyLinkedList<Integer>.DoublyLinkedListNode> m;
    DoublyLinkedList<Integer> ll;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        this.m = new HashMap<>();
        this.ll = new DoublyLinkedList<>();
    }

    public int get(int key) {
        DoublyLinkedList<Integer>.DoublyLinkedListNode node = m.get(key);

        if (node != null) {
            int val = node.getVal();
            shiftToTail(node);
            return val;
        }

        return -1;
    }

    public void put(int key, int value) {
        if (m.containsKey(key)) {
            DoublyLinkedList<Integer>.DoublyLinkedListNode node = m.get(key);
            node.setVal(value);
            shiftToTail(node);
            return;
        }

        if (size == capacity) {
            DoublyLinkedList<Integer>.DoublyLinkedListNode node = ll.removeFromBeginning();
            m.remove(node.key);
            size--;
        }

        DoublyLinkedList<Integer>.DoublyLinkedListNode node = ll.createNode(value);
        node.setKey(key);
        m.put(key, node);
        ll.insertToEnd(node);
        size++;
    }

    private void shiftToTail(DoublyLinkedList<Integer>.DoublyLinkedListNode node) {
        ll.insertToEnd(ll.removeByReference(node));
    }

    public class DoublyLinkedList<T> {

        public class DoublyLinkedListNode {
            T val;
            int key;
            DoublyLinkedListNode next;
            DoublyLinkedListNode prev;

            @Override
            public boolean equals(Object obj) {
                return key == ((DoublyLinkedListNode) obj).key;
            }

            public DoublyLinkedListNode(T val) {
                this.val = val;
                this.next = this.prev = null;
            }

            public T getVal() {
                return this.val;
            }

            public void setVal(T val) {
                this.val = val;
            }

            public void setKey(int key) {
                this.key = key;
            }
        }

        DoublyLinkedListNode head;
        DoublyLinkedListNode tail;
        int listLength=0;

        public DoublyLinkedListNode createNode(T val) {
            return new DoublyLinkedListNode(val);
        }

        public void insertToEnd(DoublyLinkedListNode newNode) {
            if (listLength > 0) {
                tail.next = newNode;
                newNode.prev = tail;
            }

            tail = newNode;

            if (listLength == 0) {
                head = tail;
            }

            listLength++;
        }

        public T get(int index) {
            DoublyLinkedListNode node = getNode(index);
            return node == null ? null : node.val;
        }

        public DoublyLinkedListNode removeFromBeginning() {
            if (head == null) {
                throw new RuntimeException();
            }

            DoublyLinkedListNode removedNode = head;
            head = head.next;
            if (head != null) {
                head.prev = null;
            }

            listLength--;

            if (listLength == 1) {
                tail = head;
            }

            if (listLength == 0) {
                tail = null;
            }

            return removedNode;
        }

        public DoublyLinkedListNode removeFromEnd() {
            if (tail == null) {
                throw new RuntimeException();
            }

            DoublyLinkedListNode removedNode = tail;
            tail = tail.prev;
            if (tail != null) {
                tail.next = null;
            }

            listLength--;

            if (listLength == 1) {
                head = tail;
            }

            if (listLength == 0) {
                head = null;
            }

            return removedNode;
        }

        public DoublyLinkedListNode removeByReference(DoublyLinkedListNode obj) {
            if (obj == null) {
                throw new RuntimeException();
            }

            if (obj.equals(head)) {
                return removeFromBeginning();
            }

            if (obj.equals(tail)) {
                return removeFromEnd();
            }

            obj.prev.next = obj.next;
            obj.next.prev = obj.prev;
            listLength--;
            return obj;
        }

        public int length() {
            return listLength;
        }

        private DoublyLinkedListNode getNode(int index) {
            if (index < 0 || index >= listLength) {
                throw new RuntimeException();
            }

            DoublyLinkedListNode tmp = head;
            int curIndex = 0;

            while (tmp != null && curIndex<index) {
                curIndex++;
                tmp = tmp.next;
            }

            return curIndex == index && tmp != null ? tmp : null;
        }
    }

    public static void main(String[] args) {
        LRUCache lRUCache = new LRUCache(3);
        lRUCache.put(1, 1);
        lRUCache.put(2, 2);
        lRUCache.put(3, 3);
        lRUCache.put(4, 4);
        System.out.println(lRUCache.get(4));
        System.out.println(lRUCache.get(3));
        System.out.println(lRUCache.get(2)); // 4, 3, 2
        System.out.println(lRUCache.get(1));
        lRUCache.put(5, 5); // 3, 2, 5
        System.out.println(lRUCache.get(1));
        System.out.println(lRUCache.get(2));
        System.out.println(lRUCache.get(3));
        System.out.println(lRUCache.get(4));
        System.out.println(lRUCache.get(5));

    }
}
