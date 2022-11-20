class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
	List<Integer> result = new ArrayList<Integer>();
	ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>();
	//HashSet<Integer> set = new HashSet<Integer>();
	for(int i = 0;i<graph.length;i++)
	{
		adj.add(new ArrayList<Integer>());
		for(int j = 0;j<graph[i].length;j++)
		{
			adj.get(i).add(graph[i][j]);
		}
	}
	boolean[] visited = new boolean[graph.length];
    Boolean[] dp = new Boolean[graph.length];
	for(int i = 0;i<graph.length;i++)
	{
		visited[i ] =true;
		if(!dfs(i, adj, visited,dp))
			result.add(i);
		
		visited[i]= false;
		
	}
	
	return result;
    }
public boolean dfs(int node,ArrayList<ArrayList<Integer>> adj, boolean[] visited,Boolean[] dp )
{
    if(dp[node] != null)
        return dp[node];
	for(int a:adj.get(node))
	{
		if(visited[a])
			return dp[a]= true;
		visited[a] = true;
		if(dfs(a,adj,visited,dp))
			return dp[node]= true;
		visited[a] = false;
		
	}
	return dp[node]= false;
}
	
}