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
		int[] colur = new int[V];
		Arrays.fill(colur, -1);
		for(int i = 0;i<V;i++)
		{
			if(colur[i]==-1)
			{
				colur[i]=0;
				if(!dfs(i, colur, adj))
					return false;
			}
		}
		return true;
        // Code here
    }
	public boolean dfs(int index,int[] colur,ArrayList<ArrayList<Integer>>adj)
	{
		for(int a:adj.get(index))
		{
			if(colur[a]==colur[index])
				return false;
			if(colur[a] == -1)
			{
				colur[a] = 1-colur[index];
				if(!dfs(a, colur, adj))
					return false;
			}
			
			
			
		}
		return true;
	}
}



