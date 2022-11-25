class Solution {
    public int sumSubarrayMins(int[] arr) {
         int mod = 1000000007;
        long result = 0;
        long[] left = new long[arr.length];
        long[] right = new long[arr.length];
        Stack<Integer> stack = new Stack<Integer>();
        for(int i = 0;i<arr.length;i++)
        {
        	int count = 1;
        	while(!stack.isEmpty()&& arr[stack.peek()]>arr[i])
        	{
        		count+=left[stack.peek()];
        		stack.pop();
        	}
        	left[i] = count%mod;
        	stack.push(i);
        }
        stack.clear();
        for(int i = arr.length-1;i>=0;i--)
        {
        	int count = 1;
        	while(!stack.isEmpty()&& arr[stack.peek()]>=arr[i])
        	{
        		count+=right[stack.peek()];
        		stack.pop();
        	}
        	right[i] = count%mod;
        	stack.push(i);
        }
       
        for(int i = 0;i<arr.length;i++)
        {
        	result+=((((left[i]*right[i])%mod)*arr[i])%mod);
        	result%=mod;
        }
        return (int)(result%mod);
    }

}