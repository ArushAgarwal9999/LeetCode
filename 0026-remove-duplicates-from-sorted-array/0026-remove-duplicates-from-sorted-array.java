class Solution {
    public int removeDuplicates(int[] nums) {
        int result = 0;
        int index = 0;
        while(index<nums.length)
        {
        	while(index<nums.length && nums[index] == nums[result])
        	{
        		index++;
        	}
        	if(index<nums.length)
        	{
        		nums[++result] = nums[index];
        	}
        }
        return result+1;
    }
}