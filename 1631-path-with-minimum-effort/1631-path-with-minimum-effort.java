class Solution {
    class Pair{
		int row;
		int column;
		int diff;
		public Pair(int row,int column, int diff) {
			super();
			this.row = row;
			this.column = column;
			this.diff = diff;
		}
        @Override
		public String toString() {
			return "Pair [row=" + row + ", column=" + column + ", diff=" + diff + "]";
		}
		
		
	}
   public int minimumEffortPath(int[][] heights) {
	boolean[][] visited = new boolean[heights.length][heights[0].length];
	Queue<Pair> quee = new PriorityQueue<Pair>((a,b)->a.diff-b.diff);
	quee.add(new Pair(0, 0, 0));
	while(!quee.isEmpty())
	{
		//System.out.println("quee -->>"+quee);
		
		Pair p = quee.poll();
        visited[p.row][p.column] = true;
		//System.out.println("pair p -->>"+p);
		if(p.row==heights.length-1 && p.column==heights[0].length-1)
		{
			return p.diff;
		}
		int[] rowMove = {-1,1,0,0};
		int[] columnMove = {0,0,-1,1};
		for(int i = 0;i<rowMove.length;i++)
		{
			int newRow = p.row+rowMove[i];
			int newColumn= p.column+columnMove[i];
			if(newRow>=0 && newRow<heights.length&&newColumn>=0&& newColumn<heights[0].length && visited[newRow][newColumn]==false)
			{
				//visited[newRow][newColumn] = true;
				quee.add(new Pair(newRow, newColumn, Math.max(Math.abs(heights[newRow][newColumn]-heights[p.row][p.column]), p.diff)));
				
			}
			
		}
		
	}
        return 0;
    }
}