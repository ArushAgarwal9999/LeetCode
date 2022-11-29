class Solution {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
	List<List<String>> result = new ArrayList<List<String>>();
	HashSet<String> word = new HashSet<String>(wordList);
	if(!word.contains(endWord))
		return result;
	HashMap<String, Integer> worldLevelMap = new HashMap<String, Integer>();
	int level = minLevel(beginWord, endWord, word, worldLevelMap);
	//System.out.println("world map -->>"+worldLevelMap);
	ArrayList<String> arr = new ArrayList<String>();
	arr.add(endWord);
	dfs(endWord, beginWord, level, worldLevelMap, arr, result);
	return result;
        
    }
public void dfs(String endWord, String beginWord, int level, HashMap<String, Integer> worldLevelMap, List<String> current,List<List<String>> result)
{
	if(endWord.equals(beginWord)&& level==0)
		{
			ArrayList<String> res = new ArrayList<String>();
			for(int i = current.size()-1;i>=0;i-- )
				res.add(current.get(i));
			//System.out.println("current -->>"+current);
			result.add(res);
			return;
		}
	for(int i = 0;i<endWord.length();i++)
	{
		for(char ch = 'a';ch<='z';ch++)
		{
			if(endWord.charAt(i)!= ch)
			{
				char[] arr= endWord.toCharArray();
				arr[i] = ch;
				String s = new String(arr);
                // System.out.println("s    11-->>"+s);
				if(worldLevelMap.containsKey(s)&& worldLevelMap.get(s)==level-1)
				{
                   // System.out.println("s -->>"+s);
					current.add(s);
					dfs(s, beginWord, level-1, worldLevelMap, current, result);
					current.remove(current.size()-1);
				}
			}
		}
	}
}
public int minLevel(String beginWord, String endWord, HashSet<String> word,HashMap<String, Integer> worldLevelMap)
{
	Queue<String> quee = new LinkedList<String>();
	quee.add(beginWord);
	worldLevelMap.put(beginWord, 0);
	int level = 0;
	word.remove(beginWord);
	while(!quee.isEmpty())
	{
		++level;
        // System.out.println("level -->>"+level);
         //System.out.println("quee -->>"+quee);
		int size = quee.size();
		while(size>0)
		{
			size--;
			String s = quee.poll();
			if(s.equals(endWord))
			{
				//worldLevelMap.put(s, level);
				return level-1;
			}
			for(int i = 0;i<s.toCharArray().length;i++)
			{
				for(char ch = 'a';ch<='z';ch++)
				{
					if(s.charAt(i)!= ch)
					{
						char[] arr = s.toCharArray();
						arr[i] = ch;
						String str = new String(arr);
						if(word.contains(str))
						{
							worldLevelMap.put(str, level);
							word.remove(str);
							quee.add(str);
						}
						
					}
				}
			}
			
		}
		
	}
	return 0;
}

}