class Solution {
   public int nearestExit(char[][] maze, int[] entrance) {
	       int res= dfs(entrance[0], entrance[1], maze, entrance,0, new Integer[maze.length][maze[0].length][5],new Boolean[maze.length][maze[0].length]);
	       if(res>=10000)
	    	   return -1;
	       return res;
	    }
	public int dfs(int row, int column, char[][] maze, int[] entrance, int position, Integer[][][] dp,Boolean[][] visited)
	{
		if(row<0|| row>=maze.length||column<0|| column>=maze[0].length || maze[row][column]=='+'||visited[row][column]!= null)
			return 10000;
		if((row==0|| column==0 || row==maze.length-1|| column==maze[0].length-1)&& (row!= entrance[0]||  column!= entrance[1]) &&  maze[row][column]=='.' )
		{
			return 0;
		}
		if(dp[row][column][position]!= null)
			return dp[row][column][position];
		int res = 10000;
		visited[row][column]  =true;
		res = Math.min(res, dfs(row-1, column, maze, entrance,0, dp,visited)+1);
		res = Math.min(res, dfs(row+1, column, maze, entrance,1, dp,visited)+1);
		res = Math.min(res, dfs(row, column-1, maze, entrance,2, dp,visited)+1);
		res = Math.min(res, dfs(row, column+1, maze, entrance,3, dp,visited)+1);
		visited[row][column]  =null;
		return dp[row][column][position]= res;
		
	}

}