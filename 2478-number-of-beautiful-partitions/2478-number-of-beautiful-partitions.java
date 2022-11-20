class Solution {
    public int beautifulPartitions(String s, int k, int minLength) {
        return getMax(s, k, minLength, 0, new Integer[s.length()][k+1]);
    }
public int getMax(String s, int k, int minLength,int index,Integer[][] dp)
{
	if(k>1 && index>=s.length())
		return 0;
	if(k==1)
	{
		if(s.length()-index<minLength)
		{
			return 0;
		}
        int last = s.length()-1;
        if(s.charAt(last)=='2'|| s.charAt(last)=='3'||s.charAt(last)=='5'|| s.charAt(last)=='7')
                    return 0;
		if(s.charAt(index)=='2'|| s.charAt(index)=='3'||s.charAt(index)=='5'|| s.charAt(index)=='7')
		{
			return 1;
		}
		else
			return 0;
	}
	if(dp[index][k]!= null)
		return dp[index][k]%1000000007;
	if(s.charAt(index)=='2'|| s.charAt(index)=='3'||s.charAt(index)=='5'|| s.charAt(index)=='7')
	{
		int res = 0;
		for(int i = index+minLength-1;i<(s.length()-((k-1)*minLength));i++)
		{
			
                if(s.charAt(i)=='2'|| s.charAt(i)=='3'||s.charAt(i)=='5'|| s.charAt(i)=='7')
                    continue;
				res+=(getMax(s, k-1, minLength, i+1,dp));
				res = res%1000000007;
					
		}
		return dp[index][k]=res;
	}
	else {
		return dp[index][k]= 0;
	}
	
	
	
}

}