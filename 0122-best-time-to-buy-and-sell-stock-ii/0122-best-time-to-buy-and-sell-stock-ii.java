class Solution {
    public int maxProfit(int[] prices) {
        int res = helper(0,prices,0,new Integer[prices.length][2]);
        if(res<0)
            return 0;
        return res;
        
    }
    public int helper(int index ,int[] prices, int isBuy, Integer[][] dp )
    {
        if(index>= prices.length)
            return 0;
        
        if(dp[index][isBuy] != null)
            return dp[index][isBuy];
        
        int left = 0;
        int right = 0;
        if(isBuy == 0)
        {
            left = Math.max( helper(index+1,prices,1,dp)-prices[index],helper(index+1,prices,isBuy,dp));   
        }
        else{
            right = Math.max( helper(index+1,prices,0,dp)+prices[index],helper(index+1,prices,isBuy,dp));  
        }
        return dp[index][isBuy] = Math.max(left,right);
    }
    
    
}