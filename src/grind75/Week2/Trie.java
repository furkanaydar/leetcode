package grind75.Week2;

class Trie {
    class Node {
        Node[] children = new Node[26];
        boolean terminal;

        public Node() {
            this.children = new Node[26];
            this.terminal = false;
        }

        public Node(boolean asTerminal) {
            this.terminal = asTerminal;
        }

        Node getChild(char c) {
            return children[c-97];
        }

        boolean hasChild(char c) {
            return getChild(c) != null;
        }

        void addChild(char c, boolean asTerminal) {
            Node existing = getChild(c);

            if (existing != null) {
                existing.terminal |= asTerminal;
                return;
            }

            children[c-97] = new Node(asTerminal);
        }
    }

    public Node root;

    public Trie() {
        this.root = new Node();
    }

    public void insert(String word) {
        Node tmp = root;
        for (int i=0; i<word.length(); i++) {
            char c = word.charAt(i);
            tmp.addChild(c,i==word.length()-1);
            tmp = tmp.getChild(c);
        }
    }

    public Node iterate(String word) {
        Node tmp = root;
        for (Character c: word.toCharArray()) {
            if (tmp == null) {
                return null;
            }

            if (!tmp.hasChild(c)) {
                return null;
            }

            tmp = tmp.getChild(c);
        }

        return tmp;
    }

    public boolean search(String word) {
        Node n = iterate(word);
        return n != null && n.terminal;
    }

    public boolean startsWith(String prefix) {
        return iterate(prefix) != null;
    }
}