class Solution {
   public int minimumSize(int[] nums, int maxOperations) {
        int left = 1, right = 0;
        for (int num : nums) {
            right = Math.max(right, num);
        }
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (canDistribute(nums, maxOperations, mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    private boolean canDistribute(int[] nums, int maxOperations, int maxBalls) {
        int operations = 0;
        for (int num : nums) {
            operations += (num - 1) / maxBalls;
            if (operations > maxOperations) {
                return false;
            }
        }
        return true;
    }
}