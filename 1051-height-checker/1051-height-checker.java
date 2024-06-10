class Solution {
    public int heightChecker(int[] heights) {
        int [] exp= heights.clone();
        Arrays.sort(exp);
        int count=0;
        for(int i=0; i<heights.length; i++){
            if(heights[i] != exp[i]){
                count++;
            }
        }
        return count;
    }
}