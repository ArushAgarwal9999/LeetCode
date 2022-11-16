class Solution {
    class Pair{
		int rowIndex;
		int columnIndex;
		int maxValue;
		public Pair(int rowIndex, int columnIndex, int maxValue) {
			super();
			this.rowIndex = rowIndex;
			this.columnIndex = columnIndex;
			this.maxValue = maxValue;
		}
	}
   public int swimInWater(int[][] grid) {
	Boolean[][] visited = new Boolean[grid.length][grid[0].length];
	Queue<Pair> quee = new PriorityQueue<Pair>((a,b)->a.maxValue-b.maxValue);
	quee.add(new Pair(0, 0, grid[0][0]));
	visited[0][0] = true;
	while(!quee.isEmpty())
	{
		Pair p = quee.poll();
		if(p.rowIndex==grid.length-1 && p.columnIndex==grid[0].length-1)
			return p.maxValue;
		
		int[] row = {-1,1,0,0};
		int[] column = {0,0,-1,1};
		for(int i = 0;i<row.length;i++)
		{
			int newRow = p.rowIndex+row[i];
			int newColumn = p.columnIndex+column[i];
			if(newRow>=0&& newRow<grid.length && newColumn>=0&& newColumn<grid[0].length&& visited[newRow][newColumn]== null)
			{
                visited[newRow][newColumn] = true;
				quee.add(new Pair(newRow, newColumn, Math.max(p.maxValue, grid[newRow][newColumn])));
			}
		}
	}
	
	
	return 0;
}
}