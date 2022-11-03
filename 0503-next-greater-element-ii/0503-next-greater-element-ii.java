class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int[] result = new int[nums.length];
        Stack<Integer> stack = new Stack<Integer>();
        for(int i =nums.length*2-1;i>=0;i--)
        {
        	while(!stack.isEmpty() && stack.peek()<=nums[i%nums.length])
        		stack.pop();
        	
        	if(i<nums.length)
        	{
        		if(stack.isEmpty())
        			result[i] = -1;
        		else
        			result[i] = stack.peek();
        	}
        	stack.push(nums[i%nums.length]);
        		
        }
        
        
        return result;
    }
}