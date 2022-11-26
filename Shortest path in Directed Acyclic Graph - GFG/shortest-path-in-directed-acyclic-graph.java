//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		while (T-- > 0) {
			int n = sc.nextInt();
			int m = sc.nextInt();
			int[][] edge = new int[m][3];
			for (int i = 0; i < m; i++) {
				edge[i][0] = sc.nextInt();
				edge[i][1] = sc.nextInt();
				edge[i][2] = sc.nextInt();
			}
			Solution obj = new Solution();
			int res[] = obj.shortestPath(n, m,edge);
			for (int i = 0; i < n; i++) {
				System.out.print(res[i] + " ");
			}
			System.out.println();
		}
	}
}
// } Driver Code Ends


//User function Template for Java
class Solution {

class Pair{
			@Override
			public String toString() {
				return "Pair [des=" + des + ", weight=" + weight + "]";
			}
			int des;
			int weight;
			public Pair(int des, int weight) {
				super();
				this.des = des;
				this.weight = weight;
			}
		}
		public int[] shortestPath(int N,int M, int[][] edges) {
			int[] result = new int[N];
			Arrays.fill(result, Integer.MAX_VALUE);
			ArrayList<ArrayList<Pair>> adj = new ArrayList<ArrayList<Pair>>();
			for(int i = 0;i<N;i++)
			{
				adj.add(new ArrayList<Pair>());
			}
			for(int i = 0;i<edges.length;i++)
			{
				adj.get(edges[i][0]).add(new Pair(edges[i][1], edges[i][2]));
			}
			result[0] = 0;
			Queue<Pair> quee = new PriorityQueue<Pair>((a,b)->a.weight-b.weight);
			quee.add(new Pair(0, 0));
			while(!quee.isEmpty())
			{
				Pair p = quee.poll();
				for(Pair num:adj.get(p.des))
				{
					if((p.weight+num.weight)<result[num.des])
					{
						result[num.des]= (p.weight+num.weight);
						quee.add(new Pair(num.des, p.weight+num.weight));
					}
				}
			}
			for(int i = 0;i<result.length;i++)
			{
				if(result[i] ==Integer.MAX_VALUE)
					result[i] =-1;
			}
			
			return result;
		}
}