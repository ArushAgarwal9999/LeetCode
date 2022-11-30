//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

// Position this line where user code will be pasted.

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int[] a = new int[n];

            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
            }

            int start = sc.nextInt();
            int end = sc.nextInt();

            Solution ob = new Solution();
            int ans = ob.minimumMultiplications(a, start, end);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
   class Pair{
		int node;
		int distance;
		public Pair(int node, int distance) {
			super();
			this.node = node;
			this.distance = distance;
		}
	}
	int minimumMultiplications(int[] arr, int start, int end) {
		Queue<Pair> quee = new LinkedList<Pair>();
		int[] distance= new int[100000];
		Arrays.fill(distance, Integer.MAX_VALUE);
		distance[start] = 0;
		quee.add(new Pair(start, 0));
		while(!quee.isEmpty())
		{
			Pair p = quee.poll();
			
			if(p.node == end)
				return p.distance;
			for(int a:arr)
			{
				int tmp = (a*p.node)% 100000;
				if(distance[tmp]>p.distance+1)
				{
					distance[tmp] = p.distance+1;
					quee.add(new Pair(tmp, p.distance+1));
				}
					
			}
		}

       return -1;
    }

}
