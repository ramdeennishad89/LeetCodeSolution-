class Solution {
    public int minimizedMaximum(int n, int[] quantities) {

        Arrays.sort(quantities);
        
        int low = 1, high = quantities[quantities.length - 1],ans=0;

        while (low <= high) {
            
            int mid = (low + high) / 2;

            int totSum = 0;

            for (int i = 0; i < quantities.length; i++) {

                totSum = totSum + (int) Math.ceil((double) quantities[i] / (double) mid);

            }
            
            if (totSum <= n) {
                ans = mid;
                high = mid - 1;

            }
            else
                low = mid + 1;

        }


        return ans;
        

        
    }
}