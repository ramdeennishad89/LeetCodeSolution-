class Solution {
    public String kthDistinct(String[] arr, int k) {
        Map<String, Integer> countMap = new HashMap<>();
        for (String s : arr) {
            countMap.put(s, countMap.getOrDefault(s, 0) + 1);
        }
        for (String s : arr) {
            if (countMap.get(s) == 1) {
                k--;
                if (k == 0) {
                    return s;
                }
            }
        }
        return "";
    }
}