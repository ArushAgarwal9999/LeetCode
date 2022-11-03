class Solution {
   public double largestSumOfAverages(int[] nums, int k) {
    return getLargestSumOfAverages(nums, k, 0, new Double[nums.length][k+1]);
}
public double getLargestSumOfAverages(int[] nums, int k, int index, Double[][] dp)
{
	if(index>= nums.length || k==1)
	{
		int count =0;
		double res = 0;
		while(index<nums.length)
		{
			res+=nums[index];
			index++;
			count++;
		}
		if(res == 0)
			return res;
		return res/count;
		
	}
	if(dp[index][k] != null)
		return dp[index][k];
	
	double result = 0;
	int count = 0;
	double res = 0;
	for(int i = index;i<nums.length;i++)
	{
		count++;
		res +=nums[i];
		double res1 = getLargestSumOfAverages(nums, k-1, i+1, dp);
        //System.out.println("res1 -->>"+res1);
       // System.out.println("res -->>"+res);
		result = Math.max(result, ((res/count)+res1));
        // System.out.println("result -->>"+result);
		
		
	}
	return dp[index][k]= result;
	
}
}