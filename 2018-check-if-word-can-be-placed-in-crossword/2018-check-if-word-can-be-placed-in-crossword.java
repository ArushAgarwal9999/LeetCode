class Solution {
    public boolean placeWordInCrossword(char[][] board, String word) {
		
		StringBuffer word1 = new StringBuffer(word);
		String reverseWord = word1.reverse().toString();
       
		for(int i = 0;i<board.length;i++)
		{
			for(int j = 0;j<board[i].length;j++)
			{
				if(board[i][j]==' '|| board[i][j]==word.charAt(0))
				{
					if(canFitHorizonticaly(i, j, board, word))
						return true;
					if(canFitVertically(i, j, board, word))
						return true;
				}
				if(board[i][j]==' '|| board[i][j]==reverseWord.charAt(0))
				{
					if(canFitHorizonticaly(i, j, board, reverseWord))
						return true;
					if(canFitVertically(i, j, board, reverseWord))
						return true;
				}
			}
		}
		return false;
    }
	
	public boolean canFitHorizonticaly(int row,  int column,char[][] board,String word)
	{
		if(column-1>=0 && board[row][column-1] != '#')
			return false;
		if(column+word.length()<board[0].length && board[row][column+word.length()]!= '#')
			return false;
		for(int i = 0;i<word.length();i++)
		{
			if(column+i>=board[0].length)
				return false;
			if(board[row][column+i]!=' '&& board[row][column+i] != word.charAt(i))
				return false;
		}
		return true;
	}
	public boolean canFitVertically(int row,  int column,char[][] board,String word)
	{
		if(row-1>=0 && board[row-1][column] != '#')
			return false;
		if(row+word.length()<board.length && board[row+word.length()][column]!= '#')
			return false;
		for(int i = 0;i<word.length();i++)
		{
			if(row+i>=board.length)
				return false;
			if(board[row+i][column]!=' '&& board[row+i][column] != word.charAt(i))
				return false;
		}
		return true;
	}
	
}