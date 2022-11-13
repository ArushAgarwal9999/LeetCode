class Solution {
    public int findMinArrowShots(int[][] points) {
        int result = 0;
        PriorityQueue<int[]> quee = new PriorityQueue<int[]>((a,b)->Integer.compare(a[1],b[1]));
        for(int[]a:points)
        	quee.add(a);
        
          int currentMax  = Integer.MIN_VALUE;
        if(!quee.isEmpty())
        {
        	currentMax = quee.poll()[1];
        	result++;
        }
        while(!quee.isEmpty())
        {
        	int[] arr = quee.poll();
            //System.out.println("currentMax -->>"+currentMax);
              //System.out.println("arr[0] -->>"+Arrays.toString(arr));
        	if(currentMax<arr[0])
        	{
        		result++;
        		currentMax = arr[1];
        	}
        }
        
        return result;
    }
}