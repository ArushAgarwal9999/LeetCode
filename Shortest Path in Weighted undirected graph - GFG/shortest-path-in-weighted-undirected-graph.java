//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;
@SuppressWarnings("unchecked") class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int edges[][] = new int[m][3];
            for (int i = 0; i < m; i++) {
                edges[i][0] = sc.nextInt();
                edges[i][1] = sc.nextInt();
                edges[i][2] = sc.nextInt();
            }
            Solution obj = new Solution();
            List<Integer> ans = obj.shortestPath(n, m, edges);
            for (int e : ans) {
                System.out.print(e + " ");
            }
            System.out.println();
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    static class Pair{
		int node;
		int weight;
		int comeFrom;
		public Pair(int node, int weight, int comeFrom) {
			super();
			this.node = node;
			this.weight = weight;
			this.comeFrom = comeFrom;
		}
		public Pair(int node, int weight) {
			super();
			this.node = node;
			this.weight = weight;
		}
		
	}
	public static List<Integer> shortestPath(int n, int m, int edges[][]) {
        // code here
		ArrayList<ArrayList<Pair>> adj = new ArrayList<ArrayList<Pair>>();
		for(int i = 0;i<=n;i++)
		{
			adj.add(new ArrayList<Pair>());
		}
		for(int[] a:edges)
		{
			adj.get(a[0]).add(new Pair(a[1], a[2]));
			adj.get(a[1]).add(new Pair(a[0], a[2]));
		}
		ArrayList<Pair> path = new ArrayList<Pair>();
		for(int i = 0;i<=n;i++)
		{
			path.add(new Pair(i, Integer.MAX_VALUE,0));
		}
		path.get(1).weight=0;
		Queue<Pair> quee = new PriorityQueue<Pair>((a,b)->a.weight-b.weight);
		quee.add(new Pair(1, 0));
		while(!quee.isEmpty())
		{
			Pair p = quee.poll();
			for(Pair tmp:adj.get(p.node))
			{
				if(path.get(tmp.node).weight>tmp.weight+p.weight)
				{
					path.get(tmp.node).weight= tmp.weight+p.weight;
					path.get(tmp.node).comeFrom =p.node;
					quee.add(new Pair(tmp.node, tmp.weight+p.weight));
				}
			}
		}
		//System.out.println("path.get(n).weight -->>"+path.get(n).weight);
		if(path.get(n).weight==Integer.MAX_VALUE)
		{
			List<Integer> result = new ArrayList<Integer>();
			result.add(-1);
			return result;
		}
		else {
			List<Integer> result = new ArrayList<Integer>();
			Pair tmp = path.get(n);
			
			while(tmp.node != 0)
			{
				result.add(tmp.node);
				tmp = path.get(tmp.comeFrom);
				
			}
			Collections.reverse(result);
			return result;
			
		}
    }
}