class Solution {
    public int[] singleNumber(int[] nums) {
        int xor=0;
        for(int num: nums){
            xor^=num;
        }
        int lowestbit= xor & (- xor);
        int result[] = new int[2];

        for(int num: nums){
            if((lowestbit & num) == 0 )
                result[0] ^= num;
            else
                result[1] ^= num;
        }
        return result;
        
    }
}