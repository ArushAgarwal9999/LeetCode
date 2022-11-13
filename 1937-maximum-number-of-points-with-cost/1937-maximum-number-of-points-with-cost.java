class Solution {
    public long maxPoints(int[][] points) {
		long max = 0;
		long[] maxScore = new long[points[0].length];
		for(int i =0;i<points[0].length;i++)
		{
			maxScore[i] = points[0][i];
		}
        optimizeScore(maxScore);
		for(int i = 1;i<points.length;i++)
		{
			for(int j = 0;j<points[i].length;j++)
			{
				maxScore[j]+=points[i][j];
			}
			optimizeScore(maxScore);
		}
		for(long a:maxScore)
			max=Math.max(a, max);
			
       return max;
    }
	public void optimizeScore(long[] maxScore)
	{
		for(int i =1;i<maxScore.length;i++)
		{
			maxScore[i] = Math.max(maxScore[i], maxScore[i-1]-1 );
		}
		for(int i =maxScore.length-2;i>=0;i--)
		{
			maxScore[i] = Math.max(maxScore[i], maxScore[i+1]-1);
		}
	}
}