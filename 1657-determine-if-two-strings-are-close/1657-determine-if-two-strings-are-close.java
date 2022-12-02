class Solution {
   public boolean closeStrings(String word1, String word2) {
		if(word1.length()!= word2.length())
			return false;
	   int[]count1 = new int[26];
	   int[]count2 = new int[26];
	   boolean[] check = new boolean[26];
	   for(int i = 0;i<word1.length();i++)
	   {
		   if(!check[word1.charAt(i)-'a'])
			   check[word1.charAt(i)-'a']=true;
		   count1[word1.charAt(i)-'a']++; 
	   }
	   for(int i = 0;i<word2.length();i++)
	   {
		   if(!check[word2.charAt(i)-'a'])
			   return false;
		   count2[word2.charAt(i)-'a']++; 
	   }
	   Arrays.sort(count1);
	   Arrays.sort(count2);
	   if(Arrays.equals(count1, count2))
		   return true;
	   
	   return false;
	}
}