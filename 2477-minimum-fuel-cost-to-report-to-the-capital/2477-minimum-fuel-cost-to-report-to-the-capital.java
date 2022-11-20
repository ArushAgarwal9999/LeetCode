class Solution {
    long result = 0;
	
public long minimumFuelCost(int[][] roads, int seats) {
       ArrayList<ArrayList<Integer>> adj  = new ArrayList<ArrayList<Integer>>();
       for(int i = 0;i<=roads.length;i++)
       {
    	   adj.add(new ArrayList<Integer>());
       }
       for(int i = 0;i<roads.length;i++)
       {
    	   adj.get(roads[i][0]).add(roads[i][1]);
    	   adj.get(roads[i][1]).add(roads[i][0]);
       }
       dfs(0,0,seats,adj);
	
	return result;
    }
public int  dfs(int currentNode,int prev,int seats,ArrayList<ArrayList<Integer>> adj )
{
	int people = 0;
	for(int a:adj.get(currentNode))
	{
		if(a==prev)
			continue;
		people+=dfs(a, currentNode, seats,adj);
	}
	people++;
	int res=(people%seats==0)?people/seats:people/seats+1;
    if(currentNode != 0)
        result+=res;
	return people;
	
}
}