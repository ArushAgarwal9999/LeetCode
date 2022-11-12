//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

// Position this line where user code will be pasted.

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int[][] grid = new int[n][m];

            for (int i = 0; i < n; i++) {

                for (int j = 0; j < m; j++) {
                    grid[i][j] = sc.nextInt();
                }
            }

            Solution ob = new Solution();
            int ans = ob.countDistinctIslands(grid);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {

    int countDistinctIslands(int[][] grid) {
        // Your Code here
		HashSet<ArrayList<ArrayList<Integer>>> result = new HashSet<ArrayList<ArrayList<Integer>>>();
		boolean[][] visit = new boolean[grid.length][grid[0].length];
		for(int i = 0;i<grid.length;i++)
		{
			for(int j = 0;j<grid[i].length;j++)
			{
				if(visit[i][j]==false && grid[i][j]==1)
				{
					ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
					dfs(i, j, i, j, res, visit, grid);
					//System.out.println("res -->>"+res);
					result.add(res);
				}
			}
		}
		return result.size();
    }
	public void dfs(int i , int j, int baseI, int baseJ, ArrayList<ArrayList<Integer>>result,boolean[][] visit,int[][] grid)
	{
		if(i>=0&& i<grid.length&& j>=0 && j<grid[0].length&& grid[i][j]==1 && visit[i][j]==false)
		{
			visit[i][j] =true;
			ArrayList<Integer>res = new ArrayList<Integer>();
			res.add(i-baseI);
			res.add(j-baseJ);
			
			result.add(res);
			dfs(i-1, j, baseI, baseJ, result, visit, grid);
			dfs(i+1, j, baseI, baseJ, result, visit, grid);
			dfs(i, j-1, baseI, baseJ, result, visit, grid);
			dfs(i, j+1, baseI, baseJ, result, visit, grid);
		}
		
	}
}
