class Solution {
    public String findReplaceString(String s, int[] indices, String[] sources, String[] targets) {
    StringBuffer result = new StringBuffer();
   HashMap<Integer, String> map = new HashMap<Integer, String>();
   HashMap<Integer, String> map1 = new HashMap<Integer, String>();     
   for(int i = 0;i<sources.length;i++) {
	   map.put(indices[i], sources[i]);
       map1.put(indices[i], targets[i]);
       
   }
    for(int i = 0;i<s.length();)
    {
        
         
    	if(map.containsKey(i) && isCheck(i, s, map.get(i)))
    	{
    		//result.append(map.get(i));
    		
            result.append(map1.get(i));
            if(map.get(i).length()>1)
                i+=(map.get(i).length());
            else
                i++;
             //System.out.println("i-->>"+i);
            //System.out.println("result11-->>"+result);
    	}
    	else {
    		result.append(s.charAt(i));
            i++;
    	}
        //System.out.println("result-->>"+result);
    }
    return result.toString();
}
public boolean isCheck(int i, String a, String b)
{
	int j = 0;
	while(i<a.length()&&j<b.length())
	{
        //System.out.println("a.charAt(i)-->>"+a.charAt(i));
        //System.out.println("b.charAt(j)-->>"+b.charAt(j));
		if(a.charAt(i) != b.charAt(j))
			return false;
		i++;
		j++;
	}
	return true;
}
}