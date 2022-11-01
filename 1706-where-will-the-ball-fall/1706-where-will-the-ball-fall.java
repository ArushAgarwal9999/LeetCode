class Solution {
    public int[] findBall(int[][] grid) {
        int[] result = new int[grid[0].length];
        for(int i = 0;i<grid[0].length;i++)
        {
        	result[i] = getDis(0, i, grid);
        }
        return result;
    }
public int getDis(int level, int column, int[][] grid )
{
	if(level>=grid.length)
		return column;
	int newColum = -1;
	if(grid[level][column] ==1)
	{
		newColum = column+1;
	}
	else {
		newColum = column-1;
	}
	
	if(newColum<0 || newColum >=grid[0].length || grid[level][column] != grid[level][newColum])
		return -1;
	
	return getDis(level+1, newColum, grid);
	
}
}