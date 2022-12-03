class Solution {
   public String frequencySort(String s) {
    		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
    		for(int i = 0;i<s.length();i++)
    		{
    			map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0)+1);
    		}
    		
           PriorityQueue<Data> quee = new PriorityQueue<Data>(new Comparator<Data>() {
        	   @Override
        	   public int compare(Data d1, Data d2)
        	   {
        		   if(d1.count!= d2.count)
        		   {
        			   return d2.count-d1.count;
        		   }
        		  return d1.ch-d2.ch;
        	   }
		});
            
            for(Map.Entry<Character, Integer> entry:map.entrySet())
            {
            	quee.add(new Data(entry.getKey(),entry.getValue()));
            }
            StringBuffer result = new StringBuffer();
            
            while(!quee.isEmpty())
            {
            	Data data = quee.poll();
            	int size = data.count;
            	while(size>0)
            	{
            		result.append(data.ch);
            		size--;
            	}
            	
            }
            
            return result.toString();
        }
    	class Data{
    		char ch;
    		int count;
    		public Data(char ch, int count)
    		{
    			this.ch = ch;
    			this.count = count;
    		}
    	}
}