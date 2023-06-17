package common;

/* Union Find */
public class DisjointSet {
    public int[] parent;
    public int[] rank;

    public DisjointSet(int size) {
        parent = new int[size];
        rank = new int[size];

        for (int i=0; i<size; i++) {
            parent[i] = i;
            rank[i] = 0;
        }
    }

    public void union(int x, int y) {
        int rx = find(x), ry = find(y);

        if (rx != ry) {
            if (rank[rx] > rank[ry]) {
                parent[ry] = rx;
            } else if (rank[rx] < rank[ry]) {
                parent[rx] = ry;
            } else {
                parent[rx] = ry;
                rank[ry]++;
            }
        }
    }

    // O(logN) due to path compression
    public int find(int n) {
        if (parent[n] != n) {
            parent[n] = find(parent[n]);
        }

        return n;
    }

    public boolean isConnected(int x, int y) {
        return find(x) == find(y);
    }
}
