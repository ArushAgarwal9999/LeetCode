//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String[] S = read.readLine().split(" ");
            int N = Integer.parseInt(S[0]);
            int M = Integer.parseInt(S[1]);
            int Grid[][] = new int[N][M];
            for (int i = 0; i < N; i++) {
                String[] s = read.readLine().split(" ");
                for (int j = 0; j < M; j++) Grid[i][j] = Integer.parseInt(s[j]);
            }
            Solution ob = new Solution();
            System.out.println(ob.MinimumEffort(Grid));
        }
    }
}
// } Driver Code Ends


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
	int MinimumEffort(int heights[][]) {
	
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