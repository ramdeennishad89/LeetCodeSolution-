class Solution {
    public int stoneGameII(int[] piles) {
        int n = piles.length;
        int[][] dp = new int[n][n];
        int[] suffixSum = new int[n];
        suffixSum[n - 1] = piles[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            suffixSum[i] = suffixSum[i + 1] + piles[i];
        }
        return helper(piles, dp, suffixSum, 0, 1);
    }

    private int helper(int[] piles, int[][] dp, int[] suffixSum, int i, int M) {
        if (i == piles.length) return 0;
        if (2 * M >= piles.length - i) return suffixSum[i];
        if (dp[i][M] != 0) return dp[i][M];
        int min = Integer.MAX_VALUE;
        for (int x = 1; x <= 2 * M; x++) {
            min = Math.min(min, helper(piles, dp, suffixSum, i + x, Math.max(M, x)));
        }
        dp[i][M] = suffixSum[i] - min;
        return dp[i][M];
    }
}