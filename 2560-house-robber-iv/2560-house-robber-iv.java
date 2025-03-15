class Solution {
    public int minCapability(int[] nums, int k) {
       int left = 0, right = 0;
        for (int num : nums) {
            right = Math.max(right, num);
        }
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (canRob(nums, k, mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    private boolean canRob(int[] nums, int k, int maxCap) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] <= maxCap) {
                count++;
                i++; // Skip the next house
            }
        }
        return count >= k; 
    }
}