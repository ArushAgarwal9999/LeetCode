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
            
            int S = Integer.parseInt(read.readLine());
            
            Solution ob = new Solution();
            
            int[] ptr = ob.dijkstra(V, adj, S);
            
            for(i=0; i<V; i++)
                System.out.print(ptr[i] + " ");
            System.out.println();
        }
    }
}
// } Driver Code Ends


//User function Template for Java


class Solution
{
    //Function to find the shortest distance of all the vertices
    //from the source vertex S.
    static class Pair{
		int node;
		int weight;
		public Pair(int node, int weight) {
			this.node = node;
			this.weight = weight;
		}
		
	}

	static int[] dijkstra(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj, int S)
    {
		ArrayList<ArrayList<Pair>> adjest = new ArrayList<ArrayList<Pair>>();
		for(int i = 0;i<V;i++)
		{
			adjest.add(new ArrayList<Pair>());
		}
		for(int i = 0;i<adj.size();i++)
		{
			for(ArrayList<Integer> arr:adj.get(i))
			{
				adjest.get(i).add(new Pair(arr.get(0), arr.get(1)));
			}
		}
		int[] result = new int[V];
		Arrays.fill(result, Integer.MAX_VALUE);
		result[S]  = 0;
		Queue<Pair> quee = new PriorityQueue<Pair>((a,b)->a.weight-b.weight);
		quee.add(new Pair(S, 0));
		while(!quee.isEmpty())
		{
			Pair p = quee.poll();
			
			for(Pair a:adjest.get(p.node)) {
				if(result[a.node]>p.weight+a.weight)
				{
					result[a.node]  = p.weight+a.weight;
					quee.add(new Pair(a.node, p.weight+a.weight));
				}
			}
			
		}
		
		
		return result;
        // Write your code here
    }
}

