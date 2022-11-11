//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String[] s = br.readLine().trim().split(" ");
            int n = Integer.parseInt(s[0]);
            int m = Integer.parseInt(s[1]);
            int[][] grid = new int[n][m];
            for(int i = 0; i < n; i++){
                String[] S = br.readLine().trim().split(" ");
                for(int j = 0; j < m; j++){
                    grid[i][j] = Integer.parseInt(S[j]);
                }
            }
            Solution obj = new Solution();
            int[][] ans = obj.nearest(grid);
            for(int i = 0; i < ans.length; i++){
                for(int j = 0; j < ans[i].length; j++){
                    System.out.print(ans[i][j] + " ");
                }
                System.out.println();
            }
        }
    }
}
// } Driver Code Ends


class Solution
{
    //Function to find distance of nearest 1 in the grid for each cell.
    public int[][] nearest(int[][] mat)
    {
        int[][] result = new int[mat.length][mat[0].length];
		   Queue<int[]> quee = new LinkedList<int[]>();
		   for(int i = 0;i<mat.length;i++)
		   {
			   for(int j = 0;j<mat[i].length;j++)
			   {
				   if(mat[i][j]==1)
				   {
					   result[i][j]=0;
					   quee.add(new int[] {i,j,0});
				   }
				   else
					   result[i][j]=Integer.MAX_VALUE;
			   }
		   }
		   while(!quee.isEmpty())
		   {
			   int size = quee.size();
			   while(size>0)
			   {
                   size--;
				   int[] arr = quee.poll();
				   int[] rowMove = {-1,1,0,0};
				   int[] columnMove = {0,0,-1,1};
				   for(int i = 0;i<rowMove.length;i++)
				   {
					   int row = arr[0]+rowMove[i];
					   int column= arr[1]+columnMove[i];
					   if(row>=0 && row<mat.length && column>=0 && column<mat[0].length)
					   {
						   if(result[row][column]>(arr[2]+1))
						   {
                               result[row][column] = arr[2]+1;
							   quee.add(new int[]{row,column,result[row][column]});
						   }
					   }
				   }
			   }
		   }
		   
		   
		   return result;
        // Code here
    }
}