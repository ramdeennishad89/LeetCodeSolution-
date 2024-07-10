class Solution {
    public boolean isMonotonic(int[] nums) {
        int n=nums.length-1;
        boolean inc=true;
        boolean dec=true;
        for(int i=0;i<n;i++){
            if(nums[i]>nums[i+1])
                inc=false;
            if(nums[i]<nums[i+1])
                dec=false;
        }
        return (inc||dec);
    }
}