class Solution {
    public int minOperations(int[] nums, int k) {
        int res=0;
        PriorityQueue<Integer> pq=new PriorityQueue<>();
        
        for(int i=0; i<nums.length; i++){
            if(nums[i]<k) pq.add(nums[i]);
        }

        long x,y;
        while(!pq.isEmpty()){
            x=pq.poll();
            if(x<k){ 
                res++;
            }      
            if(pq.isEmpty()) break;

            y=pq.poll();
            long val=(long)x*2+y;
            if(val<k){
                pq.add((int)val);
            }
            
        }


        return res;
    }
}