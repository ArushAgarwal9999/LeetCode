class Solution {
    public void solve(char[][] board) {
        boolean[][] visited = new boolean[board.length][board[0].length];
        for(int i = 0;i<board.length;i++)
        {
        	if(board[i][0]=='O')
        	{
        		dfs(i, 0, visited, board);
        	}
        	if(board[i][board[0].length-1]=='O')
        	{
        		dfs(i, board[0].length-1, visited, board);
        	}
        }
        for(int i = 0;i<board[0].length;i++)
        {
        	if(board[0][i]=='O')
        	{
        		dfs(0, i, visited, board);
        	}
        	if(board[board.length-1][i]=='O')
        	{
        		dfs(board.length-1, i, visited, board);
        	}
        }
        for(int i = 0;i<board.length;i++)
        {
        	for(int j=0;j<board[0].length;j++)
        	{
        		if(board[i][j]=='O'&& visited[i][j]==false)
        			board[i][j] = 'X';
        	}
        }
    }
public void dfs(int i , int j, boolean[][] visited,char[][] board)
{
	if(i>=0&& i<board.length&& j>=0&& j<board[0].length  && board[i][j]=='O' && visited[i][j] == false)
	{
		visited[i][j] = true;
		dfs(i-1, j, visited, board);
		dfs(i+1, j, visited, board);
		dfs(i, j-1, visited, board);
		dfs(i, j+1, visited, board);
	}
	
}
}