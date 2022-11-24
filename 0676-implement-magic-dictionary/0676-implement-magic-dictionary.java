class MagicDictionary {
	Tries tries = new Tries();
    public MagicDictionary() {
        
    }
    
    public void buildDict(String[] dictionary) {
        tries.insertWords(dictionary);
    }
    
    public boolean search(String searchWord) {
        char[] ch = searchWord.toCharArray();
        for(int i = 0;i<ch.length;i++)
        {
        	 for(char c = 'a';c<='z';c++)
             {
             	if(ch[i]!=c)
             	{
             		char temp = ch[i];
             		ch[i] = c;
             		if(tries.containsWord(new String(ch)))
             			return true;
             		
             		ch[i] = temp;
             	}
             }
        }
       
        return false;
    }
}
class Tries{
	Node root = new Node();
	
	public void insertWord(String word)
	{
		
		Node node = root;
		for(int i = 0;i<word.length();i++) {
			if(!node.contains(word.charAt(i)))
			{
				node.insert(word.charAt(i), new Node());
			}
			node = node.getNode(word.charAt(i));
		}
		node.isEnd= true;
		
	}
	public void insertWords(String[] dictionary)
	{
		for(String word:dictionary)
			insertWord(word);
	}
	public boolean containsWord(String word)
	{
		Node node = root;
		for(int i = 0;i<word.length();i++)
		{
			if(!node.contains(word.charAt(i)))
				return false;
			node= node.getNode(word.charAt(i));
		}
		if(node.isEnd)
			return true;
		
		return false;
	}
}
class Node{
	Node[] node = new Node[26];
	boolean isEnd = false;
	public void insert(char c, Node node)
	{
		this.node[c-'a'] = node;
	}
	public boolean contains(char c)
	{
		if(this.node[c-'a'] != null)
			return true;
		return false;
	}
	public Node getNode(char c)
	{
		return this.node[c-'a'];
	}
	
}
/**
 * Your MagicDictionary object will be instantiated and called as such:
 * MagicDictionary obj = new MagicDictionary();
 * obj.buildDict(dictionary);
 * boolean param_2 = obj.search(searchWord);
 */