class Solution {
    public boolean exist(char[][] board, String word) {
	for(int i = 0;i<board.length;i++)
	{
		for(int j = 0;j<board[i].length;j++)
		{
			if(board[i][j]==word.charAt(0))
			{
				if(dfs_findWord(i, j, 0, new Boolean[board.length][board[0].length], board, word))
					return true;
			}
		}
	}
        return false;
    }
public boolean dfs_findWord(int i, int j, int index, Boolean [][] visited,char[][] board,String word)
{
	if(index>=word.length())
		return true;
	if(i<0||i>=board.length || j<0|| j>=board[0].length || visited[i][j] != null)
		return false;
	
	if(word.charAt(index) != board[i][j])
		return false;
	
	visited[i][j]= true;
	
	if (dfs_findWord(i+1, j, index+1, visited, board, word) || dfs_findWord(i-1, j, index+1, visited, board, word) || dfs_findWord(i, j+1, index+1, visited, board, word)|| dfs_findWord(i, j-1, index+1, visited, board, word))
	{
		visited[i][j]= null;
		return true;
	}
    visited[i][j]= null;
	return false;
}
}