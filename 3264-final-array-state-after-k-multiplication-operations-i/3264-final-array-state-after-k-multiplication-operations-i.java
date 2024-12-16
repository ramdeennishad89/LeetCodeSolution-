class Solution {
    public int[] getFinalState(int[] nums, int k, int multiplier) {
        int minIndex=0;
        for(int i=0;i<k;i++){
            minIndex=0;
            for(int j=0;j<nums.length;j++){
                if(nums[j]<nums[minIndex]){
                    minIndex=j;
                }
            }
            nums[minIndex]=nums[minIndex]*multiplier;
        }
        return nums;
    }
}