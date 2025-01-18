class Solution {
     private static final int[][] DIRECTIONS = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public int minCost(int[][] grid) {
        int n = grid.length, m = grid[0].length;
        int[][] cost = new int[n][m];
        for (int[] row : cost) Arrays.fill(row, Integer.MAX_VALUE);
        cost[0][0] = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[2] - b[2]);
        pq.offer(new int[]{0, 0, 0});

        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int x = curr[0], y = curr[1], c = curr[2];

            if (x == n - 1 && y == m - 1) return c;

            for (int i = 0; i < 4; i++) {
                int nx = x + DIRECTIONS[i][0];
                int ny = y + DIRECTIONS[i][1];
                if (nx >= 0 && nx < n && ny >= 0 && ny < m) {
                    int newCost = c + (grid[x][y] == i + 1 ? 0 : 1);
                    if (newCost < cost[nx][ny]) {
                        cost[nx][ny] = newCost;
                        pq.offer(new int[]{nx, ny, newCost});
                    }
                }
            }
        }
        return -1; 
    }
}