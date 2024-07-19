class Solution {
    public List<Integer> luckyNumbers (int[][] matrix) {
        int n = matrix.length, m = matrix[0].length;
        List<Integer> ans = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int row = i, col = j, rowMin = Integer.MAX_VALUE, colMax = Integer.MIN_VALUE;
                for (int k = 0; k < m; k++) {
                    rowMin = Math.min(rowMin, matrix[row][k]);
                }
                for (int k = 0; k < n; k++) {
                    colMax = Math.max(colMax, matrix[k][col]);
                }

                if (matrix[i][j] == rowMin && matrix[i][j] == colMax) {
                    ans.add(matrix[i][j]);
                }
            }
        }
        return ans;
    }
}