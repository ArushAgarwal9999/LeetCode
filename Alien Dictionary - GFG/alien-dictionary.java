//{ Driver Code Starts
/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;
import java.math.*;

class GFG {
	public static void main (String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int t = Integer.parseInt(sc.next());
		while(t-- > 0)
		{
		    int n = Integer.parseInt(sc.next());
		    int k = Integer.parseInt(sc.next());
		    
		    String[] words = new String[n];
		    
		    for(int i=0;i<n;i++)
		    {
		        words[i] = sc.next();
		    }
		    
		    Solution ob = new Solution();
		  //  System.out.println(T.findOrder(words,k));
		    String order = ob.findOrder(words,n,k);
		    if(order.length() == 0){
		        System.out.println(0);
		        continue;
		    }
		    String temp[] = new String[n];
		    for(int i=0;i<n;i++)
		        temp[i] = words[i];
		    
		    Arrays.sort(temp, new Comparator<String>(){
		    
		      @Override
                public int compare(String a, String b) {
                    int index1 = 0;
                    int index2 = 0;
                    for(int i = 0; i < Math.min(a.length(), b.length()) 
                                        && index1 == index2; i++) {
                        index1 = order.indexOf(a.charAt(i));
                        index2 = order.indexOf(b.charAt(i));
                    }
                
                    if(index1 == index2 && a.length() != b.length()) 
                    {
                        if(a.length() < b.length())
                            return -1;
                        else
                            return 1;
                    }
                
                    if(index1 < index2)
                        return -1;
                    else
                        return 1;
                        
                }
		    });
		    
		    int flag = 1;
		    for(int i=0;i<n;i++)
		    {
		        if(!words[i].equals(temp[i]))
	            {
	                flag = 0;
	                break;
	            }
		    }
		    
		    System.out.println(flag);
		}
	}
	
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
    
	public String findOrder(String [] dict, int N, int K)
	{
		int[]indegree = new int[K];
		int[]indegree1 = new int[K];
		ArrayList<ArrayList<Integer>> arr = new ArrayList<ArrayList<Integer>>();
			ArrayList<ArrayList<Integer>> arr1 = new ArrayList<ArrayList<Integer>>();
		for(int i = 0;i<K;i++)
		{
			arr.add(new ArrayList<Integer>());
				arr1.add(new ArrayList<Integer>());
		}
		Queue<Integer> quee = new LinkedList<Integer>();
		for(int i = 0;i<dict.length-1;i++)
		{
			int[] res = compare(dict[i], dict[i+1]);
			if(res != null)
			{
				arr.get(res[0]).add(res[1]);
				indegree[res[1]]++;
			}
		}
	
	 
// 			System.out.println("arr-->>"+arr);
// 				System.out.println("arr1-->>"+arr1);
// 				System.out.println("indegree -->>"+Arrays.toString(indegree));
// 				System.out.println("indegree1 -->>"+Arrays.toString(indegree1));
			
		Stack<Character> res = new Stack<Character>();
		for(int i = 0;i<indegree.length;i++)
		{
			if(indegree[i]==0)
			{
				quee.add(i);
			}
		}
		
		while(!quee.isEmpty())
		{
			int a=quee.poll();
			res.add( (char)( a+'a'));
			for(int num:arr.get(a))
			{
				indegree[num]--;
				if(indegree[num]==0)
				{
					quee.add(num);
				}
			}
		}
		StringBuilder result = new StringBuilder();
		while(!res.isEmpty())
		{
			result.append(res.pop());
		}
		//System.out.println("result -->>"+result.reverse().toString());
	   return result.reverse().toString();
	    
	    
	}
public int[] compare(String a, String b)
	{
		int[] result = new int[2];
		int i = 0;
		int j = 0;
		while(i<a.length()&& j<b.length())
		{
			if(a.charAt(i)!= b.charAt(j))
			{
				result[0] = a.charAt(i)-'a';
				result[1] = b.charAt(i)-'a';
				return result;
			}
			i++;
			j++;
		}
		return null;
	}
}