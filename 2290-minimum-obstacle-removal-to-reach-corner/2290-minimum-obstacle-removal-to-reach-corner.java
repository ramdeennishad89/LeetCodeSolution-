class Solution {
    public int minimumObstacles(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        
        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        
        Deque<int[]> deque = new ArrayDeque<>();
        deque.add(new int[]{0, 0, 0}); 
        int[][] visited = new int[m][n];
        for (int[] row : visited) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }
        visited[0][0] = 0;
        
        while (!deque.isEmpty()) {
            int[] current = deque.poll();
            int x = current[0], y = current[1], obstaclesRemoved = current[2];
            
            if (x == m - 1 && y == n - 1) {
                return obstaclesRemoved; 
            }
            
            for (int[] dir : directions) {
                int newX = x + dir[0];
                int newY = y + dir[1];
                
                if (newX >= 0 && newX < m && newY >= 0 && newY < n) {
                    int newObstaclesRemoved = obstaclesRemoved + grid[newX][newY];
                    
                    if (newObstaclesRemoved < visited[newX][newY]) {
                        visited[newX][newY] = newObstaclesRemoved;
                        
                        if (grid[newX][newY] == 0) {
                            deque.addFirst(new int[]{newX, newY, newObstaclesRemoved});
                        } else {
                            deque.addLast(new int[]{newX, newY, newObstaclesRemoved});
                        }
                    }
                }
            }
        }
        
        return -1;
    }
}