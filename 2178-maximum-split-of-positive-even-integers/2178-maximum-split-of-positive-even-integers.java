class Solution {
    public List<Long> maximumEvenSplit(long finalSum) {
        HashSet<Long> set  = new HashSet<Long>();
        if(finalSum%2 !=0)
        	return  new ArrayList<Long>();
        long currentSum = 0;
        long currentNum = 2;
        while(currentSum<finalSum)
        {
        	//System.out.println("currentSum -->>"+currentSum);
            //System.out.println("currentNum -->>"+currentNum);
        	currentSum+=currentNum;
            set.add(currentNum);
        	currentNum+=2;
           // System.out.println("set -->>"+set);
            //System.out.println("currentSum 11-->>"+currentSum);
        //System.out.println("currentNum 11-->>"+currentNum);
          //  System.out.println("--------------->>");
        	
        }
        
        //System.out.println("set -->>"+set);
       // System.out.println("diff -->>"+(finalSum-currentSum));
        if(currentSum==finalSum)
        {
        	List<Long> result = new ArrayList<Long>(set);
            return result;
        }
        else
        	set.remove(currentSum-finalSum);
        
        
        
        List<Long> result = new ArrayList<Long>(set);
        return result;
    }
}