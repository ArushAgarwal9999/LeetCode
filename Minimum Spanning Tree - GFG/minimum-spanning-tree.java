//{ Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;

class DriverClass
{
    public static void main(String args[]) throws IOException {

        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String str[] = read.readLine().trim().split(" ");
            int V = Integer.parseInt(str[0]);
            int E = Integer.parseInt(str[1]);
    
            ArrayList<ArrayList<ArrayList<Integer>>> adj = new ArrayList<ArrayList<ArrayList<Integer>>>();
            for(int i=0;i<V;i++)
            {
                adj.add(new ArrayList<ArrayList<Integer>>());
            }
            
            int i=0;
            while (i++<E) {
                String S[] = read.readLine().trim().split(" ");
                int u = Integer.parseInt(S[0]);
                int v = Integer.parseInt(S[1]);
                int w = Integer.parseInt(S[2]);
                ArrayList<Integer> t1 = new ArrayList<Integer>();
                ArrayList<Integer> t2 = new ArrayList<Integer>();
                t1.add(v);
                t1.add(w);
                t2.add(u);
                t2.add(w);
                adj.get(u).add(t1);
                adj.get(v).add(t2);
            }
            
            Solution ob = new Solution();
            
            System.out.println(ob.spanningTree(V, adj));
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution
{
    //Function to find sum of weights of edges of the Minimum Spanning Tree.
    static class Pair{
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
	static int spanningTree(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj) 
    {
		int result = 0;
        PriorityQueue<Pair> quee = new PriorityQueue<Pair>((a,b)->a.weight-b.weight);
        quee.add(new Pair(0,0,-1));
        boolean[] visited = new boolean[V];
        while(!quee.isEmpty())
        {
        	
        	Pair p = quee.poll();
        	if(!visited[p.node])
        	{
        		visited[p.node] = true;
        		if(p.parent != -1)
        		{
        			result+=p.weight;
        		}
        		for(ArrayList<Integer> tmp:adj.get(p.node))
        		{
        			if(!visited[tmp.get(0)])
        			{
        				quee.add(new Pair(tmp.get(0), tmp.get(1), p.node));
        			}
        		}
        	}
        }
        
        
        return result;
    }
}
