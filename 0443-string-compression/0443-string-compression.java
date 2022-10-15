class Solution {
   public int compress(char[] chars) {
	//int result = 0;
	StringBuffer res = new StringBuffer();
	res.append(chars[0]+"");
	int count = 1;
	for(int i = 1;i<chars.length;i++)
	{
		if(chars[i-1] == chars[i])
			count++;
		else {
			if(count>1)
			{
				res.append(count+"");
				res.append(chars[i]+"");
			}
			else {
				res.append(chars[i]+"");
			}
			count = 1;
		}
		//System.out.println("res in loop -->>"+res.toString());
	}
	if(count>1)
		res.append(count);
       
      //String result = res.toString();
	for(int i = 1;i<res.length();i++)
	{
		chars[i] = res.charAt(i);
	}
	
	return res.length();
        
    }
}