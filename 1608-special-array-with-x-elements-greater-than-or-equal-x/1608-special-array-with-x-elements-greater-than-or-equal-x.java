class Solution {
    public int specialArray(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;

        for(int x=0; x<=n; x++){
            int count = 0;
            for( int num : nums){
                if(num >= x){
                    count++;
                }
            }
            if(count == x){
                return x;
            }
        }
        return -1;
        
    }
}