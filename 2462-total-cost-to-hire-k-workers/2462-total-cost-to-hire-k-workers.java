class Solution {
    public long totalCost(int[] costs, int k, int candidates) {
       
        if(costs.length<candidates)
        {
        	PriorityQueue<Integer> quee = new PriorityQueue<Integer>();
        	for(int a:costs)
        	{
        		quee.add(a);
        	}
        	long result= 0;
        	//System.out.println("quee  -->>"+quee);
        	while(k>0)
        	{
        		result+=quee.poll();
        		k--;
        	}
        	return result;
        }
        else {
        	long result = 0;
        	 PriorityQueue<Integer> quee1 = new PriorityQueue<Integer>();
             PriorityQueue<Integer> quee2 = new PriorityQueue<Integer>();
             int i = 0;
             int j = costs.length-1;
             
             while(i<candidates)
             {
            	 quee1.add(costs[i]);
            	 i++;
             }
             i--;
             while(j>i && j>=(costs.length-candidates))
             {
            	 quee2.add(costs[j]);
            	 j--;
             }
             j++;
            // System.out.println("quee 1 -->>"+quee1);
        	// System.out.println("quee 2 -->>"+quee2);
             while(k>0 && (quee1.size()+quee2.size())>=candidates)
             {
            	  
            	 if(quee1.size()== 0 || quee2.size() == 0)
            	 {
            		 if(quee1.size() == 0)
            		 {
            			 result+=quee2.poll();
                		 if(j-1>i)
                		 {
                			 quee2.add(costs[--j]);
                		 }
            		 }
            		 else {
            			 result+=quee1.poll();
                		 if(i+1<j)
                		 {
                			 quee1.add(costs[++i]);
                		 }
            		 }
            		 
            	 }
            	 else {
            		 if(quee1.peek()<=quee2.peek())
                	 {
                		 result+=quee1.poll();
                		 if(i+1<j)
                		 {
                			 quee1.add(costs[++i]);
                		 }
                	 }
                	 else {
                		 result+=quee2.poll();
                		 if(j-1>i)
                		 {
                			 quee2.add(costs[--j]);
                		 }
                	 }
            	 }
                 k--;
            	// System.out.println("quee 1 -->>"+quee1);
            	// System.out.println("quee 2 -->>"+quee2);
             }
             
             if(k>0)
             {
            	 quee1.addAll(quee2);
            	 //System.out.println("quee 1 -->>"+quee1);
            	 while(k>0)
            	 {
            		 result+=quee1.poll();
             		k--;
             		 //System.out.println("quee 1 -->>"+quee1);
            	 }
             }
             
             
             return result;
             
        }
    }
}