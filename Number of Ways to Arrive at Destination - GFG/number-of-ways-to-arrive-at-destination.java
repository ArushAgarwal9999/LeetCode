//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
// Position this line where user code will be pasted.

class GFG {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();

            List<List<Integer>> adj = new ArrayList<>();

            for (int i = 0; i < m; i++) {
                List<Integer> temp = new ArrayList<>();
                for (int j = 0; j < 3; j++) {
                    int x = sc.nextInt();
                    temp.add(x);
                }
                adj.add(temp);
            }

            Solution obj = new Solution();
            System.out.println(obj.countPaths(n, adj));
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {

   static class Pair{
		int node;
		int distance;
		public Pair(int node, int distance) {
			super();
			this.node = node;
			this.distance = distance;
		}
	}
	static int countPaths(int n, List<List<Integer>> roads) {
	        int[] distance = new int[n];
	        long[] ways = new long[n];
	        Arrays.fill(distance, Integer.MAX_VALUE);
	        distance[0] = 0;
	        ways[0]=1;
	        ArrayList<ArrayList<Pair>> adj = new ArrayList<ArrayList<Pair>>();
	        for(int i = 0;i<n;i++)
	        	adj.add(new ArrayList<Pair>());
	        	
	        for(List<Integer> a:roads)
	        {
	        	adj.get(a.get(0)).add(new Pair(a.get(1), a.get(2)));
	        	adj.get(a.get(1)).add(new Pair(a.get(0), a.get(2)));
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
	        			ways[tmp.node] = (ways[tmp.node]+ways[p.node])%1000000007;
	        			//quee.add(new Pair(tmp.node, p.distance+tmp.distance));
	        			
	        		}
	        	}
	        }
	        
	        
	        return (int)ways[n-1];
	    }
}
