class Solution {
    public int[][] updateMatrix(int[][] mat) {
		   int[][] result = new int[mat.length][mat[0].length];
		   Queue<int[]> quee = new LinkedList<int[]>();
		   for(int i = 0;i<mat.length;i++)
		   {
			   for(int j = 0;j<mat[i].length;j++)
			   {
				   if(mat[i][j]==0)
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
    }
}
