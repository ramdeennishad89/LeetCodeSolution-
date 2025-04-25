class Solution {
    public long countInterestingSubarrays(List<Integer> nums, int modulo, int k) {
        int n = nums.size();
        int[] count = new int[n + 1];  // Frequency map
        count[0] = 1;  // Empty prefix
        
        long result = 0;
        int prefixSum = 0;
        
        for (int num : nums) {
            // Check if current element is interesting
            if (num % modulo == k) {
                prefixSum = (prefixSum + 1) % modulo;
            }
            
            // Calculate required complementary prefix
            int required = (prefixSum - k + modulo) % modulo;
            
            // Add count of valid prefixes
            if (required <= n) {
                result += count[required];
            }
            
            // Update frequency map
            count[prefixSum]++;
        }
        
        return result;
    }
}