class Solution {
    public int nthUglyNumber(int n) {
        long res = 0;
        int count = 0;
        TreeSet<Long> set = new TreeSet<Long>();
        set.add(1l);
        while(count!= n)
        {
        	 res=  set.pollFirst();
        	count++;
        	set.add(2*res);
        	set.add(3*res);
        	set.add(5*res);


        }
        
        
        return (int) res;
        
    }
}