//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;

class Gfg
{
    public static void main (String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            // arraylist of arraylist to represent graph
            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
            
            int V = Integer.parseInt(sc.next());
            int E = Integer.parseInt(sc.next());
            
            for(int i =0; i < V; i++)
                adj.add(i, new ArrayList<Integer>());
                
            for(int i = 1; i <= E; i++)
            {    int u = Integer.parseInt(sc.next());
                 int v = Integer.parseInt(sc.next());
                 
                 // adding directed edgese between 
                 // vertex 'u' and 'v'
                 adj.get(u).add(v);
            }
            
            Solution ob = new Solution();
            System.out.println(ob.kosaraju(V, adj));
		}
    }
}

// } Driver Code Ends


//User function Template for Java


class Solution
{
    //Function to find number of strongly connected components in the graph.
   public int kosaraju(int V, ArrayList<ArrayList<Integer>> adj)
	 {
		 Stack<Integer> stack = new Stack<Integer>();
		 boolean[] visited = new boolean[V];
		 for(int i = 0;i<V;i++)
		 {
			 if(visited[i]==false)
			 {
				 visited[i] = true;
				 dfs(i, stack, visited, adj);
			 }
			 
		 }
		
		 ArrayList<ArrayList<Integer>> reverseAdj = new ArrayList<ArrayList<Integer>>();
		 for(int i = 0;i<V;i++)
			 reverseAdj.add(new ArrayList<Integer>());
		 for(int i = 0;i<adj.size();i++)
		 {
			 for(int j = 0;j<adj.get(i).size();j++)
			 {
				 reverseAdj.get(adj.get(i).get(j)).add(i);
			 }
		 }
		 int result = 0;
		 Arrays.fill(visited, false);
		 while(!stack.isEmpty())
		 {
			 int num = stack.pop();
			 if(visited[num]==false)
			 {
				 result++;
				 visited[num] = true;
				 dfs1(num,visited,reverseAdj);
			 }
		 }
		 
		 
		 //System.out.println("adj -->>"+adj);
		 //System.out.println("reverse -->>"+reverseAdj);
		 return result;
		 
	        //code here
	 }
	 public void dfs1(int node, boolean[] visited,ArrayList<ArrayList<Integer>> adj)
	 {
		 for(int num:adj.get(node))
		 {
			 if(visited[num]==false)
			 {
				 visited[num] = true;
				 dfs1(num,visited,adj);
			 }
		 }
		 
	 }
	 public void dfs(int node, Stack<Integer> stack,boolean[] visited,ArrayList<ArrayList<Integer>> adj)
	 {
		 for(int num:adj.get(node))
		 {
			 if(visited[num]==false)
			 {
				 visited[num] = true;
				 dfs(num, stack, visited, adj);
			 }
		 }
		 stack.add(node);
	 }
}
