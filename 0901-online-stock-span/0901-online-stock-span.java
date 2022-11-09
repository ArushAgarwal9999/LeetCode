class StockSpanner {
	int index=0;
	Stack<Pair> stack = null;
    public StockSpanner() {
        stack = new Stack<StockSpanner.Pair>();
    }
    
    public int next(int price) {
        index ++;
    	//stack.add(new Pair(price, index++));
    	while(!stack.isEmpty() && stack.peek().price<=price)
    	{
    		stack.pop();
    	}
       // System.out.println("stack -->>"+stack);
    	int result = 0;
    	if(stack.isEmpty())
    		result =  index;
        else
    	    result = index-stack.peek().index;
        //System.out.println("result -->>"+result);
    	stack.add(new Pair(index, price));
    	return result;
    	
    	
    	
        
    }
    class Pair{
    	int index;
    	int price;
    	public Pair(int index,int price)
    	{
    		this.index = index;
    		this.price = price;
    	}
    }
}
/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */