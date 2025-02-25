class Solution {
    public int numOfSubarrays(int[] arr) {
        int oddCount = 0, evenCount = 1, prefixSum = 0, result = 0;
        int mod = 1000000007;
        for (int num : arr) {
            prefixSum += num;
            if (prefixSum % 2 == 0) {
                result = (result + oddCount) % mod;
                evenCount++;
            } else {
                result = (result + evenCount) % mod;
                oddCount++;
            }
        }
        return result; 
    }
}