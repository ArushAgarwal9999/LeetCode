//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String[] S = br.readLine().trim().split(" ");
            int V = Integer.parseInt(S[0]);
            int E = Integer.parseInt(S[1]);
            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
            for(int i = 0; i < V; i++){
                adj.add(new ArrayList<Integer>());
            }
            for(int i = 0; i < E; i++){
                String[] s = br.readLine().trim().split(" ");
                int u = Integer.parseInt(s[0]);
                int v = Integer.parseInt(s[1]);
                adj.get(u).add(v);
                adj.get(v).add(u);
            }
            Solution obj = new Solution();
            boolean ans = obj.isBipartite(V, adj);
            if(ans)
                System.out.println("1");
            else System.out.println("0");
       }
    }
}
// } Driver Code Ends


class Solution
{
    public boolean isBipartite(int V, ArrayList<ArrayList<Integer>>adj)
    {
		int[] colour = new int[V];
		Arrays.fill(colour, -1);
		Queue<Integer> quee = new LinkedList<Integer>();
		for(int i =0;i<V;i++) {
			if(colour[i] ==-1)
			{
				quee.add(i);
				colour[i]=0;
				while(!quee.isEmpty())
				{
					int node=quee.poll();
					for(int a:adj.get(node))
					{
					   // System.out.println("a -->>"+a);
					   // System.out.println("node -->>"+node);
					   // System.out.println("colour[a] -->>"+colour[a]);
					   // System.out.println("colour[node] -->>"+colour[node]);
						if(colour[a] == colour[node])
							return false;
						if(colour[a] == -1)
						{
						    colour[a] = 1-colour[node];
						    quee.add(a);
						}
						
				// 		if(colour[a] != -1)
				// 		{
				// 			if(==0)
				// 			{
								
				// 			}
				// 			else {
				// 				colour[a] = 0;
				// 				quee.add(a);
				// 			}
				// 		}
					}
				}
			}
		}
		
		
		
        return true;
    }
}