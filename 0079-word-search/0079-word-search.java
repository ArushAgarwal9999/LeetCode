class Solution {
    public boolean exist(char[][] board, String word) {
     for(int i = 0;i<board.length;i++)
     {
    	 for(int j = 0;j<board[i].length;j++)
    	 {
    		 if(dfs(0, i, j, board, word, new Boolean[board.length][board[0].length]))
    			 return true;
    	 }
     }
	
	return false;
    }
public boolean dfs(int index, int row, int column, char[][] board, String word,  Boolean[][] visited)
{
	if(index>=word.length())
    {
        return true;
        
    }
   
		
	if(row<0||row>=board.length||column<0||column>=board[0].length|| visited[row][column]!= null || word.charAt(index)!=board[row][column])
		return false;
	
   
        visited[row][column] = true;
	if(dfs(index+1, row-1, column, board, word, visited)||dfs(index+1, row+1, column, board, word, visited)||dfs(index+1, row, column-1, board, word, visited)||dfs(index+1, row, column+1, board, word, visited))
	{
		visited[row][column] = null;
		return true;
	}
	    visited[row][column] = null;
    
	
	return false;
	
}

}