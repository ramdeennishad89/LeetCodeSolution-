class Solution {
    public int[] frequencySort(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }

        Integer[] arrobj = new Integer[nums.length];
        for (int i = 0; i < nums.length; i++) {
            arrobj[i] = nums[i];
        }
        
        Arrays.sort(arrobj, (a, b) -> {
            if (map.get(a).equals(map.get(b))) {
                return Integer.compare(b, a);
            }
            return Integer.compare(map.get(a), map.get(b)); 
        });
        
        for (int i = 0; i < nums.length; i++) {
            nums[i] = arrobj[i];
        }

        return nums;
            
    }
}