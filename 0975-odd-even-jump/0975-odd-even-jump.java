import java.util.Map.Entry;
class Solution {
    public int oddEvenJumps(int[] arr) {
        TreeMap<Integer, Integer>map = new TreeMap<Integer, Integer>();
        map.put(arr[arr.length-1], arr.length-1);
        int[] odd = new int[arr.length];
        int[] even = new int[arr.length];
        odd[odd.length-1] = -1;
        even[even.length-1] = -1;
        
        for(int i =arr.length-2;i>=0;i--)
        {
        	//System.out.println("arr[i] -->>"+arr[i]);
        	Entry<Integer, Integer>oddEntry =map.ceilingEntry(arr[i]); 
        	Entry<Integer, Integer>evenEntry =map.floorEntry(arr[i]); 
            //System.out.println("oddEntry -->>"+oddEntry);
             //System.out.println("evenEntry -->>"+evenEntry);
        	if(oddEntry==null)
        	{
        		odd[i] = -1;
        	}
        	else {
        		odd[i] = oddEntry.getValue();
        	}
        	if(evenEntry == null)
        	{
        		even[i] = -1;
        	}
        	else {
        		even[i] = evenEntry.getValue();
        	}
        	
        	map.put(arr[i], i);
        }
       // System.out.println("odd -->>"+Arrays.toString(odd));
        //System.out.println("even -->>"+Arrays.toString(even));
        int result = 1;
        Integer[][] dp = new Integer[arr.length][2];
        for(int i  =0;i<arr.length-1;i++)
        {
            int res =getMax(i, 1, odd, even, dp);
             //System.out.println("i -->>"+i);
            //System.out.println("res -->>"+res);
              
        	result+= res;
        }
        return result;
        	
	
    }
	public int getMax(int index, int jump,  int[] odd , int[] even ,Integer[][] dp)
	{
		if(index>=odd.length-1)
		{
			return 1;
		}
		if(dp[index][jump]!= null)
			return dp[index][jump];
		
		int sum = 0;
		
		if(jump%2 != 0)
		{
			
			if(odd[index]!=-1)
				sum =  getMax(odd[index], 0, odd, even, dp);
            else
                return 0;
			
		}
		else {
			if(even[index] != -1)
				sum =  getMax(even[index], 1, odd, even, dp);
            else
                return 0;
		}
		return sum;
	}
}