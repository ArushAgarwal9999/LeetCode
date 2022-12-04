class Solution {
    class Pair{
		int destNode;
		int weight;
		public Pair( int destNode, int weight) {
			super();
			this.destNode = destNode;
			this.weight = weight;
		}
		
	}
	
public int minScore(int n, int[][] roads) {
	int result = 0;
	int[] ditance= new int[n+1];
	Arrays.fill(ditance, Integer.MAX_VALUE);
	ArrayList<ArrayList<Pair>> adj = new ArrayList<ArrayList<Pair>>();
	for(int i = 0;i<=n;i++)
		adj.add(new ArrayList<Pair>());
		
	PriorityQueue<Pair> quee = new PriorityQueue<Pair>((a,b)->a.weight-b.weight);
	for(int[]a:roads)
	{
		adj.get(a[0]).add(new Pair( a[1], a[2]));
		adj.get(a[1]).add(new Pair( a[0], a[2]));
	}
	quee.add(new Pair(1, Integer.MAX_VALUE));
	
	while(!quee.isEmpty())
	{
		Pair p= quee.poll();
		for(Pair tmp:adj.get(p.destNode))
		{
			if(ditance[tmp.destNode]>Math.min(p.weight, tmp.weight))
			{
				ditance[tmp.destNode] = Math.min(p.weight, tmp.weight);
				quee.add(new Pair(tmp.destNode, ditance[tmp.destNode]));
			}
		}
	}
	
	return ditance[n];
        
    }
}