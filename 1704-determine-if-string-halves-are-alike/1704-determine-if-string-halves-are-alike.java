class Solution {
    public boolean halvesAreAlike(String s) {
       int count = 0;
        HashSet<Character> set = new HashSet<Character>();
        set.add('a');
        set.add('e');
        set.add('i');
        set.add('o');
        set.add('u');
        set.add('A');
        set.add('E');
        set.add('I');
        set.add('O');
        set.add('U');
        for(int i = 0;i<s.length()/2;i++)
        {
        	if(set.contains(s.charAt(i)))
        		count++;
        }
        for(int i = s.length()/2;i<s.length();i++)
        {
        	if(set.contains(s.charAt(i)))
        		count--;
        }
        return count==0;
    }
	
}