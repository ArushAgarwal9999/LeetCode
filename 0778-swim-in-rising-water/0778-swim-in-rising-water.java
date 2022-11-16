class Solution {
   public int swimInWater(int[][] grid) {
	return getMin(0, 0,0, grid,new Integer[grid.length][grid[0].length][2501], new Boolean[grid.length][grid[0].length]);
}

public int  getMin(int index1, int index2,int maxValue, int[][] grid, Integer[][][] dp, Boolean[][] visited)
{
	if(index1<0||index1>=grid.length|| index2<0|| index2>=grid[0].length|| visited[index1][index2] != null)
	{
		return Integer.MAX_VALUE;
	}
	if(index1==grid.length-1 && index2==grid[0].length-1)
	{
		return Math.max(maxValue, grid[index1][index2]);
	}
	if(dp[index1][index2][maxValue] != null)
		return dp[index1][index2][maxValue];
	visited[index1][index2] = true;
	maxValue =Math.max(maxValue, grid[index1][index2]);
	int result = Integer.MAX_VALUE;
	result = Math.min(result, getMin(index1-1, index2, maxValue,grid,dp, visited));
	result = Math.min(result, getMin(index1+1, index2,maxValue, grid, dp,visited));
	result = Math.min(result, getMin(index1, index2-1, maxValue,grid,dp ,visited));
	result = Math.min(result, getMin(index1, index2+1, maxValue,grid, dp,visited));
	visited[index1][index2]=null;
	return dp[index1][index2][maxValue]= result;
}
}