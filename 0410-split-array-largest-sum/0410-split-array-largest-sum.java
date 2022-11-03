class Solution {
    public int splitArray(int[] nums, int m) {
		long res = minSplitArray(nums, m, 0, new Long[nums.length][m+1]);
		return (int ) res;
        
    }
public long minSplitArray(int[] nums, int m, int index, Long[][] dp)
{
	if(index >= nums.length || m ==1)
	{
		if(m>0 && index>= nums.length)
		{
			return 100000000l;
		}
		
		long result = 0;
		while(index<nums.length)
		{
			result+=nums[index];
			index++;
		}
		return result;
	}
	
	if(dp[index][m] != null)
		return dp[index][m];
	
	long result = Long.MAX_VALUE;
	long res =0;
	for(int i = index;i<nums.length;i++)
	{
		res+= nums[i];
        
        long res2 = minSplitArray(nums,m-1, i+1, dp);
       // System.out.println("nums[i] -->>"+nums[i]);
       // System.out.println("res -->>"+res);
       // System.out.println("res2 -->>"+res2);
		result = Math.min(result, Math.max(res,res2));
        // System.out.println("result -->>"+result);
	}
	
	return dp[index][m] = result;
}

}