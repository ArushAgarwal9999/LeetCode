class Solution {
    public int longestIncreasingPath(int[][] matrix) {
	        int result = 0;
	        Integer[][] dp = new Integer[matrix.length][matrix[0].length];
	        for(int  i = 0;i<matrix.length;i++)
	        {
	        	for(int j = 0;j<matrix[0].length;j++)
	        	{
	        		dfs(i, j, -1, matrix, dp);
	        		result = Math.max(result, dp[i][j]);
	        	}
	        }
	        return result;
	    }
	 public int dfs(int row, int column, int prev,int[][] matrix, Integer[][] dp)
	 {
		 if(row<0|| column<0 || row>=matrix.length|| column>=matrix[0].length|| matrix[row][column]<=prev)
		 {
			 return 0;
		 }
		 
		 if(dp[row][column] != null)
			 return dp[row][column];
		 //System.out.println("row -->>"+row);
         //System.out.println("column -->>"+column);
		 int max = 1;
		 max = Math.max(max, dfs(row-1, column, matrix[row][column], matrix, dp)+1);
		 max = Math.max(max, dfs(row+1, column, matrix[row][column], matrix, dp)+1);
		 max = Math.max(max, dfs(row, column-1, matrix[row][column], matrix, dp)+1);
		 max = Math.max(max, dfs(row, column+1, matrix[row][column], matrix, dp)+1);
		 return dp[row][column]= max;
		 
	 }
}