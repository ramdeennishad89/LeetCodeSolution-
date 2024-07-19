class Solution {
 public List<Integer> countSmaller(int[] nums) {
        List<Integer> series = new ArrayList<>();
        List<Integer> ans = new ArrayList<>();
        for (int i = nums.length - 1; i >= 0; i--) {
            int pos = findInsertPosition(series, nums[i]);
            series.add(pos, nums[i]);
            ans.add(pos);
        }
        Collections.reverse(ans);
        return ans;
    }
    private int findInsertPosition(List<Integer> series, int target) {
        int l = 0;
        int h = series.size();
        while (l < h) {
            int mid = (l + h) / 2;
            if (series.get(mid) >= target) {
                h = mid;
            } else {
                l = mid + 1;
            }
        }
        
        return l;
    }
}