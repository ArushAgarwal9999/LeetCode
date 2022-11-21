class Solution {
    public String longestWord(String[] words) {
	        Tries tries = new Tries();
	        tries.insertWords(words);
		 
		 return tries.getLongest(words);
	}
	 class Tries{
		
		 Node main = new Node();
		 
		 public void insertWords(String[] word)
		 {
			 for(String a:word)
				 insertWord(a);
		 }
		 public  void insertWord(String word)
		 {
			 Node root= main;
			 for(int i = 0;i<word.length();i++)
			 {
				 if(!root.contains(word.charAt(i)))
					 root.set(word.charAt(i), new Node());
				 root = root.get(word.charAt(i));
			 }
			 root.setIsEnd(true);
		 }
		 public String getLongest(String[] words)
		 {
			 String result = "";
			 for(String word:words)
			 {
				 if(isWordFormed(word))
				 {
                     //System.out.println("come in -->>");
					 if(result.length()<word.length())
					 {
						 result = word;
					 }
					 else if(result.length()== word.length())
					 {
						 if(result.compareTo(word)>0)
						 {
							 result = word;
						 }
					 }
				 }
			 }
			 
			 return result;
		 }
		public boolean isWordFormed(String word)
		 {
			 Node root = main;
			 for(char c:word.toCharArray())
			 {
				 if(root.contains(c))
				 {
					 root = root.get(c);
					 if(!root.getIsEnd())
						 return false;
				 }
				 else {
					 return false;
				 }
			 }
			 return true;
		 }
	 }
	 
	 
	class Node{
		Node[] node = new Node[26];
		boolean isEnd = false;
		
		public void set(char c, Node node)
		{
			this.node[c-'a'] = node;
		}
		public boolean contains(char c)
		{
			if(this.node[c-'a']!= null)
				return true;
			return false;
				
		}
		public Node get(char c)
		{
			return this.node[c-'a'];
		}
		public void setIsEnd(boolean isEnd)
		{
			this.isEnd = isEnd;
		}
		public boolean getIsEnd() {
			return this.isEnd;
		}
		
	}
}