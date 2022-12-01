class Solution {
   class Pair{
		int node;
		int distance;
		public Pair(int node, int distance) {
			super();
			this.node = node;
			this.distance = distance;
		}
	}
	 public int countPaths(int n, int[][] roads) {
	        int[] distance = new int[n];
	        long[] ways = new long[n];
	        Arrays.fill(distance, Integer.MAX_VALUE);
	        distance[0] = 0;
            ways[0] = 1;
	        ArrayList<ArrayList<Pair>> adj = new ArrayList<ArrayList<Pair>>();
	        for(int i = 0;i<n;i++)
	        	adj.add(new ArrayList<Pair>());
	        	
	        for(int[] a:roads)
	        {
	        	adj.get(a[0]).add(new Pair(a[1], a[2]));
	        	adj.get(a[1]).add(new Pair(a[0], a[2]));
	        }
	        Queue<Pair> quee = new PriorityQueue<Pair>((a,b)->a.distance-b.distance);
	        quee.add(new Pair(0, 0));
	        
	        while(!quee.isEmpty())
	        {
	        	Pair p = quee.poll();
	        	for(Pair tmp :adj.get(p.node))
	        	{
	        		if(distance[tmp.node]>p.distance+tmp.distance)
	        		{
	        			distance[tmp.node] = p.distance+tmp.distance;
	        			ways[tmp.node]=ways[p.node];
	        			quee.add(new Pair(tmp.node, p.distance+tmp.distance));
	        		}
	        		else if(distance[tmp.node]==p.distance+tmp.distance)
	        		{
	        			ways[tmp.node] = (ways[tmp.node]+(ways[p.node]%1000000007))%1000000007;
	        			//quee.add(new Pair(tmp.node, p.distance+tmp.distance));
	        			
	        		}
	        	}
	        }
	        
	        
	        return (int)ways[n-1];
	    }
}