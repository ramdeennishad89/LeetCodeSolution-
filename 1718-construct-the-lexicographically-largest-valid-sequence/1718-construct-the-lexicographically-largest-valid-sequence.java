class Solution {
    public int[] constructDistancedSequence(int n) {
        int[] result = new int[2 * n - 1];
        boolean[] used = new boolean[n + 1];
        backtrack(result, used, 0, n);
        return result;
    }

    private boolean backtrack(int[] result, boolean[] used, int index, int n) {
        if (index == result.length) return true;
        if (result[index] != 0) return backtrack(result, used, index + 1, n);

        for (int num = n; num > 0; num--) {
            if (used[num]) continue;
            if (num == 1) {
                result[index] = 1;
                used[1] = true;
                if (backtrack(result, used, index + 1, n)) return true;
                used[1] = false;
                result[index] = 0;
            } else if (index + num < result.length && result[index + num] == 0) {
                result[index] = num;
                result[index + num] = num;
                used[num] = true;
                if (backtrack(result, used, index + 1, n)) return true;
                used[num] = false;
                result[index] = 0;
                result[index + num] = 0;
            }
        }
        return false; 
    }
}