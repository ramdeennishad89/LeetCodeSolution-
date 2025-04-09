class Solution {
    public int minOperations(int[] nums, int k) {
        Set<Integer> seen = new HashSet<>();
        for (int num : nums) {
            if (num < k) return -1;
            if (num > k) seen.add(num);
        }
        return seen.size();
    }
}