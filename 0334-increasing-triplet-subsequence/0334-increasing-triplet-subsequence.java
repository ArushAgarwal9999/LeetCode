class Solution {
    public boolean increasingTriplet(int[] nums) {
        int[] prefixMin = new int[nums.length];
        int[] sufixMax = new int[nums.length];
        prefixMin[0] = nums[0];
        sufixMax[nums.length-1] =nums[nums.length-1];
        for(int i = 1;i<nums.length;i++)
        {
            prefixMin[i] = Math.min(prefixMin[i-1],nums[i]);
        }
        for(int i = nums.length-2;i>=0;i--)
        {
            sufixMax[i] = Math.max(sufixMax[i+1],nums[i]);
        }
        for(int i = 1;i<nums.length-1;i++)
        {
            if(nums[i]>prefixMin[i-1] && nums[i]<sufixMax[i+1])
                return true;
        }
        return false;
    }
}