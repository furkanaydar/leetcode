package common;

public class DoublyLinkedList<T> {

    public class DoublyLinkedListNode {
        T val;
        DoublyLinkedListNode next;
        DoublyLinkedListNode prev;

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
    }

    DoublyLinkedListNode head;
    DoublyLinkedListNode tail;
    int listLength=0;

    public DoublyLinkedListNode createNode(T val) {
        return new DoublyLinkedListNode(val);
    }

    public void insertToBeginning(T val) {
        DoublyLinkedListNode newNode = new DoublyLinkedListNode(val);
        if (listLength > 0) {
            newNode.next = head;
            head.prev = newNode;
        }

        head = newNode;

        if (listLength == 0) {
            tail = head;
        }

        listLength++;
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

    public void insertToEnd(T val) {
        insertToEnd(new DoublyLinkedListNode(val));
    }

    public void insertAfterIndex(int index, T val) {
        DoublyLinkedListNode node = getNode(index);

        if (node == null) {
            throw new RuntimeException();
        }

        DoublyLinkedListNode nextNode = node.next;
        DoublyLinkedListNode newNode = new DoublyLinkedListNode(val);
        node.next = newNode;
        newNode.prev = node;

        if (nextNode != null) {
            nextNode.prev = newNode;
        }

        newNode.next = nextNode;
        listLength++;
    }

    public T get(int index) {
        DoublyLinkedListNode node = getNode(index);
        return node == null ? null : node.val;
    }

    public T removeFromBeginning() {
        if (head == null) {
            throw new RuntimeException();
        }

        T removedVal = head.val;
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

        return removedVal;
    }

    public T removeFromEnd() {
        if (tail == null) {
            throw new RuntimeException();
        }

        T removedVal = tail.val;
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

        return removedVal;
    }

    public T removeByReference(DoublyLinkedListNode obj) {
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
        return obj.val;
    }

    public T removeNthIndex(int index) {
        DoublyLinkedListNode node = getNode(index);

        if (node == null) {
            throw new RuntimeException();
        }

        if (index == 0) {
            return removeFromBeginning();
        }

        if (index == listLength-1) {
            return removeFromEnd();
        }

        DoublyLinkedListNode nextNode = node.next;
        nextNode.prev = node.prev;
        node.prev.next = nextNode;
        return node.val;
    }

    public int firstOccurrence(T val) {
        DoublyLinkedListNode tmp = head;
        int index = -1;

        while (tmp != null) {
            index++;
            if (tmp.val.equals(val)) {
                return index;
            }

            tmp = tmp.next;
        }

        return -1;
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

    public static void main(String[] args) {
        DoublyLinkedList<Integer> ll = new DoublyLinkedList<>();
        ll.insertToEnd(3);
        ll.removeFromBeginning();
        ll.insertToBeginning(5);
        ll.removeFromEnd();
        ll.insertToBeginning(6);
        ll.insertToEnd(4);
        System.out.println(ll.get(0));
        System.out.println(ll.get(1));
        ll.removeFromEnd();
        ll.removeFromEnd();
        ll.insertToEnd(8);
        ll.insertToBeginning(3);
        ll.insertToEnd(10);
        System.out.println(ll.get(1));
        System.out.println(ll.removeNthIndex(1));
        System.out.println(ll.get(1));
    }
}