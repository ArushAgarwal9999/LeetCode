class Solution {
    public String orderlyQueue(String s, int k) {
	char[] arr = s.toCharArray();
	if(k>1)
	{
		Arrays.sort(arr);
		return new String(arr);
	}
	else {
		String ans = s;
		for(int i = 0;i<arr.length;i++)
		{
			String newS = getChange(arr);
			if(ans.compareTo(newS)>0)
				ans = newS;
		}
		return ans;
	}
        
    }
public String getChange(char[] ch)
{
	char temp = ch[0];
	for(int i = 1;i<ch.length;i++)
	{
		ch[i-1] =ch[i];
	}
	ch[ch.length-1] = temp;
	return new String(ch);
}
}