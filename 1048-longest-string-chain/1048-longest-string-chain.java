class Solution {
   public int longestStrChain(String[] words) {
		 ArrayList<String> word=  new ArrayList<String>();
		 for(String a:words)
			 word.add(a);
		 Collections.sort(word, (a,b)->a.length()-b.length());
	        int result = 0;
	        int[] dp = new int[word.size()];
	        Arrays.fill(dp, 1);
	        for(int i = 0;i<word.size();i++)
	        {
	        	for(int j = 0;j<i;j++)
	        	{
	        		if(isEligible(word.get(j), word.get(i)) && dp[i]<dp[j]+1)
	        		{
	        			dp[i]= dp[j]+1;
	        		}
	        	}
	        	result = Math.max(result, dp[i]);
	        }
	        return result;
	    }
	 public boolean isEligible(String wordA, String wordB)
	 {
		 if(wordA.length()+1 != wordB.length())
			 return false;
		 int i = 0;
		 int j = 0;
		 while(i<wordA.length() && j<wordB.length())
		 {
			 if(wordA.charAt(i)==wordB.charAt(j))
			 {
				 i++;
				 j++;
			 }
			 else {
				 j++;
			 }
			 
		 }
		 if(i==wordA.length())
			 return true;
		 
		 return false;
	 }
}