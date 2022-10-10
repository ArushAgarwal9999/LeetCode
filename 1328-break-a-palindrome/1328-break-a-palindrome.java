class Solution {
    public String breakPalindrome(String s) {
        if(s.length()==1)
            return "";
        
        
        char[] ch = s.toCharArray();
        for(int i = 0;i<ch.length;i++)
        {
        	int right = ch.length-1-i;
        	if(i == right)
        		continue;
        	if(ch[i] != 'a')
        	{
        		ch[i] = 'a';
        		return new String(ch);
        	}
        }
        
         ch[ch.length-1] = 'b';
         return new String(ch);
        
    }
}