class Solution {
    public String findDifferentBinaryString(String[] nums) {
         Set<String> set = new HashSet<>();
        for (String num : nums) {
            set.add(num);
        }
        int n = nums.length;
        for (int i = 0; i < (1 << n); i++) {
            String candidate = Integer.toBinaryString(i);
            while (candidate.length() < n) {
                candidate = "0" + candidate;
            }
            if (!set.contains(candidate)) {
                return candidate;
            }
        }
        return "";
    }
}