class Solution {
    class PointsPair{
		int destinationNode;
		int distance;
		public PointsPair( int destinationNode, int distance) {
			super();
			this.destinationNode = destinationNode;
			this.distance = distance;
		}
	}
	
	class Pair{
		int node;
		int weight;
		int parent;
		public Pair(int node, int weight, int parent) {
			super();
			this.node = node;
			this.weight = weight;
			this.parent = parent;
		}
	}
	public int minCostConnectPoints(int[][] points) {
        int result = 0;
        ArrayList<ArrayList<PointsPair>> adj =  new  ArrayList<ArrayList<PointsPair>>();
        for(int i = 0;i<points.length;i++)
        	adj.add(new ArrayList<PointsPair>());
        for(int i = 0;i<points.length;i++)
        {
        	for(int j = i+1;j<points.length;j++)
        	{
        		int xDistance = Math.abs(points[i][0]-points[j][0]);
        		int yDistance = Math.abs(points[i][1]-points[j][1]);
        		
        		adj.get(i).add(new PointsPair(j,xDistance+yDistance));
        		adj.get(j).add(new PointsPair(i, yDistance+xDistance));
        		
        	}
        }
        boolean[] visited = new boolean[points.length];
        PriorityQueue<Pair> quee = new PriorityQueue<Pair>((a,b)->a.weight-b.weight);
        
        quee.add(new Pair(0, 0, -1));
        while(!quee.isEmpty())
        {
        	Pair p = quee.poll();
        	if(!visited[p.node])
        	{
        		if(p.parent != -1)
        			result+=p.weight;
        		visited[p.node] = true;
        		for(PointsPair tmp :adj.get(p.node))
        		{
        			if(!visited[tmp.destinationNode])
        			{
        				quee.add(new Pair(tmp.destinationNode, tmp.distance, p.node));
        			}
        		}
        	}
        }
        return result;
    }
}