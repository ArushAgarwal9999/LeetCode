class Solution {
    public int numTrees(int n) {
        Integer[] dp = new Integer[n+1];
        return helper(n,dp);
    }
    public int helper(int n,Integer[] dp)
    {
        if(n<=1)
            return 1;
        if(dp[n] != null)
            return dp[n];
        int sum = 0;
        for(int i = 1;i<=n;i++)
        {
            sum+=helper(i-1,dp)*helper(n-i,dp);
        }
        return dp[n] = sum;
    }
}