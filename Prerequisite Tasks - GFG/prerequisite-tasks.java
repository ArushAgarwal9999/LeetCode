//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
	public static void main(String args[]) throws IOException
	{
	    Scanner sc = new Scanner(System.in);
	    int t = sc.nextInt();
		while(t>0)
		{
		    int N = sc.nextInt();
		    int P = sc.nextInt();
		    int prerequisites[][] = new int[P][2];
		    for(int i=0;i<P;i++)
		    {
		        for(int j=0;j<2;j++)
		        {
		            prerequisites[i][j] = sc.nextInt();
		        }
		    }
			Solution ob = new Solution();
			if(ob.isPossible(N,prerequisites))
			{
			    System.out.println("Yes");
			}
			else{
			    System.out.println("No");
			}
			t--;
		}
	}
	
}

// } Driver Code Ends


//User function Template for Java

class Solution {
   public boolean isPossible(int numCourses, int[][] prerequisites) {
        int [] indrgree = new int[numCourses];
        ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>();
        for(int i = 0;i<numCourses;i++)
        {
        	adj.add(new ArrayList<Integer>());
        }
        Queue<Integer> quee = new LinkedList<Integer>();
        for(int [] a:prerequisites)
        {
        	adj.get(a[1]).add(a[0]);
        	indrgree[a[0]]++;
        }
        for(int i = 0;i<indrgree.length;i++)
        {
        	if(indrgree[i]==0)
        	{
        		quee.add(i);
        	}
        }
        while(!quee.isEmpty())
        {
        	int a=quee.poll();
        	for(int num:adj.get(a))
        	{
        		indrgree[num]--;
        		if(indrgree[num]==0)
        		{
        			quee.add(num);
        		}
        	}
        }
        for(int a:indrgree)
        	if(a!=0)
        		return false;
        return true;
    }
    
}