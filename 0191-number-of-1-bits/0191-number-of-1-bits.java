public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
       int count = 0;
        while(n!= 0)
        {
            int resm = n&-n;
            n=n-resm;
            count++;
        }
        return count;
    }
}