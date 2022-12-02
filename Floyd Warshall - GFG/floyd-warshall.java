//{ Driver Code Starts
//Initial template for JAVA

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
            int n = Integer.parseInt(br.readLine().trim());
            int[][] matrix = new int[n][n];
            for(int i = 0; i < n; i++){
                String[] s = br.readLine().trim().split(" ");
                for(int j = 0; j < n; j++)
                    matrix[i][j]  =Integer.parseInt(s[j]);
            }
            Solution obj = new Solution();
            obj.shortest_distance(matrix);
            for(int i = 0; i < n; i++){
                for(int j  = 0; j < n; j++){
                    System.out.print(matrix[i][j] + " ");
                }
                System.out.println();
            }
        }
    }
}

// } Driver Code Ends


//User function template for JAVA

class Solution
{
   public void shortest_distance(int[][] matrix)
    {
		for(int i = 0;i<matrix.length;i++)
		{
			for(int j = 0;j<matrix[i].length;j++)
			{
				if(matrix[i][j]==-1)
					matrix[i][j] = 10001;
			}
			
		}
        for(int via =0;via<matrix.length;via++)
        {
        	for(int i = 0;i<matrix.length;i++)
        	{
        		for(int j = 0;j<matrix[i].length;j++)
        		{
        			if(matrix[i][via] ==-1 || matrix[via][j]==-1)
        				continue;
        			matrix[i][j] = Math.min(matrix[i][j], (matrix[i][via]+matrix[via][j]));
        		}
        	}
        }
        for(int i = 0;i<matrix.length;i++)
		{
			for(int j = 0;j<matrix[i].length;j++)
			{
				if(matrix[i][j]==10001)
					matrix[i][j] = -1;
			}
			
		}
    }
}