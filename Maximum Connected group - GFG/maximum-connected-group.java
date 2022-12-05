//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int[][] grid = new int[n][n];
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    grid[i][j]=sc.nextInt();
                }
            }
            
            Solution obj = new Solution();
            int ans = obj.MaxConnection(grid);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


class Solution {
    
    class DisJoint{
			ArrayList<Integer> rank = new ArrayList<Integer>();
			ArrayList<Integer> parent = new ArrayList<Integer>();
			HashMap<Integer,Integer> map = new HashMap<Integer, Integer>();
			int[][] grid ;
			public DisJoint(int row, int column)
			{
				grid = new int[row][column];
				for(int i = 0;i<row*column;i++)
				{
					parent.add(i);
					rank.add(0);
				}
			}
			public int getParent(int node)
			{
				if(node == parent.get(node))
					return node;
				int num = getParent(parent.get(node));
				parent.set(node, num);
				return parent.get(node);
			}
			public void union(int u, int v)
			{
				int parentU  = getParent(u);
				int parentV  = getParent(v);
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
			public void initializeGrid(int row, int column)
			{
				grid[row][column] = 1;
				int[] rowArr = {-1,1,0,0};
				int[] columnArr = {0,0,-1,1};
				for(int i= 0;i<rowArr.length;i++)
				{
					int nRow = row+rowArr[i];
					int nColumn = column+columnArr[i];
					if(nColumn>=0&& nColumn<grid[0].length && nRow>=0&& nRow<grid.length)
					{
						if(grid[nRow][nColumn]==1)
						{
							union(nRow*grid[0].length+nColumn, row*grid[0].length+column );
						}
					}
				}
			}
			public int initializeMapAndGetInitialMaxArea()
			{
				int max = 0;
				for(int i = 0;i<parent.size();i++)
				{
					int parent = getParent(i);
					map.put(parent, map.getOrDefault(parent, 0)+1);
					max = Math.max(max, map.get(parent));
				}
				return max;
			}
			public int getMaxArea(int row, int column)
			{
				int result = 1;
				int[] rowArr = {-1,1,0,0};
				int[] columnArr = {0,0,-1,1};
				HashSet<Integer> parentList = new HashSet<Integer>();
				for(int i = 0;i<rowArr.length;i++)
				{
					int nRow = row+rowArr[i];
					int nColumn = column+columnArr[i];
					if(nColumn>=0&& nColumn<grid[0].length && nRow>=0&& nRow<grid.length && grid[nRow][nColumn]==1)
					{
						parentList.add(getParent(nRow*grid[0].length+nColumn));
					}
				}
				for(int a:parentList)
				{
					result+=map.get(a);
				}
				
				return result;
				
				
			}
			
		}
		 public int MaxConnection(int[][] grid) {
			 int result = 0;
			 DisJoint set = new DisJoint(grid.length, grid[0].length);
			 for(int i = 0;i<grid.length;i++)
			 {
				 for(int j = 0;j<grid[0].length;j++)
				 {
					 if(grid[i][j]==1)
					 {
						 set.initializeGrid(i, j);
					 }
				 }
			 }
			 result = set.initializeMapAndGetInitialMaxArea();
			 for(int i = 0;i<grid.length;i++)
			 {
				 for(int j = 0;j<grid[0].length;j++)
				 {
					 if(grid[i][j]==0)
					 {
						 result = Math.max(result, set.getMaxArea(i, j));
					 }
				 }
			 }
			 return result;
		        
		    }
    
}