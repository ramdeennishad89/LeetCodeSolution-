class Solution {
    public int minOperations(int[] nums) {
        int c=0;
       for(int i=0;i<nums.length-2;i++) 
       {
        if(nums[i]==0)
        {
            nums[i]=1;
            nums[i+1]=nums[i+1]==1?0:1;
            nums[i+2]=nums[i+2]==1?0:1;
            c++;
        }
       }
       if(nums[nums.length-1]==0|| nums[nums.length-2]==0)
        return -1;
      return c;
        
    }
}