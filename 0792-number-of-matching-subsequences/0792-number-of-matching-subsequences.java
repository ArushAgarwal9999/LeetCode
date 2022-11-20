class Solution {
    public int numMatchingSubseq(String s, String[] words) {
        int result = 0;
        HashMap<Character, Queue<String>> map = new HashMap<Character, Queue<String>>();
        for(String a:words)
        {
        	if(!map.containsKey(a.charAt(0)))
        		map.put(a.charAt(0), new LinkedList<String>());
            
            
        		map.get(a.charAt(0)).add(a);
        	
        }
        for(int i = 0;i<s.length();i++)
        {
            //System.out.println("map -->>"+map);
        	if(map.containsKey(s.charAt(i)))
        	{
        		Queue<String> quee = map.get(s.charAt(i));
        		int k = quee.size();
        		while(k>0)
        		{
                    k--;
        			String str = quee.poll();
        			if(str.length()==1)
        				result++;
        			else {
        				str = str.substring(1);
        				if(!map.containsKey(str.charAt(0)))
        					map.put(str.charAt(0), new LinkedList<String>());
        				map.get(str.charAt(0)).add(str);
        			}
        		}
        	}
            
        }
        
        return result;
    }
}