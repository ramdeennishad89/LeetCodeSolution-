class Solution {
    public int minOperations(int[][] grid, int x) {
        int m = grid.length, n = grid[0].length;
        int[] arr = new int[m * n];
        int index = 0;
        for (int[] row : grid) {
            for (int num : row) {
                arr[index++] = num;
            }
        }
        Arrays.sort(arr);
        int median = arr[arr.length / 2];
        int operations = 0;
        for (int num : arr) {
            if ((num - median) % x != 0) return -1;
            operations += Math.abs(num - median) / x;
        }
        return operations;
    }
}