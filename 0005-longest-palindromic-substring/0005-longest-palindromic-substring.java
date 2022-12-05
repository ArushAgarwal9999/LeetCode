class Solution {
    public String longestPalindrome(String s) {
        String result = "";
        int maxLength = -1;
        for(int i = 0;i<s.length();i++)
        {
        	int l = i;
        	int r = i;
        	while(l>=0 && r<s.length() && s.charAt(l)==s.charAt(r))
        	{
        		if(maxLength<Math.abs(l-r))
        		{
        			maxLength = Math.abs(l-r);
        			result = s.substring(l,r+1);
        			
        		}
        		l--;
        		r++;
        	}
        	l = i;
        	r = i+1;
        	while(l>=0 && r<s.length() && s.charAt(l)==s.charAt(r))
        	{
        		if(maxLength<Math.abs(l-r))
        		{
        			maxLength = Math.abs(l-r);
        			result = s.substring(l,r+1);
        			
        		}
        		l--;
        		r++;
        	}
        }
        return result;
    }
}