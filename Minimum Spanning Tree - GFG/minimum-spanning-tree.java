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
    static class DisjointSet{
		ArrayList<Integer> rank = new ArrayList<Integer>();
		ArrayList<Integer> paraent = new ArrayList<Integer>();
		public DisjointSet(int v)
		{
			for(int i = 0;i<v;i++)
			{
				rank.add(0);
				paraent.add(i);
			}
//			System.out.println("rank -->>>"+rank);
//			System.out.println("paraent -->>>"+paraent);
			
		}
		
		public int getParent(int node)
		{
			if(node==paraent.get(node))
				return node;
			int num = getParent(paraent.get(node));
			paraent.set(node, num);
			return paraent.get(node);
		}
		public void union(int u, int v)
		{
//			System.out.println("u -->>"+u);
//			System.out.println("v --->>"+v);
//		    	System.out.println("rank -->>>"+rank);
//			System.out.println("paraent -->>>"+paraent);
			int parentU = getParent(u);
			int parentV = getParent(v);
			if(parentU==parentV)
				return;
			
			if(rank.get(parentU)>rank.get(parentV))
			{
				paraent.set(parentV, parentU);
			}
			else if(rank.get(parentU)==rank.get(parentV))
			{
				paraent.set(parentV, parentU);
				rank.set(parentU,rank.get(parentU)+1);
			}
			else {
				paraent.set(parentU, parentV);
			}
		//	System.out.println("after rank -->>>"+rank);
		//	System.out.println(" after paraent -->>>"+paraent);
		}
	}
	static class Node{
		int souce;
		int destination;
		int weight;
		public Node(int souce, int destination, int weight) {
			super();
			this.souce = souce;
			this.destination = destination;
			this.weight = weight;
		}
		
	}
	
	
	static int spanningTree(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj) 
  {
      int result = 0;
      PriorityQueue<Node> quee = new PriorityQueue<Node>((a,b)->a.weight-b.weight);
      for(int i = 0;i<adj.size();i++)
      {
      	for(ArrayList<Integer> arr:adj.get(i))
      	{
      		//System.out.println("arr -->>>"+arr);
      		quee.add(new Node(i,arr.get(0),arr.get(1)));
      	}
      }
      DisjointSet set = new DisjointSet(V);
      while(!quee.isEmpty())
      {
      	Node node = quee.poll();
      	if(set.getParent(node.souce) == set.getParent(node.destination))
      		continue;
      	result+=node.weight;
      	set.union(node.souce, node.destination);
      }
      return result;
  }

}
