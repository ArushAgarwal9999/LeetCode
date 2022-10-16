class Solution {
    public int minDifficulty(int[] jobDifficulty, int d) {
        if(jobDifficulty.length<d)
        	return -1;
        
        int res= helper(jobDifficulty, d, 0, new Integer[jobDifficulty.length][d+1]);
        if(res>=40000)
        	return -1;
        
        return res;
        
        
    }
	public int helper(int[] jobDifficulty, int d, int index,Integer[][] dp)
	{
		if(index>= jobDifficulty.length || d == 0)
		{
			if(index>= jobDifficulty.length && d == 0)
				return 0;
			
			return 400000;
		}
		if(dp[index][d] != null)
			return dp[index][d];
		int res = Integer.MAX_VALUE; ;
		int max = 0;
		for(int i = index;i<jobDifficulty.length;i++)
		{
			max = Math.max(max, jobDifficulty[i]);
            int help = helper(jobDifficulty, d-1, i+1, dp);
			res = Math.min(res,help+max);
		}
		
		return dp[index][d] = res;
	}
}