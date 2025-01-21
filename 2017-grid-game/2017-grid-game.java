class Solution {
    public long gridGame(int[][] grid) {
        int n = grid[0].length;
        long[] prefixSum1 = new long[n + 1];
        long[] prefixSum2 = new long[n + 1];
        for (int i = 0; i < n; i++) {
            prefixSum1[i + 1] = prefixSum1[i] + grid[0][i];
            prefixSum2[i + 1] = prefixSum2[i] + grid[1][i];
        }
        long result = Long.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            long top = prefixSum1[n] - prefixSum1[i + 1];
            long bottom = prefixSum2[i];
            result = Math.min(result, Math.max(top, bottom));
        }
        return result; 
    }
}