class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
       HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        long currentSum = 0;
        long result = 0;
        for(int i = 0;i<k;i++)
        {
        	map.put(nums[i], map.getOrDefault(nums[i],0)+1);
        	currentSum+=nums[i];
        }
        //System.out.println("quee -->>"+map);
        if(map.size()==k)
        {
        	result = Math.max(currentSum, result);
        }
        for(int i = k;i<nums.length;i++)
        {
        	int removeNum = nums[i-k];
        	if(map.get(removeNum) == 1)
        		map.remove(removeNum);
        	else {
        		map.put(removeNum, map.get(removeNum)-1);
        	}
        	currentSum-=removeNum;
        	map.put(nums[i], map.getOrDefault(nums[i], 0)+1);
        	currentSum+=nums[i];
        	if(map.size()==k)
            {
            	result = Math.max(currentSum, result);
            }
        	  //System.out.println("quee -->>"+map);
        	
        	
        }
        return result;
        
    }
	
}