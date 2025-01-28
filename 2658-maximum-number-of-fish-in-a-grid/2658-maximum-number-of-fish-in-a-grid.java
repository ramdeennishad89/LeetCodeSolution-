class Solution {
    private int dfs(int[][] grid, int i, int j) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] <= 0) {
            return 0;
        }
        int fish = grid[i][j];
        grid[i][j] = 0; // Mark as visited
        fish += dfs(grid, i + 1, j);
        fish += dfs(grid, i - 1, j);
        fish += dfs(grid, i, j + 1);
        fish += dfs(grid, i, j - 1);
        return fish;
    }

    public int findMaxFish(int[][] grid) {
        int maxFish = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] > 0) {
                    maxFish = Math.max(maxFish, dfs(grid, i, j));
                }
            }
        }
        return maxFish;  
    }
}