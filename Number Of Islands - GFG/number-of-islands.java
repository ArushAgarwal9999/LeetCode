//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;


// } Driver Code Ends
//User function Template for Java

class Solution {
    
    class Disjoint{
		ArrayList<Integer>  rank = new ArrayList<Integer>();
		ArrayList<Integer> parent = new ArrayList<Integer>();
		int[][] matrix;
		int currentNumberOfIslend = 0;
		public Disjoint(int n,int rows, int colums)
		{
			matrix = new int[rows][colums];
			for(int i = 0;i<n;i++)
			{
				rank.add(0);
				parent.add(i);
			}
		}
		public int findParent(int node)
		{
			if(node==parent.get(node))
				return node;
			int num = findParent(parent.get(node));
			parent.set(node, num);
			return parent.get(node);
		}
		public void union(int u, int v)
		{
			int parentU = findParent(u);
			int parentV = findParent(v);
			if(parentU==parentV)
				return;
			if(rank.get(parentU)>rank.get(parentV))
			{
				parent.set(parentV, parentU);
			}
			else if(rank.get(parentU)==rank.get(parentV))
			{
				parent.set(parentV, parentU);
				rank.set(parentU, rank.get(parentU)+1);
			}
			else {
				parent.set(parentU, parentV);
			}
		}
		public int getNumberOfIsland(int row, int column)
		{
			if(matrix[row][column]==1)
				return currentNumberOfIslend;
			return currentNumberOfIslend= currentNumberOfIslend+1-getNumberofConectedIsland(row, column);
			
		}
		public int getNumberofConectedIsland(int row, int column)
		{
			matrix[row][column]=1;
			int result = 0;
			int[] rowTraversal = {-1,1,0,0};
			int[] colTraversal = {0,0,-1,1};
			for(int i = 0;i<rowTraversal.length;i++)
			{
				int nrow = row+rowTraversal[i];
				int nCol = column+colTraversal[i];
				if(nrow>=0&& nrow<matrix.length && nCol>=0 && nCol<matrix[0].length)
				{
					if(matrix[nrow][nCol]==1)
					{
						int parentN = findParent((nrow*matrix[0].length)+nCol);
						int parentO = findParent(row*matrix[0].length+column);
						if(parentN!=parentO)
						{
							result++;
							union(parentN, parentO);
						}
					}
				}
			}
			
			return result;
		}
	}
	public List<Integer> numOfIslands(int rows, int cols, int[][] operators) {
        Disjoint set  = new Disjoint(rows*cols, rows, cols);
        List<Integer> result = new ArrayList<Integer>();
        for(int []num:operators)
        {
        	result.add(set.getNumberOfIsland(num[0], num[1]));
        }
        return result;
    }
    
}

//{ Driver Code Starts.

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int  k= sc.nextInt();
            int[][] a = new int[k][2];
            for(int i=0;i<k;i++){
            
                a[i][0] = sc.nextInt();
                a[i][1] = sc.nextInt();
            }
            
            Solution obj = new Solution();
            List<Integer> ans = obj.numOfIslands(n,m,a);
           
            for(int i:ans){
                System.out.print(i+" ");
            }
            System.out.println();
        }
    }
}

// } Driver Code Ends