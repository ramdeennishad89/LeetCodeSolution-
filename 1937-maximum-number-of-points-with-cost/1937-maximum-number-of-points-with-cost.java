class Solution {
    public long maxPoints(int[][] points) {
        int m = points.length;
        int n = points[0].length;
        long[] prev = new long[n];
        for (int j = 0; j < n; j++) {
            prev[j] = points[0][j];
        }
        for (int i = 1; i < m; i++) {
            long[] left = new long[n];
            long[] right = new long[n];
            left[0] = prev[0];
            for (int j = 1; j < n; j++) {
                left[j] = Math.max(left[j - 1] - 1, prev[j]);
            }
            right[n - 1] = prev[n - 1];
            for (int j = n - 2; j >= 0; j--) {
                right[j] = Math.max(right[j + 1] - 1, prev[j]);
            }
            for (int j = 0; j < n; j++) {
                prev[j] = points[i][j] + Math.max(left[j], right[j]);
            }
        }
        long maxPoints = 0;
        for (long point : prev) {
            maxPoints = Math.max(maxPoints, point);
        }
        return maxPoints;    
    }
}