class Solution {
    int mod = 1000000007;
public int checkRecord(int n) {
        return getMax(n, 1, 2, new Integer[n+1][3][3]);
    }
	public int getMax(int current, int absentRemaning, int lateRemaing,Integer[][][] dp )
	{
		if(current==0)
			return 1;
		
		if(dp[current][absentRemaning][lateRemaing] != null)
			return dp[current][absentRemaning][lateRemaing];
		
		int result = 0;
		result+=(getMax(current-1, absentRemaning, 2,dp)%mod);
		result%=mod;
		if(absentRemaning>0)
		{
			result+=(getMax(current-1, absentRemaning-1, 2,dp)%mod);
			result%=mod;
		}
		if(lateRemaing>0)
		{
			result+=(getMax(current-1, absentRemaning, lateRemaing-1,dp)%mod);
			result%=mod;
		}
		return dp[current][absentRemaning][lateRemaing]= result%mod;
		
	}
}