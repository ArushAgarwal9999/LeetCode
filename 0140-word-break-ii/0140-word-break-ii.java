class Solution {
    public List<String> wordBreak(String s, List<String> wordDict) {
		List<String> result = new ArrayList<String>();
		dp(0,s,new HashSet<String>(wordDict),new StringBuffer(),result);
		
		return result;
	    
	}
	
	public void dp(int index, String s, HashSet<String> wordDict, StringBuffer prevStr, List<String> result)
	{
		if(index>=s.length())
		{
			//System.out.println("prev Str -->>"+prevStr.toString().trim());
			result.add(prevStr.toString());
			return ;
		}
		
		StringBuffer current = new StringBuffer();
		for(int i = index;i<s.length();i++)
		{
			current.append(s.charAt(i));
			if(wordDict.contains(current.toString()))
			{
                //System.out.println("current Str -->>"+current.toString().trim());
				StringBuffer st = new StringBuffer(prevStr);
                if(st.length()>0)
				st.append(" ");
				st.append(current.toString());
				dp(i+1, s, wordDict, st, result);
			}
		}
		
	}
}