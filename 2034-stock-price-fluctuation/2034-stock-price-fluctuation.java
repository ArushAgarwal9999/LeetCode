class StockPrice {
	class Pair{
		int timeStamp;
		int price;
		public Pair(int timeStamp, int price)
		{
			this.timeStamp = timeStamp;
			this.price = price;
		}
	}
	 HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
     PriorityQueue<Pair> maxQuee = new PriorityQueue<StockPrice.Pair>((a,b)->b.price-a.price);
     PriorityQueue<Pair> minQuee = new PriorityQueue<StockPrice.Pair>((a,b)->a.price-b.price);
     int maxTime = 0;
    public StockPrice() {
       
    }
    
    public void update(int timestamp, int price) {
        maxTime  = Math.max(timestamp, maxTime);
        map.put(timestamp, price);
        maxQuee.add(new Pair(timestamp, price));
        minQuee.add(new Pair(timestamp, price));
    
    }
    
    public int current() {
        return map.get(maxTime);
    }
    
    public int maximum() {
        while(maxQuee.peek().price!= map.get(maxQuee.peek().timeStamp))
        	maxQuee.poll();
        return maxQuee.peek().price;
    }
    
    public int minimum() {
    	 while(minQuee.peek().price!= map.get(minQuee.peek().timeStamp))
    		 minQuee.poll();
         return minQuee.peek().price;
        
    }
}
/**
 * Your StockPrice object will be instantiated and called as such:
 * StockPrice obj = new StockPrice();
 * obj.update(timestamp,price);
 * int param_2 = obj.current();
 * int param_3 = obj.maximum();
 * int param_4 = obj.minimum();
 */