class Solution {
    public int numMagicSquaresInside(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        if (n < 3 || m < 3) return 0;
        int cnt = 0;
        int[][][] magicSq = {
            {{4, 9, 2}, {3, 5, 7}, {8, 1, 6}},
            {{2, 7, 6}, {9, 5, 1}, {4, 3, 8}},
            {{6, 1, 8}, {7, 5, 3}, {2, 9, 4}},
            {{8, 3, 4}, {1, 5, 9}, {6, 7, 2}},
            {{4, 3, 8}, {9, 5, 1}, {2, 7, 6}},
            {{2, 9, 4}, {7, 5, 3}, {6, 1, 8}},
            {{6, 7, 2}, {1, 5, 9}, {8, 3, 4}},
            {{8, 1, 6}, {3, 5, 7}, {4, 9, 2}}
        };
        for (int rStart = 0; rStart <= n - 3; rStart++) {
            for (int cStart = 0; cStart <= m - 3; cStart++) {
                int[][] subgrid = new int[3][3];
                for (int i = 0; i < 3; i++) {
                    for (int j = 0; j < 3; j++) {
                        subgrid[i][j] = grid[rStart + i][cStart + j];
                    }
                }
                for (int i = 0; i <= 7; i++) {
                    if (java.util.Arrays.deepEquals(magicSq[i], subgrid)) {
                        cnt++;
                    }
                }
            }
        }
        return cnt;
    }
}