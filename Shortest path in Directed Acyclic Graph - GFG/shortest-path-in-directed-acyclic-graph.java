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
    class Par{
		int des;
		int weight;
		public Par(int des, int weight) {
			super();
			this.des = des;
			this.weight = weight;
		}
		@Override
			public String toString() {
				return "Par [des=" + des + ", weight=" + weight + "]";
			}
	}

	public int[] shortestPath(int N,int M, int[][] edges) {
		//Code here
		int[] result = new int[N];
		int[] indegree = new int[N];
		Arrays.fill(result, Integer.MAX_VALUE);
		ArrayList<ArrayList<Par>> adj = new ArrayList<ArrayList<Par>>();
		for(int i = 0;i<N;i++)
		{
			adj.add(new ArrayList<Par>());
		}
		for(int i = 0;i<edges.length;i++)
		{
			adj.get(edges[i][0]).add(new Par(edges[i][1], edges[i][2]));
			indegree[edges[i][1]]++;
		}
// 		System.out.println("indegree -->>"+Arrays.toString(indegree));
		Queue<Integer> quee = new LinkedList<Integer>();
		for(int i = 0;i<indegree.length;i++)
		{
			if(indegree[i]==0)
				quee.add(i);
		}
// 		System.out.println("quee -->>"+quee);
		Stack<Integer> inorder = new Stack<Integer>();
		while(!quee.isEmpty())
		{
			int a = quee.poll();
// 			System.out.println("a -->>"+a);
			inorder.add(a);
			for(Par num:adj.get(a))
			{
				indegree[num.des]--;
				// System.out.println("indegree 1-->>"+Arrays.toString(indegree));
				if(indegree[num.des]==0)
					quee.add(num.des);
			}
		}
		result[0] = 0;
// 			System.out.println("inorder -->>"+inorder);
		while(!inorder.isEmpty())
		{
			int num =inorder.remove(0);
// 			System.out.println("num -->>"+num);
			int currentdis = result[num];
			for(Par par:adj.get(num))
			{
			 //   System.out.println("par -->>"+par);
			 //   System.out.println("current weight -->>"+(currentdis+par.weight));
				if( currentdis !=Integer.MAX_VALUE && result[par.des]>(currentdis+par.weight) )
				{
					result[par.des] = currentdis+par.weight;
				}
				// System.out.println("result -->>"+Arrays.toString(result));
			}
		}
		for(int i = 0;i<result.length;i++)
		{
			if(result[i]==Integer.MAX_VALUE)
				result[i]=-1;
		}
		
		return result;
	}
}