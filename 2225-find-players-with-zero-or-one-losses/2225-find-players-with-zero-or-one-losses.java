class Solution {
    public List<List<Integer>> findWinners(int[][] matches) {
	List<List<Integer>> result = new ArrayList<List<Integer>>();
	TreeSet<Integer> set = new TreeSet<Integer>();
	result.add(new ArrayList<Integer>());
	result.add(new ArrayList<Integer>());
	HashMap<Integer, ArrayList<Integer>> loss =new HashMap<Integer, ArrayList<Integer>>();
	for(int[] a:matches)
	{
		set.add(a[0]);
		set.add(a[1]);
		if(!loss.containsKey(a[1]))
		{
			loss.put(a[1], new ArrayList<Integer>());
		}
		loss.get(a[1]).add(a[0]);
	}
		for(int a:set)
		{
			if(!loss.containsKey(a))
			{
				result.get(0).add(a);
			}
			else {
				if(loss.get(a).size()==1)
				{
					result.get(1).add(a);
				}
			}
		}
		return result;
    }
}