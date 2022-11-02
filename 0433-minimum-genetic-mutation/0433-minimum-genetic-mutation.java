class Solution {
    public int minMutation(String start, String end, String[] bank) {
		 HashMap<String, Boolean> map = new HashMap<String, Boolean>();
		 for(String a:bank)
			 map.put(a, false);
		 
		 int res = getMinMutation(start, end, map,new HashMap<String, Integer>());
		 if(res>=100000)
	        return -1;
		 return res;
	    }
	 public int getMinMutation(String start, String end, HashMap<String, Boolean> map,HashMap<String, Integer> dp)
	 {
		 if(start.equals(end))
			 return 0;
		 
		 char[]ch = {'A', 'C', 'G', 'T'};
		 int result = 100000;
		 for(char c:ch)
		 {
			 char[] arr = start.toCharArray();
			 for(int i = 0;i<arr.length;i++)
			 {
				 if(arr[i] != c)
				 {
					 char temp = arr[i];
					 arr[i] = c;
					 String newStart = new String(arr);
					 if(map.containsKey(newStart) && !map.get(newStart))
					 {
						 map.put(newStart, true);
						 result = Math.min(getMinMutation(newStart, end, map,dp)+1, result);
						 
						 map.put(newStart, false);
						 
					 }
					 arr[i] = temp;
				 }
			 }
		 }
		dp.put(start,result);
		 
		 
		 
		 return  result;
	 }
}