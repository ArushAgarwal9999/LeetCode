class Solution {
	public List<String> findWords(char[][] board, String[] words) {
    	Tries t = new Tries();
        t.insertWords(words);
    	return t.findWords(board, words);
    	
        
    }
}
class Tries{
	
	Node root = new Node();
	List<String> result = new ArrayList<String>();
	public void insertWord(String word)
	{
		Node temp = root;
		for(int i = 0;i<word.length();i++)
		{
			if(!temp.contains(word.charAt(i)))
				temp.put(word.charAt(i), new Node());
			
			temp = temp.getNode(word.charAt(i));
		}
		temp.isEnd = true;
		temp.word = word;
	}
	public void insertWords(String[] words)
	{
		for(String word:words)
			insertWord(word);
	}
	public List<String> findWords(char[][] board, String[] words) {
    	for(int i = 0;i<board.length;i++)
    	{
    		for(int j = 0;j<board[i].length;j++)
    		{
    			if(this.root.contains(board[i][j]))
    			{
    				dfs(i, j, board, new Boolean[board.length][board[0].length], root);
    			}
    		}
    	}
    	return result;
        
    }
	public void dfs(int row, int column, char[][] board, Boolean[][] visited, Node node)
	{
		if(node.isEnd)
		{
            node.isEnd = false;
			//System.out.println(node.word);
			//if(!result.contains(node.word))
				result.add(node.word);
			
			//return;
			
		}
		if(row<0 || row>= board.length || column<0 || column>= board[0].length || visited[row][column] != null)
			return;
		visited[row][column] = true;
		if(node.contains(board[row][column]))
		{
			dfs(row+1, column, board, visited, node.getNode(board[row][column]));
			dfs(row-1, column, board, visited, node.getNode(board[row][column]));
			dfs(row, column+1, board, visited, node.getNode(board[row][column]));
			dfs(row, column-1, board, visited, node.getNode(board[row][column]));
		}
		visited[row][column] = null;
		
		
		
	}
	
	
	
}
class Node{
	Node[] node = new Node[26];
	boolean isEnd = false;
	String word;
	
	public void put(char c, Node n)
	{
		this.node[c-'a'] = n;
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
	
	public void setEnd(boolean isEnd)
	{
		this.isEnd = isEnd;
	}
	public boolean getEnd() {
		return this.isEnd;
	}
}
