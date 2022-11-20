class Solution {
    public int countBattleships(char[][] board) {
        int result = 0;
        for(int i = 0;i<board.length;i++)
        {
        	for(int j = 0;j<board[i].length;j++)
        	{
        		if(board[i][j]=='X')
        		{
                    dfs(i, j, board);
        			result++;
        		}
        	}
        }
        return result;
    }
public void dfs(int row, int column, char[][] board)
{
	if(row<0|| row>=board.length|| column<0|| column>=board[0].length|| board[row][column]=='.')
		return ;
	board[row][column] = '.';
	dfs(row-1, column, board);
	dfs(row+1, column, board);
	dfs(row, column-1, board);
	dfs(row, column+1, board);
}
}