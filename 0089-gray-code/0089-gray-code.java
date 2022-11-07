class Solution {
    public List<Integer> grayCode(int n) {
       List<String> res =getGrayCode(n);
        List<Integer> result = new ArrayList<Integer>();
        for(String a:res)
        {
            //System.out.println("a --->>"+a);
            result.add(Integer.parseInt(a,2));
        }
        return result;
    }
public List<String> getGrayCode(int n)
{
	if(n==1)
	{
		return new ArrayList<String>(Arrays.asList("0","1"));
	}
	List<String> res = getGrayCode(n-1);
	List<String> result = new ArrayList<String>();
	for(int i = 0;i<res.size();i++) {
		result.add( "0"+res.get(i));
	}
	for(int i = res.size()-1;i>=0;i--) {
		result.add("1"+res.get(i));
	}
	return result;
	
}
}