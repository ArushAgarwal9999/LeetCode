class Solution {
    public int countSubarrays(int[] nums, int k) {
     int result = 0;
     boolean isFound =false;
     HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
     int sum = 0;
        map.put(0,1);
     for(int i = 0;i<nums.length;i++)
     {
    	 if(nums[i]<k)
    		 --sum;
    	 else if(nums[i]>k)
    		 ++sum;
    	 else
    		 isFound=true;
    	 if(isFound)
    	 {
    		 result+=(map.getOrDefault(sum, 0)+map.getOrDefault(sum-1, 0));
    	 }
    	 else {
    		 map.put(sum, map.getOrDefault(sum, 0)+1);
    	 }
     }
     
     return result;
    }
}