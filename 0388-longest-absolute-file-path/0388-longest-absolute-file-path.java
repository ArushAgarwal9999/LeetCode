class Solution {
    public int lengthLongestPath(String input) {
        int result = 0;
        int[] size = new int[input.length()];
        for(String file :input.split("\n"))
        {
        	int countTab = countTab(file);
        	String fileName = file.substring(countTab);
        	size[countTab] = (countTab>0?size[countTab-1]+1:0)+fileName.length();
        	if(fileName.contains("."))
        	{
        		result = Math.max(result, size[countTab]);
        	}
        }
        return result;
    }
	public int countTab(String s)
	{
		int count = 0;
		int index = 0;
		while(s.charAt(index++)=='\t')
		{
			count++;
		}
		return count;
	}
}