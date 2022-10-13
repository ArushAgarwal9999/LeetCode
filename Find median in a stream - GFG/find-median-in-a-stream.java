//{ Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;


class GFG
{
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        int n;
        while(t-- > 0){
            n = sc.nextInt();
    
            Solution obj = new Solution();
            for(int i = 1; i <= n; i++)
            {
                int x =sc.nextInt();
                obj.insertHeap(x);
                System.out.println((int)Math.floor(obj.getMedian()));
            }
        }
        
        
    }
}


// } Driver Code Ends


class Solution
{
    //Function to insert heap.
    static PriorityQueue<Integer>maxQueue = new PriorityQueue<Integer>((a,b)->b-a);
    static PriorityQueue<Integer>minQueue = new PriorityQueue<Integer>((a,b)->a-b);
    public static void insertHeap(int x)
    {
        if(maxQueue.isEmpty() || maxQueue.peek()>=x)
            maxQueue.add(x);
        else
        minQueue.add(x);
        
        balanceHeaps();
    }
    
    //Function to balance heaps.
    public static void balanceHeaps()
    {
        if(maxQueue.size()>minQueue.size()+1)
            minQueue.add(maxQueue.poll());
       else if(maxQueue.size()<minQueue.size())
                maxQueue.add(minQueue.poll());
    }
    
    //Function to return Median.
    public static double getMedian()
    {
        double result = 0;
        //System.out.println("min"+minQueue);
        //System.out.println("max"+maxQueue);
        if((maxQueue.size()+minQueue.size())%2 != 0)
                result = maxQueue.peek();
        else
            result = (maxQueue.peek()+minQueue.peek())/2;
        return result;
    }
    
}