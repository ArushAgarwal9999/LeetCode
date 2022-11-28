class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
	
	
		HashSet<String> word = new HashSet<String>(wordList);
		if(!word.contains(endWord))
			return 0;
		
		int count=1;
		Queue<String> quee= new LinkedList<String>();
		quee.add(beginWord);
		
		while(!quee.isEmpty())
		{
			int size=quee.size();
			while(size>0)
			{
				size--;
				String temp = quee.poll();
				if(temp.equals(endWord))
					return count;
				
				char[] ch = temp.toCharArray();
				for(int i = 0;i<ch.length;i++)
				{
					for(char a='a';a<='z';a++)
					{
						if(ch[i] != a)
						{
							char tmp = ch[i];
							ch[i] = a;
							String newWord = new String(ch);
							if(word.contains(newWord))
							{
								quee.add(newWord);
								word.remove(newWord);
							}
							ch[i] = tmp;
						}
					}
					
				}
			}
			count++;
		}
		
		
		
        return 0;
    }

}