class Solution 
{
    public int maximumLength(int[] nums) 
    {
        // Step 1: Initialize counters
        int evenCount = 0, oddCount = 0;
        int altEven = 0, altOdd = 0;

        // Step 2: Loop through each number
        for (int num : nums) 
        {
            int p = num % 2;  // Step 2: Find if number is even or odd

            // Step 3: Update counters
            if (p == 0) 
            { 
                evenCount++;           // Count for same-parity subsequence
                altEven = altOdd + 1;  // Extend alternating sequence ending in odd
            } 
            else 
            { 
                oddCount++;           // Count for same-parity subsequence
                altOdd = altEven + 1; // Extend alternating sequence ending in even
            }
        }

        // Step 4 & 5: Return the maximum length from all 4 options
        return Math.max(Math.max(evenCount, oddCount), Math.max(altEven, altOdd));
    }
}