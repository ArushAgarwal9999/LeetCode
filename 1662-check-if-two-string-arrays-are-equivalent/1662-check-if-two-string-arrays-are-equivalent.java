class Solution {
    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        StringBuffer s1 = new StringBuffer();
        StringBuffer s2 = new StringBuffer();
        for(String a:word1)
            s1.append(a);
        for(String a:word2)
            s2.append(a);
        
        if(s1.toString().equals(s2.toString()))
            return true;
        return false;
    }
}