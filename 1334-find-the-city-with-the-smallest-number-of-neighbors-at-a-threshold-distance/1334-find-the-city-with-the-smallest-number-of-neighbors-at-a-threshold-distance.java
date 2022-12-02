class Solution {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        int[][] distance = new int[n][n];
        for(int [] a:distance)
        	Arrays.fill(a, Integer.MAX_VALUE);
        for(int i = 0;i<edges.length;i++)
        {
        	distance[edges[i][0]][edges[i][1]] = edges[i][2];
        	distance[edges[i][1]][edges[i][0]] = edges[i][2];
        }
        for(int i = 0;i<n;i++)
        	distance[i][i]=0;
        
        for(int via = 0;via<n;via++)
        {
        	for(int i =0 ;i<distance.length;i++)
        	{
        		for(int j = 0;j<distance[i].length;j++)
        		{
        			if(distance[i][via]==Integer.MAX_VALUE || distance[via][j]==Integer.MAX_VALUE)
        				continue;
        			distance[i][j] = Math.min(distance[i][j], (distance[i][via]+distance[via][j]));
        			
        		}
        	}
        }
        int result = 0;
        int minCity = Integer.MAX_VALUE;
        for(int i = 0;i<n;i++)
        {
            //System.out.println("ar -->>"+Arrays.toString(distance[i]));
        	int count = 0;
        	for(int j =0;j<n;j++)
        	{
        		if(i != j)
        		{
        			if(distance[i][j] <=distanceThreshold)
        				count++;
        		}
        	}
        	if(minCity>=count)
        	{
        		minCity = count;
        		result = i;
        	}

        }
        
        return result;
    }

}