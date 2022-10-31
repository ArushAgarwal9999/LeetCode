class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] result = new int[nums1.length];
        int[] rightMax = new int[nums2.length];
        Stack<Integer> stack = new Stack<Integer>();
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int i =nums2.length-1;i>=0;i--)
        {
        	map.put(nums2[i], i);
        	while(!stack.isEmpty() && stack.peek()<nums2[i])
        		stack.pop();
        	if(stack.isEmpty())
        	{
        		rightMax[i] = -1;
        		stack.push(nums2[i]);
        	}
        	else {
        		rightMax[i] = stack.peek();
        		stack.push(nums2[i]);
        	}
        	
        	
        }
        //System.out.println("rightMax -->>"+Arrays.toString(rightMax));
        for(int i = 0;i<nums1.length;i++)
        {
        	result[i] = rightMax[map.get(nums1[i])];
        }
       
        return result;
    }
}