class Solution {
    public boolean checkIfPangram(String sentence) {
        int[] charCount = new int[26];
        for(int i = 0;i<sentence.length();i++)
            charCount[sentence.charAt(i)-'a']++;
       
        
        for(int i = 0;i<charCount.length;i++)
        {
            if(charCount[i] == 0)
                return false;
        }
        
        
        return true;
        
    }
}