//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int[][] edge = new int[m][2];
            for (int i = 0; i < m; i++) {
                edge[i][0] = sc.nextInt();
                edge[i][1] = sc.nextInt();
            }

            Solution obj = new Solution();
            int ans = obj.Solve(n, edge);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


class Solution {

   class DisJoint{
		ArrayList<Integer> rank = new ArrayList<Integer>();
		ArrayList<Integer> parent = new ArrayList<Integer>();
		public DisJoint(int n)
		{
			for(int i = 0;i<n;i++)
			{
				rank.add(0);
				parent.add(i);
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
		public void union(int u, int  v)
		{
			int parentU = getParent(u);
			int parentV = getParent(v);
			if(parentU==parentV)
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
				parent.set(parentU,parentV);
			}
		}
		public int getComponent()
		{
			int result = 0;
			for(int i = 0;i<parent.size();i++)
			{
				if(i==parent.get(i))
					result++;
			}
			return result-1;
		}
	}
  

public int Solve(int n, int[][] connections) {
	DisJoint set = new DisJoint(n);
	int extranode = 0;
	for(int[] num:connections)
	{
		if(set.getParent(num[0])==set.getParent(num[1]))
			extranode++;
		else {
			set.union(num[0], num[1]);
		}
	}
	int totalComponent = set.getComponent();
	
	if(totalComponent>extranode)
		return -1;
	return totalComponent;
	
        
    }
}