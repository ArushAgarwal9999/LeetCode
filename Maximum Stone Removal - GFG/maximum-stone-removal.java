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
            int[][] arr = new int[n][2];
            for (int i = 0; i < n; i++) {
                arr[i][0] = sc.nextInt();
                arr[i][1] = sc.nextInt();
            }
            Solution obj = new Solution();
            int ans = obj.maxRemove(arr, n);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


class Solution {

  class Disjont{
		ArrayList<Integer> rank  = new ArrayList<Integer>();
		ArrayList<Integer> parent = new ArrayList<Integer>();
		public Disjont(int n) {
			for(int i = 0;i<=n;i++)
			{
				rank.add(0);
				parent.add(i);
			}
			
		}
		public int getparent(int node)
		{
			if(node == parent.get(node))
				return node;
			int tmp = getparent(parent.get(node));
			parent.set(node, tmp);
			return parent.get(node);
		}
		public void union(int u, int v)
		{
			int parentU =getparent(u);
			int parentV = getparent(v);
			if(parentU==parentV)
				return;
			if(rank.get(parentU)>rank.get(parentV))
			{
				parent.set(parentV,parentU);
			}
			else if(rank.get(parentU)>rank.get(parentV))
			{
				parent.set(parentV, parentU);
				rank.set(parentU, rank.get(parentU)+1);
			}
			else {
				parent.set(parentU, parentV);
			}
		}
		
	}
	int maxRemove(int[][] stones, int n) {
	int maxRow = 0;
	int maxColumn = 0;
	for(int i = 0;i<stones.length;i++)
	{
		maxRow = Math.max(maxRow, stones[i][0]);
		maxColumn = Math.max(maxColumn, stones[i][1]);
		
	}
	Disjont set = new Disjont(maxRow+maxColumn+1);
	HashSet<Integer> stone = new HashSet<Integer>();
	for(int i = 0;i<stones.length;i++)
	{
		int nRow = stones[i][0];
		int nCloumn = maxRow+stones[i][1]+1;
		set.union(nRow,nCloumn );
		stone.add(nRow);
		stone.add(nCloumn);
	}
	int numberOfComponent = 0;
	for(int a:stone)
	{
		if(set.getparent(a)==a)
		{
			numberOfComponent++;
		}
	}
	return stones.length-numberOfComponent;
	
        
    }
};
