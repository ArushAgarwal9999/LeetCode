class Solution {
    public int visiblePoints(List<List<Integer>> points, int angle, List<Integer> location) {
	List<Double> angles= new ArrayList<Double>();
	int result = 0;
	int minResult = 0;
	
		for(List<Integer>a:points)
		{
			int dx = a.get(0)-location.get(0);
			int dy = a.get(1)-location.get(1);
			if(dx==0&& dy==0)
			{
				minResult++;
				continue;
			}
				
			angles.add(Math.toDegrees(Math.atan2(dy, dx)));
		}
		
		Collections.sort(angles);
		List<Double> allAngles= new ArrayList<Double>(angles);
		for(Double d:angles)
			allAngles.add(d+360);
       // System.out.println("angel -->>"+allAngles);
		
		for(int l=0 ,r=0;l<allAngles.size();l++)
		{
			while(r<allAngles.size()&& allAngles.get(r)-allAngles.get(l)<=angle)
				r++;
			
			result = Math.max(result, r-l);
		}
        return result+minResult;
    }
}