class Solution {
    public long makeIntegerBeautiful(long n, int target) {
        long copyN = n;
        long base = 1;
        while(sum(n)>target)
        {
            n=n/10+1;
            base = base*10;
        }
        return n*base-copyN;
        
        
    }
    private int sum(long n)
    {
        int res = 0;
        while(n>0)
        {
            res+=(n%10);
            n=n/10;
        }
        return res;
    }
}