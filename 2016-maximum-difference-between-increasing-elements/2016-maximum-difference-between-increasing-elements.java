class Solution 
{
    public int maximumDifference(int[] nums) 
    {
        // Step 1 : Initialization
        int minSoFar = nums[0];  
        int maxDiff = -1;

        // Step 2 : Apply Loop and Logic
        for (int i = 1; i < nums.length; i++) 
        {  
            if (nums[i] > minSoFar) 
            {
                maxDiff = Math.max(maxDiff, nums[i] - minSoFar);
            } 
            else 
            {
                minSoFar = nums[i];
            }
        }

        // Step 3 : Return the Result
        return maxDiff;  
    }
}