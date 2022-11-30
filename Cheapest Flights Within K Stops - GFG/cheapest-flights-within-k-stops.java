//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int edge=sc.nextInt();
            int[][] adj = new int[edge][3];
            for(int i=0;i<edge;i++){
                adj[i][0]=sc.nextInt();
                adj[i][1]=sc.nextInt();
                adj[i][2]=sc.nextInt();
            }
            int src=sc.nextInt();
            int dst=sc.nextInt();
            int k=sc.nextInt();
            Solution obj = new Solution();
            int res = obj.CheapestFLight(n,adj,src,dst,k);
            System.out.println(res);
        }
    }
}

// } Driver Code Ends


class Solution {
    
   class  QueuePair{
		int node;
		int count;
		int currentDistance;
		public QueuePair(int node, int count, int currentDistance) {
			super();
			this.node = node;
			this.count = count;
			this.currentDistance = currentDistance;
		}
	}
	class Pair{
		int node;
		int distance;
		public Pair(int node, int distance) {
			super();
			this.node = node;
			this.distance = distance;
		}
	}
	 public int CheapestFLight(int n, int[][] flights, int src, int dst, int k) {
	        int[] result = new int[n];
	        Arrays.fill(result, Integer.MAX_VALUE);
	        ArrayList<ArrayList<Pair>> arr = new ArrayList<ArrayList<Pair>>();
	        
	        for(int i = 0;i<n;i++)
	        {
	        	arr.add(new ArrayList<Pair>());
	        }
	        for(int i = 0;i<flights.length;i++)
	        {
	        	arr.get(flights[i][0]).add(new Pair(flights[i][1], flights[i][2]));
	        }
	        Queue<QueuePair> queue = new LinkedList<QueuePair>();
	        queue.add(new QueuePair(src, 0, 0));
	        result[src] = 0;
	        while(!queue.isEmpty())
	        {
	        	QueuePair pair = queue.poll();
	        	if(pair.count>k)
	        		continue;
	        	
	        	for(Pair tmp:arr.get(pair.node))
	        	{
	        		if(result[tmp.node]>pair.currentDistance+tmp.distance && (pair.count)<=k)
	        		{
	        			result[tmp.node] = pair.currentDistance+tmp.distance;
	        			queue.add(new QueuePair(tmp.node, pair.count+1 , pair.currentDistance+tmp.distance ));
	        		}
	        	}
	        }
	        
	        if(result[dst]==Integer.MAX_VALUE)
	        	return -1;
	        return result[dst];
	    }
}