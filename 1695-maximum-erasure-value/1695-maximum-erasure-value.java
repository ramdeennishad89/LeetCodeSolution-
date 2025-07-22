class Solution {
    public int maximumUniqueSubarray(int[] nums) {
        Set<Integer> map = new HashSet<>();
        // \U0001f5fa️ This is our map to remember the current numbers in our piggy bank

        int left = 0;
        // \U0001f448 This is the left boundary.

        int curr = 0;
        // \U0001f4b0 This is the money you have at the moment

        int maxSum = 0;
        // \U0001f3c6 This is the best amount that we found so far

        for (int right = 0; right < nums.length; right++) {
            // ➡️ We move from left to right side

            while (map.contains(nums[right])) {
                // \U0001f504 We check if it has a duplicated element in our map
                curr -= nums[left];
                // \U0001f9f9 If it have it we reduce from our current number to remove the duplicated
                map.remove(nums[left]);
                // \U0001f5d1️ Then, we remove from our map
                left++;
                // ⏪ We reduce our left board
            }

            map.add(nums[right]);
            // ➕ If everything is ok, then we add our number in our map
            curr += nums[right];
            // \U0001f4b2 And in our total money \U0001f911

            maxSum = Math.max(maxSum, curr);
            // \U0001f947 We compare if our money is better than our best score
        }

        return maxSum;
        // \U0001f381 Returns the maximum sum.
    }
}