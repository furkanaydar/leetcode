package grind75.Week3;

import java.util.List;

public class WordBreak {

    static class TrieNode {
        TrieNode[] trieNodes;
        boolean isFinal;

        public TrieNode() {
            this.trieNodes=new TrieNode[26];
            this.isFinal=false;
        }

        public TrieNode(boolean isFinal) {
            this.trieNodes=new TrieNode[26];
            this.isFinal=isFinal;
        }

        TrieNode getChildren(Character c) {
            return trieNodes[c-97];
        }

        void addChild(Character c, boolean asTerminal) {
            TrieNode existing = getChildren(c);

            if (existing != null) {
                existing.isFinal |= asTerminal;
                return;
            }

            trieNodes[c-97] = new TrieNode(asTerminal);
        }
    }

    static class WordBreakTrie {
        TrieNode root;

        public TrieNode getRoot() {
            return root;
        }

        public WordBreakTrie() {
            this.root = new TrieNode();
        }

        void add(String word) {
            TrieNode tmp = root;

            for (int i=0; i<word.length(); i++) {
                char c = word.charAt(i);
                tmp.addChild(c, i == word.length()-1);
                tmp = tmp.getChildren(c);
            }
        }

        TrieNode iterate(String word) {
            TrieNode tmp = root;
            for (int i=0; i<word.length() && tmp != null; i++) {
                tmp = tmp.getChildren(word.charAt(i));
            }

            return tmp;
        }

        boolean hasPrefix(String prefix) {
            return iterate(prefix) != null;
        }

        boolean hasWord(String word) {
            TrieNode node = iterate(word);
            return node != null && node.isFinal;
        }
    }

    public static boolean rec(String target, int ind, WordBreakTrie trie, Boolean[] d) {
        if (d[ind] != null) {
            return d[ind];
        }

        if (ind == target.length()) {
            return d[ind] = true;
        }

        String c="";
        for (int i=ind; i<target.length(); i++) {
            c+=target.charAt(i);
            if (!trie.hasPrefix(c)) {
                return d[ind] = false;
            }

            if (trie.hasWord(c)) {
                boolean res = rec(target, i+1, trie, d);

                if (res) {
                    return d[ind] = true;
                }
            }
        }

        return d[ind] = false;
    }

    public static boolean wordBreak(String s, List<String> wordDict) {
        WordBreakTrie trie = new WordBreakTrie();
        for (String word: wordDict) {
            trie.add(word);
        }

        // d[ind] = can the substring (i,length) can be created from dict
        Boolean[] d = new Boolean[1000];
        rec(s, 0, trie, d);
        return d[s.length()] == Boolean.TRUE;
    }

    public static void main(String[] args) {
        System.out.println(wordBreak("aaaaaaa", List.of("aaaa","aaa")));
        System.out.println(wordBreak("catsasd", List.of("asd","cat", "cats")));
        System.out.println(wordBreak("catsasd", List.of("sasd","ca", "ca")));
    }
}
