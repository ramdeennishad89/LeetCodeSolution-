class Solution {
    public int[] findRedundantConnection(int[][] edges) {
       int n = edges.length;
        int[] parent = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            parent[i] = i;
        }

        for (int[] edge : edges) {
            int u = edge[0], v = edge[1];
            if (find(parent, u) == find(parent, v)) {
                return edge;
            }
            union(parent, u, v);
        }
        return new int[0];
    }

    private int find(int[] parent, int u) {
        if (parent[u] != u) {
            parent[u] = find(parent, parent[u]);
        }
        return parent[u];
    }

    private void union(int[] parent, int u, int v) {
        parent[find(parent, u)] = find(parent, v);
    }
}