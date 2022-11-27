class Solution {
   public int bestClosingTime(String customers) {
	        int result = 0;
	        int totalOpen = 0;
	        int currentOpen = 0;
	        int currentClose = 0;
	        int max = Integer.MAX_VALUE;
	        for(char c :customers.toCharArray())
	        {
	        	if(c=='Y')
	        		totalOpen++;
	        }
	        int count = 0;
	        for(char c :customers.toCharArray())
	        {
	        	int curretPanelty = totalOpen-currentOpen+currentClose;
	        	if(curretPanelty<max)
	        	{
	        		max = curretPanelty;
	        		result = count;
	        	}
	        	if(c=='Y')
	        		currentOpen++;
	        	else
	        		currentClose++;
	        	
	        	count++;
	        }
	        int curretPanelty = totalOpen-currentOpen+currentClose;
	        if(curretPanelty<max)
	        	return customers.length();
	        
	        return result;
	    }
}