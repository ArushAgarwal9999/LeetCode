class Solution {
    public int jump(int[] nums) {
        if(nums.length==1)
            return 0;
        int jump = 0;
        int max = 0;
        int current = 0;
        for(int i =0;i<nums.length;i++)
        {
        	max= Math.max(max, i+nums[i]);
        	if(max>=nums.length-1)
        		return ++jump;
        	
        	if(current==i)
        	{
        		current=max;
        		jump++;
        	}
        }
        
        return jump;
    }
}