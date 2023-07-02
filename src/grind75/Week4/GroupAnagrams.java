package grind75.Week4;

import java.util.*;

public class GroupAnagrams {

    class Entry implements Comparable<Entry> {
        int index;
        String sortedString;

        public Entry(int index, String sortedString) {
            this.index = index;
            this.sortedString = sortedString;
        }

        @Override
        public int compareTo(Entry o) {
            return this.sortedString.compareTo(o.sortedString) < 0 ? -1 : 1;
        }
    }

    public List<List<String>> groupAnagrams(String[] strs) {
        List<Entry> entries = new ArrayList<>();

        for (int i=0; i<strs.length; i++) {
            char[] arr = strs[i].toCharArray();
            Arrays.sort(arr);
            entries.add(new Entry(i, new String(arr)));
        }

        Collections.sort(entries);
        String it = entries.get(0).sortedString;
        List<List<String>> res = new ArrayList<>();
        List<String> cur = new ArrayList<>();
        for (Entry entry : entries) {
            if (!Objects.equals(entry.sortedString, it)) {
                it = entry.sortedString;
                res.add(cur);
                cur = new ArrayList<>();
            }

            cur.add(strs[entry.index]);
        }

        res.add(cur);
        return res;
    }

    public static void main(String[] args) {
        GroupAnagrams c = new GroupAnagrams();
        c.groupAnagrams(new String[] {"eat","tea","tan","ate","nat","bat"});
    }
}
