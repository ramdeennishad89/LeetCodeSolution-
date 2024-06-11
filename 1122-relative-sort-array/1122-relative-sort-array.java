class Solution {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        int max=0;
        for(int a: arr1){
            max= Math.max(max, a);
        }
       int count[] = new int[max+1];
       for(int i=0; i<arr1.length; i++){
           count[arr1[i]]++;
       }
        int ans[]= new int[arr1.length];
        int index=0;
        for(int i=0; i<arr2.length; i++){
            while(count[arr2[i]]>0){
                ans[index] =arr2[i];
                index++;
                count[arr2[i]]--;
            }
        }
        for(int i=0; i<count.length; i++){
            while(count[i]>0){
                ans[index]=i;
                index++;
                count[i]--;
            }
        }
        return ans;
    }
}