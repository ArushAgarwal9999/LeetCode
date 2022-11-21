class Solution {
    public int minHeightShelves(int[][] books, int shelfWidth) {
        return getMax(0, books, shelfWidth,new Integer[books.length]);
    }

public int getMax(int index, int[][] books, int shelfWidth, Integer[] dp)
{
	if(index>=books.length)
		return 0;
	
	if(dp[index]!= null)
		return dp[index];
	int result =Integer.MAX_VALUE;
	int current = 0;
	int currentWidth = 0;
	for(int i = index;i<books.length;i++)
	{
		currentWidth += books[i][0];
		current  = Math.max(current, books[i][1]);
		if(currentWidth<=shelfWidth)
		{
			int ans = getMax(i+1, books, shelfWidth,dp);
			result = Math.min(result, current+ans);
		}
		else {
			break;
		}
		
	}
	
	return dp[index]= result;
	
}
}