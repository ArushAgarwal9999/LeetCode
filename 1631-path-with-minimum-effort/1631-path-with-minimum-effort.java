class Solution {
   class Pair{
		int row ;
		int column;
		int diff;
		@Override
		public String toString() {
			return "Pair [row=" + row + ", column=" + column + ", diff=" + diff + "]";
		}
		public Pair(int row, int column, int diff) {
			super();
			this.row = row;
			this.column = column;
			this.diff = diff;
		}
	}
public int minimumEffortPath(int[][] heights) {
	
	int[][] ditance = new int[heights.length][heights[0].length];
	for(int[]a:ditance)
		Arrays.fill(a, Integer.MAX_VALUE);
	Queue<Pair> quee = new PriorityQueue<Pair>((a,b)->a.diff-b.diff);
	ditance[0][0] = 0;
	quee.add(new Pair(0, 0, 0));
	while(!quee.isEmpty())
	{
		//System.out.println("quee -->>"+quee);
		Pair p = quee.poll();
		if(p.row == heights.length-1 && p.column==heights[0].length-1)
		{
			return p.diff;
		}
		int[] row = {-1,1,0,0};
		int[] column = {0,0,-1,1};
		for(int i = 0;i<row.length;i++)
		{
			int newRow = row[i]+p.row;
			int newcolumn = column[i]+p.column;
			if(newcolumn>=0&& newcolumn<heights[0].length&& newRow>=0 && newRow<heights.length)
			{
				int dis = Math.max(p.diff,  Math.abs(heights[p.row][p.column]-heights[newRow][newcolumn]));
				if(dis<ditance[newRow][newcolumn])
				{
                    ditance[newRow][newcolumn] = dis;
					quee.add(new Pair(newRow, newcolumn,dis));
				}
				
			}
		}
	}
	return 0;
        
    }
}