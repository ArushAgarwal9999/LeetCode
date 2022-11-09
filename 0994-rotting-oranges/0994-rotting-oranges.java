class Solution {
    public int orangesRotting(int[][] grid) {
    int result = 0;
    Queue<Pair> quee = new LinkedList<Pair>();
    for(int i = 0;i<grid.length;i++)
    {
    	for(int j = 0;j<grid[i].length;j++) {
    		if(grid[i][j]==2)
    		{
    			quee.add(new Pair(i,j));
    		}
    			
    	}
    }
    while(!quee.isEmpty())
    {
    	int size = quee.size();
    	
    	while(size>0)
    	{
    		size--;
    		Pair p =quee.poll();
    		if(p.row-1>=0 && grid[p.row-1][p.column]==1)
    		{
    			grid[p.row-1][p.column]= 2;
    			quee.add(new Pair(p.row-1, p.column));
    		}
    		if(p.row+1<grid.length && grid[p.row+1][p.column]==1)
    		{
    			grid[p.row+1][p.column]=2;
    			quee.add(new Pair(p.row+1, p.column));
    		}
    		if(p.column-1>=0 && grid[p.row][p.column-1]==1)
    		{
    			grid[p.row][p.column-1]= 2;
    			quee.add(new Pair(p.row, p.column-1));
    		}
    		if(p.column+1<grid[0].length && grid[p.row][p.column+1]==1)
    		{
    			grid[p.row][p.column+1]=2;
    			quee.add(new Pair(p.row, p.column+1));
    		}
    	}
        if(!quee.isEmpty())
            result++;
    }
    for(int i = 0;i<grid.length;i++)
    {
    	for(int j = 0;j<grid[0].length;j++)
    	{
    		if(grid[i][j]==1)
    			return -1;
    	}
    }
    
    return result;
    
}
class Pair{
	int row;
	int column;
	public Pair(int row, int column)
	{
		this.row = row;
		this.column = column;
	}
}
}