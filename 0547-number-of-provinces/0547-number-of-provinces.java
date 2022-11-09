class Solution {
    public int findCircleNum(int[][] isConnected) {
    int result = 0;
    boolean[] visited = new boolean[isConnected.length];
    ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>();
    for(int i = 0;i<isConnected.length;i++)
    {
    	adj.add(new ArrayList<Integer>());
    }
    for(int i = 0;i<isConnected.length;i++)
    {
    	for(int j = 0;j<isConnected[i].length;j++)
    	{
    		if(isConnected[i][j]==1)
    		{
    			adj.get(i).add(j);
    		}
    	}
    }
    for(int i = 0;i<isConnected.length;i++)
    {
    	if(!visited[i])
    	{
    		result++;
            dfs(i,adj,visited);
    	}
    }
    return result;
    
}
public void dfs(int num , ArrayList<ArrayList<Integer>> adj, boolean[] visited)
{
	
	if(visited[num])
		return;
	visited[num] = true;
	for(int a:adj.get(num))
	{
		if(!visited[a])
		{
			dfs(a, adj, visited);
		}
	}
	
}
}