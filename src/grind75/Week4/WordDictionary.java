package grind75.Week4;

public class WordDictionary {
    Trie trie;

    public class TrieNode {
        boolean exists;
        TrieNode[] children;

        public TrieNode() {
            this.exists = false;
            this.children = new TrieNode[26];
        }

        public TrieNode(boolean exists) {
            this.exists = exists;
            this.children = new TrieNode[26];
        }
    }

    public class Trie {
        TrieNode root;

        public Trie() {
            root = new TrieNode();
        }

        public void addWord(String word) {
            TrieNode tmp = root;
            int i;

            for (i=0; i<word.length()-1; i++) {
                if (tmp.children[word.charAt(i)-97] == null) {
                    tmp.children[word.charAt(i)-97] = new TrieNode();
                }

                tmp = tmp.children[word.charAt(i)-97];
            }

            TrieNode toAdd = tmp.children[word.charAt(i)-97];
            if (toAdd == null) {
                toAdd = new TrieNode(true);
            }

            toAdd.exists=true;
            tmp.children[word.charAt(i)-97] = toAdd;
        }

        public boolean searchWord(String word) {
            return searchWord(root, 0, word);
        }

        private boolean searchWord(TrieNode root, int index, String word) {
            for (int i=index; i<word.length(); i++) {
                if (word.charAt(i) == '.') {
                    for (int j=0; j<26; j++) {
                        if (root.children[j] != null && searchWord(root.children[j], i+1, word)) {
                            return true;
                        }
                    }
                    return false;
                } else {
                    root = root.children[word.charAt(i)-97];
                    if (root == null) {
                        return false;
                    }
                }

            }

            return root != null && root.exists;
        }
    }

    public WordDictionary() {
        this.trie = new Trie();
    }

    public void addWord(String word) {
        this.trie.addWord(word);
    }

    public boolean search(String word) {
        return this.trie.searchWord(word);
    }

    public static void main(String[] args) {
        WordDictionary wordDictionary = new WordDictionary();
        wordDictionary.addWord("at");
        wordDictionary.addWord("and");
        wordDictionary.addWord("an");
        wordDictionary.addWord("add");
        System.out.println(wordDictionary.search("a"));
        System.out.println(wordDictionary.search(".at"));
        wordDictionary.addWord("bat");
        System.out.println(wordDictionary.search(".at"));
        System.out.println(wordDictionary.search("an."));
        System.out.println(wordDictionary.search("a.d."));
        System.out.println(wordDictionary.search("b."));
        System.out.println(wordDictionary.search("a.d"));
        System.out.println(wordDictionary.search("."));

    }
}
