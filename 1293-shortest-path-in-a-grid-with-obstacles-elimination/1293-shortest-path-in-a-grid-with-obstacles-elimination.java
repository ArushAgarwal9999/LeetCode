class Solution {
public int shortestPath(int[][] grid, int k) {
    int res = getPath(0, 0, k,0, grid, new Boolean[grid.length][grid[0].length], new Integer[grid.length][grid[0].length][(grid.length*grid[0].length)+1][4]);
    
    if(res>=100000)
    	return -1;
    return res;
}
public int getPath(int i, int j, int k,int dirc,int[][] grid, Boolean[][] visit,Integer[][][][]dp )
{
	if(i<0 || i>=grid.length || j<0||j>=grid[0].length || grid[i][j] == 1 && k <= 0 || visit[i][j] != null)
		return 100000;
	if(i== grid.length-1 && j == grid[0].length-1)
		return 0;
	
	if(dp[i][j][k][dirc] != null)
		return dp[i][j][k][dirc];
	int result = Integer.MAX_VALUE;
	int minus = 0;
	if(grid[i][j] == 1)
	{
		minus = 1;
	}
	visit[i][j] = true;
	result = Math.min(getPath(i+1, j, k-minus,0, grid, visit, dp)+1, result);
	result = Math.min(getPath(i-1, j, k-minus,1, grid, visit, dp)+1, result);
	result = Math.min(getPath(i, j+1, k-minus,2, grid, visit, dp)+1, result);
	result = Math.min(getPath(i, j-1, k-minus,3, grid, visit, dp)+1, result);
	visit[i][j] = null;
	
	return dp[i][j][k][dirc] = result;
}
}