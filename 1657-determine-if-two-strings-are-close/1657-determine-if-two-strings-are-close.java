class Solution {
    public boolean closeStrings(String word1, String word2) {
		if(word1.length()!= word2.length())
			return false;
	    HashMap<Character, Integer> map = new HashMap<Character, Integer>();
	    HashMap<Character, Integer> map2 = new HashMap<Character, Integer>();
	    for(int i = 0;i<word1.length();i++)
	    {
	    	map.put(word1.charAt(i), map.getOrDefault(word1.charAt(i), 0)+1);
	    	map2.put(word2.charAt(i), map2.getOrDefault(word2.charAt(i), 0)+1);
	    }
	   ArrayList<Integer> list = new ArrayList<Integer>(map.values());
	   ArrayList<Integer> list1 = new ArrayList<Integer>(map2.values());
	   Collections.sort(list);
	   Collections.sort(list1);
	    if(map.keySet().equals(map2.keySet()) && list.equals(list1))
	    	return true;
	    
		
		
		return false;
	}

}