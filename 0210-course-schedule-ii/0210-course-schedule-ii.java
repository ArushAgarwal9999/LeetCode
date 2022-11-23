class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int [] indrgree = new int[numCourses];
        int[] result = new int[numCourses];
        Stack<Integer> res = new Stack<Integer>();
        ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>();
        for(int i = 0;i<numCourses;i++)
        {
        	adj.add(new ArrayList<Integer>());
        }
        Queue<Integer> quee = new LinkedList<Integer>();
        for(int [] a:prerequisites)
        {
        	adj.get(a[1]).add(a[0]);
        	indrgree[a[0]]++;
        }
        for(int i = 0;i<indrgree.length;i++)
        {
        	if(indrgree[i]==0)
        	{
        		quee.add(i);
        	}
        }
        while(!quee.isEmpty())
        {
        	int a=quee.poll();
        	res.add(a);
        	for(int num:adj.get(a))
        	{
        		indrgree[num]--;
        		if(indrgree[num]==0)
        		{
        			quee.add(num);
        		}
        	}
        }
        int index = numCourses-1;
        for(int a:indrgree)
        	if(a!=0)
        		return new int[] {};
        
        while(!res.isEmpty())
        {
        	result[index--] = res.pop();
        }
        return result;
    }
}