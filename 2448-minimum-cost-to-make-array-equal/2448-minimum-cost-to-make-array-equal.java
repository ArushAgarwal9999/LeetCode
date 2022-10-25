class Solution {
    public long minCost(int[] nums, int[] cost) {
    long result = 0;
    long max = 0;
    long min = Long.MAX_VALUE;
    for(int i = 0;i<nums.length;i++)
    {
    	max = Math.max(max, nums[i]);
    	min = Math.min(min, nums[i]);
    }
    result = getRes(nums, cost, max);
    while(min<max)
    {
    	long mid = (min+max)/2;
    	long res = getRes(nums, cost, mid);
        long res1 = getRes(nums, cost, mid+1);
    	if(res<res1)
    	{
    		max = mid;
    	}
    	else
    		min = mid+1;
    	
    	result = Math.min(result, Math.min(res,res1));
    	
    	
    }
    
    return result;
}
public long getRes(int[] nums, int[] cost, long x)
{
	long res = 0;
	for(int i = 0 ;i<nums.length;i++)
	{
		res+=(Math.abs(nums[i]-x)*cost[i]);
	}
	return res;
}
}