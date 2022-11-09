class Solution {
    public int numIslands(char[][] grid) {
	int result =0;
    for(int i = 0;i<grid.length;i++)
    {
    	for(int j = 0;j<grid[i].length;j++)
    	{
    		if(grid[i][j]=='1')
    		{
    			result++;
    			dfs(i, j, grid, new Boolean[grid.length][grid[0].length]);
    		}
    	}
    }
    return result;
}
public void  dfs(int i, int j,char[][] grid, Boolean[][] visited)
{
	if(i<0|| i>=grid.length|| j<0|| j>=grid[0].length||grid[i][j] =='0' || visited[i][j] != null)
		return ;
	grid[i][j]=0;
	visited[i][j] = true;
	dfs(i+1, j, grid,visited);
	dfs(i-1, j, grid,visited);
	dfs(i, j+1, grid,visited);
	dfs(i, j-1, grid,visited);
	//visited[i][j] = null;
}
}