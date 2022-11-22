class Solution {
    public int minFlips(int[][] mat) {
        int result = 0;
        Queue<int[][]> quee = new LinkedList<int[][]>();
        HashSet<String> visited = new HashSet<String>();
        quee.add(mat);
        visited.add(getString(mat));
        while(!quee.isEmpty())
        {
        	int size = quee.size();
        	while(size>0)
        	{
                size--;
        		int[][] matrix = quee.poll();
                //System.out.println("marix -->>"+getString(matrix));
        		if(getSum(matrix)==0)
                {
                    
                    return result;
                }
        			
        		for(int i = 0;i<matrix.length;i++)
        		{
        			for(int j = 0;j<matrix[i].length;j++)
        			{
        				int[][] flip  = flipMatrix(matrix, i, j);
        				String res = getString(flip);
        				if(!visited.contains(res))
        				{
        					quee.add(flip);
        					visited.add(res);
        				}
        			}
        		}
        	}
        	result++;
        }
        
        return -1;
    }
public int getSum(int[][] matrix)
{
	int result = 0;
	for(int i = 0;i<matrix.length;i++)
	{
		for(int j = 0;j<matrix[i].length;j++)
		{
			result+=matrix[i][j];
		}
	}
	return result;
}
public int[][] flipMatrix(int [][] matrix, int row, int column)
{
	int[][] result = clone(matrix);
	int[] rowTrav =   {-1,1,0,0};
	int[] columnTrav ={0,0,-1,1};
	if(result[row][column] ==1)
		result[row][column] = 0;
	else {
		result[row][column] = 1;
	}
	for(int i = 0;i<rowTrav.length;i++)
	{
		int newRow = row+rowTrav[i];
		int newColumn = column+columnTrav[i];
		if(newRow>=0 && newRow<matrix.length&& newColumn>=0 && newColumn<matrix[0].length)
		{
			if(result[newRow][newColumn]==1)
				result[newRow][newColumn] = 0;
			else
				result[newRow][newColumn] = 1;
		}
		
		
		
	}
	
	
	return result;
}
public String getString(int[][] matrix)
{
	StringBuffer result = new StringBuffer();
	for(int i = 0;i<matrix.length;i++)
	{
		for(int j = 0;j<matrix[i].length;j++ )
		{
			result.append(matrix[i][j]);
			result.append("-");
		}
	}
	return result.toString();
}
public int[][] clone(int[][] matrix)
{
	int[][] result = new int[matrix.length][matrix[0].length];
	for(int i = 0;i<result.length;i++)
	{
		for(int j = 0;j<result[i].length;j++)
		{
			result[i][j] = matrix[i][j];
		}
	}
	return result;
}
}