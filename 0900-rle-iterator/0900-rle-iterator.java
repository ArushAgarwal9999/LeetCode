class RLEIterator {
	class Pair{
		int count;
		int num;
		public Pair(int count, int num){
			this.count = count;
			this.num = num;
			
		}
	}
	Queue<Pair> quee = new LinkedList<>();
    public RLEIterator(int[] encoding) {
        for(int i = 0;i<encoding.length;i=i+2)
        {
        	
        	if(encoding[i]>0)
        	{
        		quee.add(new Pair(encoding[i], encoding[i+1]));
        	}
        }
    }
    
    public int next(int n) {
        while(!quee.isEmpty())
        {
        	if(quee.peek().count>=n)
        	{
        		quee.peek().count-=n;
        		if(quee.peek().count ==0)
        			return quee.poll().num;
        		else
        			return quee.peek().num;
        	}
        	else {
        		n-=quee.poll().count;
        	}
        }
    	return -1;
    }
}

/**
 * Your RLEIterator object will be instantiated and called as such:
 * RLEIterator obj = new RLEIterator(encoding);
 * int param_1 = obj.next(n);
 */