package grind75.Week3;

import java.util.*;

public class AccountsMerge {
    static class UnionFind {
        public int[] parent;
        public int[] rank;

        public UnionFind(int size) {
            parent = new int[size];
            rank = new int[size];

            for (int i=0; i<size; i++) {
                parent[i]=i;
                rank[i]=0;
            }
        }

        public void union(int e1, int e2) {
            int root1=find(e1), root2=find(e2);

            if (root1 != root2) {
                if (rank[root1]<rank[root2]) {
                    parent[root1]=root2;
                } else if(rank[root2]<rank[root1]) {
                    parent[root2]=root1;
                } else {
                    parent[root2]=root1;
                    rank[root1]++;
                }
            }
        }

        public int find(int e) {
            if (parent[e] != e) {
                parent[e]=find(parent[e]);
            }

            return parent[e];
        }

    }

    public static List<List<String>> accountsMerge(List<List<String>> accounts) {
        UnionFind uf = new UnionFind(accounts.size());
        Map<String, Integer> mails = new HashMap<>();
        Map<Integer, String> names = new HashMap<>();

        for (int i=0; i<accounts.size(); i++) {
            names.put(i, accounts.get(i).get(0));
            for (int j=1; j<accounts.get(i).size(); j++) {
                String cur = accounts.get(i).get(j);
                if (mails.containsKey(cur)) {
                    uf.union(i, mails.get(cur));
                } else {
                    mails.put(cur, i);
                }
            }
        }

        Map<Integer, TreeSet<String>> indexToMails = new HashMap<>();
        for (String k: mails.keySet()) {
            int group = uf.find(mails.get(k));
            if (!indexToMails.containsKey(group)) {
                indexToMails.put(group, new TreeSet<>());
            }

            indexToMails.get(group).add(k);
        }

        List<List<String>> result = new ArrayList<>();
        for (Integer i: indexToMails.keySet()) {
            List<String> curAccount = new ArrayList<>();
            curAccount.add(names.get(i));
            curAccount.addAll(indexToMails.get(i));
            result.add(curAccount);
        }

        return result;
    }

    public static List<List<String>> case1() {
        return List.of(
                List.of("John","johnsmith@mail.com","john_newyork@mail.com"),
                List.of("John","johnsmith@mail.com","john00@mail.com"),
                List.of("Mary","mary@mail.com"),
                List.of("John","johnnybravo@mail.com")
        );
    }
    public static void main(String[] args) {
        List<List<String>> res = accountsMerge(case1());
    }
}
