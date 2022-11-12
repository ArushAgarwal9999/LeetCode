class MedianFinder {
	PriorityQueue<Integer> quee = new PriorityQueue<Integer>((a,b)->b-a);
	PriorityQueue<Integer> quee1 = new PriorityQueue<Integer>((a,b)->a-b);
    public MedianFinder() {
        
    }
    
    public void addNum(int num) {
        if(quee.isEmpty())
        {
        	quee.add(num);
        }
        else {
        	if(quee.peek()<num)
        	{
        		quee1.add(num);
        	}
        	else {
        		quee.add(num);
        	}
        }
        rebalanceQuee();
    }
    private void rebalanceQuee()
    {
    	if(quee1.size()>quee.size())
    	{
    		quee.add(quee1.poll());
    	}
    	else if (quee.size()>quee1.size()+1)
    	{
    		quee1.add(quee.poll());
    	}
         
    }
    
    public double findMedian() {
       
        if((quee.size()+quee1.size())%2==0)
        {
        	double result= quee.peek()+quee1.peek();
        	return result/2;
        	
        }
        return quee.peek();
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */