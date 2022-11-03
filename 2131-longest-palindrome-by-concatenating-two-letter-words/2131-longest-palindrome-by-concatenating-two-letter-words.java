class Solution {
    public int longestPalindrome(String[] words) {
        int result = 0;
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        for(String a:words)
        {
        	map.put(a, map.getOrDefault(a, 0)+1);
        }
        //System.out.println("map -->>"+map);
        for(Map.Entry<String, Integer> entru:map.entrySet())
        {
        	String reverse = new StringBuffer(entru.getKey()).reverse().toString();
        	if(map.containsKey(reverse))
        	{
        		if(reverse.equals(entru.getKey()))
            	{
            		int time = map.get(reverse)%2;
            		result+=((entru.getValue()-time)*entru.getKey().length());
            		map.put(reverse, time);
            	}
            	else {
            		int time = Math.min(entru.getValue(), map.get(reverse));
            		map.put(reverse, map.get(reverse)-time);
            		map.put(entru.getKey(), entru.getValue()-time);
            		result+=(time*entru.getKey().length()*2);
            		
            		
            	}
        	}
        	
        	
        }
        for(Map.Entry<String, Integer> entru:map.entrySet())
        {
        	if(entru.getValue()>0 && isPailndrom(entru.getKey()))
        	{
        		result+=entru.getKey().length();
        		break;
        	}
        }
        return result;
    }
	public boolean isPailndrom(String word)
	{
		int left= 0;
		int right = word.length()-1;
		while(left<right)
		{
			if(word.charAt(left) != word.charAt(right))
				return false;
			
			left++;
			right--;
		}
		return true;
	}
}