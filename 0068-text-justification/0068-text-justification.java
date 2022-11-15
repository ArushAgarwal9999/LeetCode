class Solution {
   public List<String> fullJustify(String[] words, int maxWidth) {
        
	List<String>  result = new ArrayList<String>();
	for(int i = 0;i<words.length;)
	{
		ArrayList<String> arr = new ArrayList<String>();
		int currentCount = words[i].length();
		arr.add(words[i++]);
		
		while(i<words.length && currentCount+words[i].length()+1<=maxWidth)
		{
			currentCount+=(+words[i].length()+1);
			arr.add(words[i++]);
			
		}
		int numberSpace = arr.size()-1;
		int remaingSpace= (maxWidth-currentCount+numberSpace);
		int atLeastSpace = (numberSpace==0)?0:(remaingSpace/numberSpace);
		int extraSpace = (numberSpace==0)?0:(remaingSpace%numberSpace);
		if(i==words.length)
		{
			atLeastSpace = 1;
			extraSpace = 0;
		}
		StringBuffer word = new StringBuffer();
		
		for(int j = 0;j<arr.size();j++)
		{
			word.append(arr.get(j));
			if(j==arr.size()-1)
				break;
			for(int space = 0;space<atLeastSpace;space++)
			{
				word.append(" ");
			}
			if(extraSpace>0)
			{
				word.append(" ");
				extraSpace--;
			}
			
        }
		while(word.length()<maxWidth)
		{
			word.append(" ");
		}
        
		result.add(word.toString());
		
	}
	return result;







}
}