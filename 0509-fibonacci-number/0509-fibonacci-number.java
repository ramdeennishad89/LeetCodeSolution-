class Solution {
    public int fib(int n) {
	// if(n <= 1) 
	// 	return n;
	// return fib(n - 1) + fib(n - 2);
        int dp[] = new int[n+1];
        Arrays.fill(dp, -1);
        int ans= fibHelper(n, dp);
        return ans;
    }
    
    public int fibHelper(int n, int [] dp){
        if(n==0 || n==1)return n;
        if(dp[n]!= -1) return dp[n];
        int a= fibHelper(n-1, dp);
        int b= fibHelper(n-2, dp);
        dp[n]=a+b;
        return a+b;
    }
}