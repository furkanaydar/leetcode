package grind75.Week2;

public class NumberOfIslandsUnionFind {

    static class UnionFind {
        int[] rank;
        int[] parent;

        public UnionFind(int size) {
            rank = new int[size];
            parent = new int[size];

            for (int i=0; i<size; i++) {
                rank[i] = 0;
                parent[i] = i;
            }
        }

        public UnionFind(char[][] grid) {
            int size = grid.length*grid[0].length;
            rank = new int[size];
            parent = new int[size];

            for (int i=0; i<grid.length; i++) {
                for (int j=0; j<grid[0].length; j++) {
                    int ind = i*grid[0].length+j;
                    parent[ind] = ind;
                    rank[ind] = grid[i][j] == '1' ? 1 : 0;
                }
            }

        }

        public int find(int index) {
            if (parent[index] != index) {
                parent[index] = find(parent[index]);
            }

            return parent[index] ;
        }

        public void union(int index1, int index2) {
            int root1 = find(index1);
            int root2 = find(index2);

            if (root1 != root2) {
                if (rank[root1] > rank[root2]) {
                    parent[root2] = root1;
                    rank[root1]+=rank[root2];
                    rank[root2]=0;
                } else {
                    parent[root1] = root2;
                    rank[root2]+=rank[root1];
                    rank[root1]=0;
                }
            }
        }

        public int countSets() {
            int r=0;
            for (int i=0; i<rank.length; i++) {
                if (rank[i] != 0) {
                    r++;
                }
            }
            return r;
        }
    }

    public static int numberOfIslands(char[][] grid) {
        int[][] r = new int[][] {{0, -1}, {-1, 0}};
        UnionFind uf = new UnionFind(grid);

        for (int i=0; i<grid.length; i++) {
            for (int j=0; j<grid[i].length; j++) {
                for (int d=0; d<2; d++) {
                    int nx=i+r[d][0], ny=j+r[d][1];
                    if (nx<0 || nx>= grid.length || ny<0 || ny>=grid[i].length) {
                        continue;
                    }

                    if (grid[i][j] == '1' && grid[nx][ny] == '1') {
                        int pi = i*grid[0].length+j;
                        int ni = nx*grid[0].length+ny;
                        uf.union(pi, ni);
                    }
                }
            }
        }

        return uf.countSets();
    }

    public static void main(String[] args) {
        char[][] grid = new char[][] {
                {'1','1','1','1','0'},
                {'1','1','0','1','0'},
                {'1','1','0','0','0'},
                {'0','0','0','0','0'}
        };
        char[][] grid2 = new char[][] {
                {'1','1','0','0','0'},
                {'1','1','0','0','0'},
                {'0','0','1','0','0'},
                {'0','0','0','1','1'}
        };

        System.out.println(numberOfIslands(grid));
    }
}
