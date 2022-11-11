//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            String[] s = br.readLine().trim().split(" ");
            int V = Integer.parseInt(s[0]);
            int E = Integer.parseInt(s[1]);
            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
            for (int i = 0; i < V; i++) adj.add(i, new ArrayList<Integer>());
            for (int i = 0; i < E; i++) {
                String[] S = br.readLine().trim().split(" ");
                int u = Integer.parseInt(S[0]);
                int v = Integer.parseInt(S[1]);
                adj.get(u).add(v);
                adj.get(v).add(u);
            }
            Solution obj = new Solution();
            boolean ans = obj.isCycle(V, adj);
            if (ans)
                System.out.println("1");
            else
                System.out.println("0");
        }
    }
}
// } Driver Code Ends


class Solution {
    // Function to detect cycle in an undirected graph.
   public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
		boolean[] visited = new boolean[V];
		Queue<int[]> quee = new LinkedList<int[]>();
		for(int i = 0;i<V;i++)
		{
			if(visited[i]==false)
			{
				quee.add(new int[] {i,-1});
				visited[i] = true;
				while(!quee.isEmpty())
				{
					int size = quee.size();
					while(size>0)
					{
						size--;
						int[] arr = quee.poll();
						for(int a: adj.get(arr[0]))
						{
							if(a!=arr[1])
							{
								if(visited[a])
									return true;
								visited[a]  =true;
								quee.add(new int[] {a,arr[0]});
							}
						}
					}
					
					
				}
			}
			
		}
		
		return false;
		
		
        // Code here
    }
}