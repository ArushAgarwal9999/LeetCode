class Solution {
    public String reverseWords(String s) {
	String result = "";
	if(s.contains(" "))
	{
		String[] arr1 = s.split(" ");
		for(int i = arr1.length-1;i>-1;i--)
		{
			if(!arr1[i].isBlank())
			{
				System.out.println("arr1 -->>"+arr1[i]);
				if(i== 0)
				{
					
					result = result +arr1[i] ;
				}
				else {
					result = result + arr1[i] + " ";
				}
			}
		}
		return result.trim();
		
	}
	else {
		return s.trim();
	}
	
        
    }
}