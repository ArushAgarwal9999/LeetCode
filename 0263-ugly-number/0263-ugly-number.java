class Solution {
    public boolean isUgly(int n) {
        if(n<=0)
            return false;
        while(n>1)
        {
           int temp = n;
            while(n>1&&n%5 == 0)
            {
                n=n/5;
            }
            while(n>1&&n%3 == 0)
            {
                n=n/3;
            }
            while(n>1&&n%2 == 0)
            {
                n=n/2;
            }
            if(n==temp)
                return false;
            
        }
        return true;
    }
}