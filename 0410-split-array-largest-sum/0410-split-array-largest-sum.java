class Solution {
    public int splitArray(int[] nums, int m) {
		int res = minSplitArray(nums, m, 0, new Integer[nums.length][m+1]);
		return  res;
        
    }
public int minSplitArray(int[] nums, int m, int index, Integer[][] dp)
{
	if(index >= nums.length || m ==1)
	{
		if(m>0 && index>= nums.length)
		{
			return Integer.MAX_VALUE;
		}
		
		int result = 0;
		while(index<nums.length)
		{
			result+=nums[index];
			index++;
		}
		return result;
	}
	
	if(dp[index][m] != null)
		return dp[index][m];
	
	int result = Integer.MAX_VALUE;
	int res =0;
	for(int i = index;i<nums.length;i++)
	{
		res+= nums[i];
        
        int res2 = minSplitArray(nums,m-1, i+1, dp);
      
		result = Math.min(result, Math.max(res,res2));
	}
	
	return dp[index][m] = result;
}

}