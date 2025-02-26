class Solution {
    public int maxAbsoluteSum(int[] nums) {
        int maxSum = 0, minSum = 0, maxAbsSum = 0;
        for (int num : nums) {
            maxSum = Math.max(maxSum + num, num);
            minSum = Math.min(minSum + num, num);
            maxAbsSum = Math.max(maxAbsSum, Math.max(maxSum, -minSum));
        }
        return maxAbsSum; 
    }
}