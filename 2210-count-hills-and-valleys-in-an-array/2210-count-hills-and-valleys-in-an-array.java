class Solution 
{
    public int countHillValley(int[] nums) 
    {
        // Step 1: Remove consecutive duplicates (Data Compression)
        List<Integer> filtered = new ArrayList<>();
        filtered.add(nums[0]);
        for (int i = 1; i < nums.length; i++) 
        {
            if (nums[i] != nums[i - 1]) 
            {
                filtered.add(nums[i]);
            }
        }

        // Step 2: Loop through the filtered array (Sliding Comparison)
        int count = 0;
        for (int i = 1; i < filtered.size() - 1; i++) 
        {
            int prev = filtered.get(i - 1);
            int curr = filtered.get(i);
            int next = filtered.get(i + 1);

            // Step 3: Check for hills or valleys (Local Minima/Maxima Detection)
            if ((curr > prev && curr > next) || (curr < prev && curr < next)) 
            {
                count++; // Step 4: Increment the count for hills/valleys (Greedy Counting)
            }
        }

        return count;
    }
}