class Solution {
    public long maximumTripletValue(int[] nums) 
    {
        long res = 0;		
		int maxDiff = 0; // max(nums[i]-nums[j])
		int maxVal = 0;	// max(nums[i])	
		
		for(int num: nums)
		{
			// Treat num as nums[k]
			res = Math.max(res, (long) maxDiff*num);
			
			// Treat num as nums[j]
			maxDiff = Math.max(maxDiff, maxVal-num);
			
			// Treat num as nums[i]
			maxVal = Math.max(maxVal, num);		
		}
		
		return res;
    }
}