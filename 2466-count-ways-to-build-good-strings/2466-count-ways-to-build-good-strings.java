class Solution {
   public int countGoodStrings(int low, int high, int zero, int one) {
	int result = 0;
	Integer[] dp = new Integer[high+1];
	for(int i = low;i<=high;i++)
	{
		result=((result%1000000007)+ (getCountGoodStrings(i, dp, zero, one)%1000000007))%1000000007;
		
	}
    return result;
}
public int getCountGoodStrings(int max , Integer[] dp,int zero, int one)
{
	if(max ==0)
		return 1;
	if(max<0)
		return 0;
	if(dp[max] != null)
		return dp[max]%1000000007; 
	
	int sum = getCountGoodStrings(max-zero, dp, zero, one)%1000000007+getCountGoodStrings(max-one, dp, zero, one)%1000000007;
	return dp[max]= sum%1000000007;
	
}
}