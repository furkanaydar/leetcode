package grind75.Week3;

import java.util.*;

public class TopKFrequentWords {

    class Entry implements Comparable<Entry> {
        String val;
        int count;

        public Entry(String val, int count) {
            this.val = val;
            this.count = count;
        }

        @Override
        public int compareTo(Entry o) {
            if (o.count == count) {
                return val.compareTo(o.val);
            }

            return o.count-count;
        }
    }

    public List<String> topKFrequent(String[] words, int k) {
        Arrays.sort(words);
        PriorityQueue<Entry> pq = new PriorityQueue<>();

        String it = words[0];
        int c = 0;
        for (String str: words) {
            if (!Objects.equals(str, it)) {
                pq.add(new Entry(it, c));
                c = 0;
                it = str;
            }

            c++;
        }

        pq.add(new Entry(it, c));

        List<String> res = new ArrayList<>();
        for (int i=0; i<k && !pq.isEmpty(); i++) {
            res.add(pq.poll().val);
        }

        return res;
    }

    public static void main(String[] args) {
        TopKFrequentWords s = new TopKFrequentWords();
        s.topKFrequent(new String[] {"the","day","is","sunny","the","the","the","sunny","is","is"}, 4);
    }
}
