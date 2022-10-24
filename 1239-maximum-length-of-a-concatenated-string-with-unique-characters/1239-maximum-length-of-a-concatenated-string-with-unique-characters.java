class Solution {
    public int maxLength(List<String> arr) {
    return helper(0, arr, "", new HashMap<String, Integer>());
}
public int helper(int index, List<String> arr, String prev,HashMap<String, Integer> dp)
{
	if(index>= arr.size())
		return prev.length();
	
	String key = index+prev;
	if(dp.containsKey(key))
		return dp.get(key);
	
	int left = 0;
	int right = 0;
	if(canTake(prev,arr.get(index)))
	{
		left  = Math.max( helper(index+1, arr, prev+arr.get(index), dp),helper(index+1, arr, prev, dp) );
	}
	else {
		right =helper(index+1, arr, prev, dp);
	}
	
	
	dp.put(key, Math.max(left, right));
	return  Math.max(left, right);
		
	
}
    public boolean canTake(String a,String b)
    {
	HashSet<Character> set = new HashSet<>();
	for(char ch:a.toCharArray())
	{
		if(set.contains(ch))
			return false;
		
		set.add(ch);
	}
	
	for(char ch:b.toCharArray())
	{
		if(set.contains(ch))
			return false;
		set.add(ch);
	}
	return true;
}
}