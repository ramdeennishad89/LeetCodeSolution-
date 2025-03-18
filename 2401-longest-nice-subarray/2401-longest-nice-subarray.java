class Solution {
    public int longestNiceSubarray(int[] nums) {
        int maxLength = 0, currentLength = 0, bitwiseAnd = 0;
        int left = 0;
        for (int right = 0; right < nums.length; right++) {
            while ((bitwiseAnd & nums[right]) != 0) {
                bitwiseAnd ^= nums[left];
                left++;
            }
            bitwiseAnd |= nums[right];
            currentLength = right - left + 1;
            maxLength = Math.max(maxLength, currentLength);
        }
        return maxLength;
    }
}