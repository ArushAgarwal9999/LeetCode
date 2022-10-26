class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
	int sum = 0;
	int remainder = 0;
	HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
	map.put(0, -1);
    for(int i = 0;i<nums.length;i++)
    {
    	sum+=nums[i];
    	remainder = sum%k;
         System.out.println("sum -->>"+sum);
        System.out.println("remainder -->>"+remainder);
    	if(map.containsKey(remainder))
    	{
    		if(i-map.get(remainder)>=2)
    			return true;
    	}
        else{
            map.put(remainder, i);
        }
    	
    	
    }
	
	
	return false;
}
}