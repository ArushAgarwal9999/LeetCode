class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int result = 0;
        int index = cardPoints.length-1;
        while(k>0)
        {
        	result+=cardPoints[index--];
            k--;
        }
        index++;
        int startindex = 0;
        int currentResult= result;
        while(index<cardPoints.length)
        {
        	currentResult+=cardPoints[startindex++];
        	currentResult-=cardPoints[index++];
        	result = Math.max(currentResult, result);
        }
        return result;
    }
}