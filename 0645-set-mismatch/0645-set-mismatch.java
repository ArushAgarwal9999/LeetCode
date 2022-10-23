class Solution {
   public int[] findErrorNums(int[] nums) {
    int[] result = new int[2];
    HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
    for(int i = 0;i<nums.length;i++)
    {
    	map.put(nums[i], map.getOrDefault(nums[i], 0)+1);
    	if(map.get(nums[i])>1)
    		result[0] = nums[i];
    		
    }
    for(int i = 1;i<=nums.length;i++)
    {
    	if(!map.containsKey(i))
    	{
    		result[1] = i;
    		break;
    	}
    }
    return result;
}
}