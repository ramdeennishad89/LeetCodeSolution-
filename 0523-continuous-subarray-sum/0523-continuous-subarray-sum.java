class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {

        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0,-1);

        int csm=0;

        for(int i=0; i<nums.length; i++){
            csm= (csm + nums[i])%k;

            if(map.containsKey(csm)){
                if(i- map.get(csm)>=2) return true;
            }else{
                map.put(csm,i);
            }
        }
        return false;
        
    }
}