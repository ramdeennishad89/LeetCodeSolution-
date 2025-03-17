class Solution {
    public boolean divideArray(int[] nums) {
        HashMap<Integer, Integer> countMap = new HashMap<>();
        for (int num : nums) {
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);
        }
        for (int count : countMap.values()) {
            if (count % 2 != 0) {
                return false;
            }
        }
        return true;
    }
}