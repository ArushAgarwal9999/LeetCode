class Solution {
    public List<String> findAllConcatenatedWordsInADict(String[] words) {
		List<String> result = new ArrayList<String>();
		Tries tries = new Tries();
		tries.addWords(words);
		for(String a:words)
		{
           // System.out.println("a -->>"+a);
			if(tries.find(0, a, 0))
				result.add(a);
		}
			
		
		return result;
    }
	
	class Tries{
		Node root = new Node();
		public void addWord(String word)
		{
			Node current = root;
			for(int i = 0;i<word.length();i++)
			{
				if(current.get(word.charAt(i))==null)
					current.insert(word.charAt(i), new Node());
				current = current.get(word.charAt(i));
			}
            current.isEnd = true;
			
		}
		public void addWords(String[] word)
		{
			for(String a:word)
				addWord(a);
			
		}
		public boolean isWordPresent(String word)
		{
			Node temp = root;
			for(int i = 0;i<word.length();i++)
			{
				if(temp.contains(word.charAt(i)))
				{
					temp = temp.get(word.charAt(i));
				}
				else {
					return false;
				}
			}
			
			return temp.isEnd;
			
		}
		public boolean find(int index ,String word, int count)
		{
			if(index>=word.length())
			{
                //System.out.println("count -->>"+count);
				if(count>1)
					return true;
				return false;
			}
				
			for(int i = index+1;i<word.length()+1;i++)
			{
				String str = word.substring(index, i);
				//System.out.println("str -->>"+str);
				if(isWordPresent(str) && find(i, word, count+1))
					return true;
			}
			return false;
		}
	}
	
	class Node{
		Node[] node = new Node[26];
		boolean isEnd = false;
		
		public void insert(char ch, Node node)
		{
			this.node[ch-'a']=node;
		}
		public boolean contains(char ch)
		{
			if(this.node[ch-'a']!= null)
				return true;
			
			return false;
		}
		public Node get(char ch)
		{
			return this.node[ch-'a'];
		}
	}
}