class Solution {
   public int subsetXORSum(int[] nums) {
        return backtrack(nums, 0, 0);
    }

    private int backtrack(int[] nums, int index, int currentXOR) {
        if (index == nums.length) {
            return currentXOR;
        }
        int withCurrent = backtrack(nums, index + 1, currentXOR ^ nums[index]);
        int withoutCurrent = backtrack(nums, index + 1, currentXOR);
        return withCurrent + withoutCurrent;
    }
}