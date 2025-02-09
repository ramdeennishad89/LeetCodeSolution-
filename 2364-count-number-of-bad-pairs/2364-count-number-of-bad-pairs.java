class Solution {
    public long countBadPairs(int[] nums) {
    int n = nums.length;
        long totalPairs = (long) n * (n - 1) / 2;
        HashMap<Integer, Integer> map = new HashMap<>();
        long goodPairs = 0;
        for (int i = 0; i < n; i++) {
            int value = nums[i] - i;
            if (map.containsKey(value)) {
                goodPairs += map.get(value);
            }
            map.put(value, map.getOrDefault(value, 0) + 1);
        }
        return totalPairs - goodPairs;
    }
}