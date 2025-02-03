class Solution {
    public int longestMonotonicSubarray(int[] nums) {
 if (nums.length == 0) return 0;
        int maxLength = 1;
        int start = 0;
        boolean increasing = true;
        for (int end = 1; end < nums.length; end++) {
            if (nums[end] > nums[end - 1]) {
                if (!increasing) {
                    start = end - 1;
                    increasing = true;
                }
            } else if (nums[end] < nums[end - 1]) {
                if (increasing) {
                    start = end - 1;
                    increasing = false;
                }
            } else {
                start = end;
            }
            maxLength = Math.max(maxLength, end - start + 1);
        }
        return maxLength;
    }
}