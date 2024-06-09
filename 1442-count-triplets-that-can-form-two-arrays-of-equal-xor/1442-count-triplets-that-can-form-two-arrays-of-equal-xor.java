class Solution {
    public int countTriplets(int[] arr) {
        int n= arr.length;
        int count = 0;
        for(int i=0; i<n-1; i++){
            int xorA=0;
            for(int j=i; j<n-1; j++){
                xorA^= arr[j];
                int xorB = 0;
                for(int k=j+1; k<n; k++){
                    xorB ^= arr[k];
                    if(xorA == xorB){
                        count++;
                    }
                }
            }
        }
        return count;
        
    }
}