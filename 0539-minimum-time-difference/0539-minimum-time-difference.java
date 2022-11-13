class Solution {
    public int findMinDifference(List<String> timePoints) {
        int result = 0;
        int[] times = new int[timePoints.size()];
        int i = 0;
        for(String s:timePoints)
        {
        	String[] arr = s.split(":");
        	int totalTime = (Integer.parseInt(arr[0])*60)+Integer.parseInt(arr[1]);
        	times[i++] = totalTime;
        }
        Arrays.sort(times);
        //System.out.println(Arrays.toString(times));
        result = 1440+times[0]-times[times.length-1];
        for(i =1;i<times.length;i++)
        {
        	result = Math.min(result, Math.abs(times[i]-times[i-1]));
        }
        return result;
    }
}