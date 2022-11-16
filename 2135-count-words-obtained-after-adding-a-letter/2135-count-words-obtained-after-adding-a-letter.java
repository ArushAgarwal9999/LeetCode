class Solution {
   public int wordCount(String[] startWords, String[] targetWords) {
    int result = 0;
    HashSet<String> startWord = new HashSet<String>();
    HashSet<String> targetWord = new HashSet<String>();
    for(String a:startWords)
    {
    	char[] ch = a.toCharArray();
    	Arrays.sort(ch);
    	startWord.add(new String(ch));
    }
    for(String a:targetWords)
    {
    	char[] ch = a.toCharArray();
    	Arrays.sort(ch);
    	String word=  new String(ch);
    	for(int i =0;i<word.length();i++)
    	{
    		String searchWord = word.substring(0,i)+word.substring(i+1);
    		if(startWord.contains(searchWord))
    		{
    			result++;
    			break;
    		}
    	}
    }
   
    return result;
}
}    