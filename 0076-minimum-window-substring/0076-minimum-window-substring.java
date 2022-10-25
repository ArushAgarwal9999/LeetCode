class Solution {
    public String minWindow(String s, String t) {
    String result = "";
    int resultCount = Integer.MAX_VALUE;
    HashMap<Character, Integer> map = new HashMap<Character, Integer>();
    for(char a:t.toCharArray())
    	map.put(a, map.getOrDefault(a, 0)+1);
    
    int i = 0;
    int j = 0;
    int currentCount = 0;
    HashMap<Character, Integer> currentMap = new HashMap<Character, Integer>();
    while(i<s.length()|| (j<s.length() && currentCount == t.length()))
    {
    	
    	
    	if(currentCount == t.length() && j<s.length())
    	{
            char ch1 = s.charAt(j);
    			if(currentMap.containsKey(ch1))
    			{
    				if(currentMap.get(ch1) == 1)
    				{
    					currentMap.remove(ch1);
    					currentCount--;
    				}
    				else {
    					currentMap.put(ch1, currentMap.get(ch1)-1);
    					if(currentMap.get(ch1)<map.get(ch1))
    						currentCount--;
    				}
    				
    			}
            j++;
    	}
    	else if(i<s.length()) {
            char ch = s.charAt(i);
    		if(map.containsKey(s.charAt(i)))
    		{
    			currentMap.put(ch, currentMap.getOrDefault(ch, 0)+1);
    			if(currentMap.get(ch)<= map.get(ch))
    			{
    				currentCount++;
    			}
    		}
    		
    		i++;
    	}
       //System.out.println("currentCount -->"+currentCount);
      //  System.out.println("i -->"+i);
      //  System.out.println("j -->"+j);
    	if(currentCount == t.length())
    	{
            // System.out.println("currentSubstring -->"+s.substring(j, i));
    		if(resultCount>(i-j))
    		{
    			resultCount = (i-j);
    			result = s.substring(j, i);
    		}
    	}
         
        //System.out.println("resultCount -->"+resultCount);
       //  System.out.println("result -->"+result);
       //  System.out.println("------------->");
    	
    	
    	
    }
    return result;
}
}