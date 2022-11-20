class Solution {
   public int numberOfWeakCharacters(int[][] properties) {
	        int result = 0;
	        Arrays.sort(properties,  (a,b)-> (a[0]==b[0]?b[1]-a[1]:a[0]-b[0]));
	        int max = properties[properties.length-1][1];
	         for(int i =properties.length-1;i>=0;i--)
	        {
	        	if(max>properties[i][1])
	        		result++;
	        	else
	        		max = properties[i][1];
	        }
	        return result;
	    }
}