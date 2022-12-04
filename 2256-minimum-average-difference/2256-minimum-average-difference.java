class Solution {
  public int minimumAverageDifference(int[] nums) {
        long result = Integer.MAX_VALUE;
        int resultIndex = 0;
        long totalSum = 0;
        long currentSum = 0;
        for(int a:nums)
        	totalSum+=a;
        long count = 1;
        for(int i = 0;i<nums.length;i++)
        {
        	currentSum+=nums[i];
        	long remainCount = nums.length-count;
        	long res;
        	if(remainCount>0)
        	{ 
        		res= Math.abs((currentSum/(count))-((totalSum-currentSum)/(remainCount)));
        		
        	}
        	else {
        		res = Math.abs((currentSum/(count)));
        	}
        	
        	if(result>res)
        	{
        		result=res;
        		resultIndex = i;
        	}
        	count++;
        }
        
        
        return resultIndex;
    }
}