class Solution {
   public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        int[][] dist = new int[n][n];

        // Initialize the distance matrix
        for (int i = 0; i < n; i++) {
            Arrays.fill(dist[i], Integer.MAX_VALUE);
            dist[i][i] = 0;
        }

        // Set initial edge weights
        for (int[] edge : edges) {
            dist[edge[0]][edge[1]] = edge[2];
            dist[edge[1]][edge[0]] = edge[2];
        }

        // Floyd-Warshall algorithm to find shortest paths between all pairs of cities
        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (dist[i][k] < Integer.MAX_VALUE && dist[k][j] < Integer.MAX_VALUE) {
                        dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                    }
                }
            }
        }

        int ansNode = -1;
        int cityCnt = Integer.MAX_VALUE;
        for (int i = n - 1; i >= 0; i--) {
            int cnt = 0;
            for (int j = 0; j < n; j++) {
                if (dist[i][j] <= distanceThreshold && i != j) {
                    cnt++;
                }
            }

            if (cnt < cityCnt) {
                ansNode = i;
                cityCnt = cnt;
            }
        }

        return ansNode;
   }
}