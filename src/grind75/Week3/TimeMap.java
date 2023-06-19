package grind75.Week3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TimeMap {

    class TimestampEntry {
        String value;
        int timestamp;

        public TimestampEntry(String value, int timestamp) {
            this.value = value;
            this.timestamp = timestamp;
        }
    }

    Map<String, List<TimestampEntry>> store;

    public TimeMap() {
        store = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        if (!store.containsKey(key)) {
            store.put(key, new ArrayList<>());
        }

        store.get(key).add(new TimestampEntry(value, timestamp));
    }

    public String get(String key, int timestamp) {
        List<TimestampEntry> entriesForKey = store.getOrDefault(key, List.of());

        if (entriesForKey.isEmpty()) {
            return "";
        }

        int l=0, m=0, r=entriesForKey.size()-1;

        while (l<=r) {
            m=l+(r-l)/2;
            if (entriesForKey.get(m).timestamp > timestamp) {
                r=m-1;
            } else if(entriesForKey.get(m).timestamp < timestamp) {
                l=m+1;
            } else {
                break;
            }
        }


        int val;
        if (entriesForKey.get(m).timestamp<=timestamp) {
            val = m;
        } else {
            val = m-1;
        }

        if (val == -1) {
            return "";
        }
        return entriesForKey.get(val).value;
    }

    public static void main(String[] args) {
        TimeMap timeMap = new TimeMap();
        timeMap.set("love", "high", 10);
        timeMap.set("love", "low", 20);
        timeMap.get("love", 5);
        timeMap.get("love", 10);
        timeMap.get("love", 15);
        timeMap.get("love", 20);
        timeMap.get("love", 25);

    }
}