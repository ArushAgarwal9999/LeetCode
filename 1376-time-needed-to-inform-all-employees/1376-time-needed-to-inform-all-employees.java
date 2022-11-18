class Solution {
   public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
//	        int result = 0;
//	        boolean[] visited = new boolean[n+1];
	        HashMap<Integer, ArrayList<Integer>> map = new HashMap<Integer, ArrayList<Integer>>();
	        for(int i=0;i<manager.length;i++)
	        {
	        	if(!map.containsKey(manager[i]))
	        	{
	        		map.put(manager[i], new ArrayList<Integer>());
	        	}
	        	map.get(manager[i]).add(i);
	        }
	      //  visited[headID] = true;
	        
	        return dfs(headID, informTime, map);
	    }
	 public int dfs(int headId,int[] informTime,HashMap<Integer, ArrayList<Integer>> map)
	 {
		 int max  =0;
		 if(map.containsKey(headId))
		 {
			 for(int a:map.get(headId))
			 {
				 max = Math.max(dfs(a, informTime, map), max);
			 }
		 }
		 
		 
		 return max+informTime[headId];
	 }
}