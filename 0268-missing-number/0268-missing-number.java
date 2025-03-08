class Solution {
    public int missingNumber(int[] nums) {
        int res;
        int n=nums.length;
        res=n*(n+1)/2;
        int count=0;
        for(int i=0;i<n;i++){
            count+=nums[i];
        }
        return res-count;
        
        
    }
}
