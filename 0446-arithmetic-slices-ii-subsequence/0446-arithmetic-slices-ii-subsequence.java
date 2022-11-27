class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        int result = 0;
        Integer[] in = new Integer[nums.length];
        HashMap<Integer,Integer>[] map = new HashMap[nums.length];
        for(int i = 0;i<nums.length;i++)
        {
        	map[i] = new HashMap<Integer, Integer>();
        }
        for(int i = 1;i<nums.length;i++)
        {
            //System.out.println("i -->>"+i);
        	for(int j = 0;j<i;j++)
        	{
        		long diff = (long)nums[i]- (long)nums[j];
                int diff1 = nums[i]- nums[j];
        		if(diff<=Integer.MIN_VALUE || diff>=Integer.MAX_VALUE)
        			continue;
        		int prev = map[j].getOrDefault(diff1, 0);
                //System.out.println("prev -->>"+prev);
        		result+=prev++;
        		map[i].put(diff1, map[i].getOrDefault(diff1, 0)+prev);
                //System.out.println("map[i] -->>"+map[i]);
        	}
            //System.out.println("---------->>");
            
        }
        
        return result;
    }
}