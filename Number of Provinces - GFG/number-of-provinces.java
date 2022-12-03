//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int V = Integer.parseInt(read.readLine());
            
            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
            
            for(int i=0; i<V; i++)
            {
                String S[] = read.readLine().split(" ");
                ArrayList<Integer> temp = new ArrayList<>();
                for(int j=0; j<V; j++)
                    temp.add(Integer.parseInt(S[j]));
                adj.add(temp);
            }

            Solution ob = new Solution();
            System.out.println(ob.numProvinces(adj,V));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
   static class DisjoinSet{
	  ArrayList<Integer> parent = new ArrayList<Integer>();
	  ArrayList<Integer> rank = new ArrayList<Integer>();
	  public DisjoinSet(int V)
	  {
		  for(int i = 0;i<V;i++)
		  {
			  parent.add(i);
			  rank.add(0);
		  }
	  }
	  public int getParent(int node)
	  {
		  if(node == parent.get(node))
			  return node;
		  int num = getParent(parent.get(node));
		  parent.set(node, num);
		  return parent.get(node);
	  }
	  public void union(int u, int v)
	  {
		  int parentU= getParent(u);
		  int parentV= getParent(v);
		  if(parentU == parentV)
		    return;
		  if(parentU>parentV)
		  {
			  parent.set(parentV, parentU);
		  }
		  else if(parentU==parentV)
		  {
			  parent.set(parentV, parentU);
			  rank.set(parentU, rank.get(parentU)+1);
		  }
		  else {
			  parent.set(parentU, parentV);
		  }
	  }
	  public int getComponent()
	  {
		  int result = 0;
		  for(int i = 0;i<parent.size();i++)
		  {
			  if(parent.get(i)==i)
				  result++;
				  
		  }
		  
		  return result;
	  }
  }
	static int numProvinces(ArrayList<ArrayList<Integer>> adj, int V) {
        int result =0;
        DisjoinSet set = new DisjoinSet(V);
        for(int i = 0;i<adj.size();i++)
        {
        	for(int j = 0;j<adj.get(i).size();j++)
        	{
        		if(adj.get(i).get(j)==1)
        			set.union(i, j);
        	}
        }
        return set.getComponent();
    }
};