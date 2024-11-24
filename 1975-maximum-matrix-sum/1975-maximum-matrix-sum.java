class Solution {
    public long maxMatrixSum(int[][] matrix) {
        int n = matrix.length;
        long sum = 0;
        int minAbs = Integer.MAX_VALUE;
        int negativeCount = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int value = matrix[i][j];
                sum += Math.abs(value);
                if (value < 0) negativeCount++;
                minAbs = Math.min(minAbs, Math.abs(value));
            }
        }

        if (negativeCount % 2 != 0) {
            sum -= 2 * minAbs;
        }
        return sum;
    }
}