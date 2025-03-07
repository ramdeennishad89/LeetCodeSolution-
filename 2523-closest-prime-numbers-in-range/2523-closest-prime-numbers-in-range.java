class Solution {
    public int[] closestPrimes(int left, int right) {
        
        if(left == 1) left++;
        int map[] = new int[right+1];

        for(int i = 2 ; i < right+1 ; i++)
        {
            if(map[i] == 1) continue;
            for(int j = 2 ; j <= right/2 ; j++)
            {
                int x = i*j;
                if(x > right) break;
                map[x] = 1;
            }
        }

        ArrayList<Integer> list = new ArrayList<>();
        int ans[] = new int[2];
        ans[0] = left; ans[1] = right;

        for(int i = left; i <= right ; i++)
        {
            if(map[i] == 0) list.add(i);
        }

        if(list.size() < 2) return new int[]{-1,-1};
        for(int i = 1; i < list.size(); i++)
        {
            if(ans[1]-ans[0] > list.get(i)-list.get(i-1))
            {
                ans[0] = list.get(i-1);
                ans[1] = list.get(i);
            }
        }

        return ans;

    }
}