class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
	HashMap<Integer, ArrayList<Integer>>map = new HashMap<Integer, ArrayList<Integer>>();
	for(int i = 0;i<nums.length;i++)
	{
		if(!map.containsKey(nums[i]))
			map.put(nums[i], new ArrayList<Integer>());
		
		map.get(nums[i]).add(i);
	}
	for(Map.Entry<Integer, ArrayList<Integer>>entry:map.entrySet())
	{
		ArrayList<Integer> arr = entry.getValue();
		for(int i = 0;i<arr.size()-1;i++)
		{
			if(Math.abs(arr.get(i)-arr.get(i+1))<=k)
				return true;
		}
	}
    return false;
}
}