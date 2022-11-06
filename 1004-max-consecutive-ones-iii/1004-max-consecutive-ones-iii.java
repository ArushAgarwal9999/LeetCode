class Solution {
    public int longestOnes(int[] nums, int k) {
        int i = 0;
        int currentNum = 0;
        int j = 0;
        int maxResult  = 0;
        while(i<nums.length)
        {
        	if(currentNum >= k && nums[i] == 0)
        	{
        		if(nums[j] ==0)
        			currentNum--;
        		j++;
        	}
        	else {
        		if(nums[i] == 0)
        			currentNum++;
        		
        		maxResult = Math.max(maxResult, (i-j)+1);
        		i++;
        	}
        	
        }
        return maxResult;
    }
}