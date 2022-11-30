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
            int[] source = new int[2];
            for (int i = 0; i < 2; i++) {
                int x = sc.nextInt();
                source[i] = x;
            }
            int[] dest = new int[2];
            for (int i = 0; i < 2; i++) {
                int x = sc.nextInt();
                dest[i] = x;
            }
            Solution ob = new Solution();
            int ans = ob.shortestPath(grid, source, dest);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {

     class Pair{
		int row;
		int column;
		int distance;
		public Pair(int row, int column, int distance) {
			super();
			this.row = row;
			this.column = column;
			this.distance = distance;
		}
		
		
		
	}
	
	int shortestPath(int[][] grid, int[] source, int[] destination) {
		Boolean[][] visited = new Boolean[grid.length][grid[0].length];
		Queue<Pair> quee = new PriorityQueue<Pair>((a,b)->a.distance-b.distance);
		if(grid[source[0]][source[1]]!= 1 || grid[destination[0]][destination[1]] != 1)
			return -1;
		visited[source[0]][source[1]]=true;
		quee.add(new Pair(source[0], source[1], 0));
		while(!quee.isEmpty())
		{
			Pair p = quee.poll();
			if(p.row ==destination[0]&& p.column ==destination[1])
				return p.distance;
			int[]row = {-1,1,0,0};
			int[] column = {0,0,-1,1};
			for(int i = 0;i<row.length;i++)
			{
				int newRow = p.row+row[i];
				int newColumn = p.column+column[i];
				if( newRow>=0 && newRow<grid.length&& newColumn>=0 && newColumn<grid[0].length&&  visited[newRow][newColumn]==null && grid[newRow][newColumn]==1 )
				{
					visited[newRow][newColumn]  = true;
					quee.add(new Pair(newRow, newColumn, p.distance+1));
				}
				
			}
			
			
		}
		
		
		
		
		return -1;

        // Your code here
    }
}
