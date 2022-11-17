class Solution {
   class Pair{
		int num;
		int power;
		public Pair(int num, int power) {
			super();
			this.num = num;
			this.power = power;
		}
	}
public int getKth(int lo, int hi, int k) {
	HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
	PriorityQueue<Pair>quee = new PriorityQueue<Pair>((a,b)->(a.power==b.power)?(a.num-b.num):a.power-b.power);
        int result  = 0;
        
        for(int i = lo;i<=hi;i++)
        {
        	dfs(i, map);
        	quee.add(new Pair(i,map.get(i)));
        }
        while(k>1)
        {
        	quee.poll();
        	k--;
        }
        return quee.peek().num;
    }
public int dfs(int num, HashMap<Integer, Integer> map)
{
	if(num==1)
	{
        map.put(num, 0);
		return 0;
	}
   /// System.out.println("num-->"+num);
	if(map.containsKey(num))
		return map.get(num);
	
	if(num%2==0)
	{
		int res = dfs(num/2, map)+1;
		map.put(num, res);
        return res;
	}
        int res = dfs((3*num)+1, map)+1;
	map.put(num, res);
	return res;
	
	
}

}