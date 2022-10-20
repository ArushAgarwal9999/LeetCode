class Solution {
    public String largestWordCount(String[] messages, String[] senders) {
        String result = "";
        int currentCount = 0;
        TreeMap<String, Integer> map = new TreeMap<String, Integer>();
        for(int i = 0;i<messages.length;i++)
        {
        	map.put(senders[i],map.getOrDefault(senders[i], 0)+messages[i].split(" ").length);
        }
        for(Map.Entry<String,Integer> entry:map.entrySet())
        {
        	if(currentCount<=entry.getValue())
        	{
        		currentCount = entry.getValue();
        		result =entry.getKey();
        	}
        }
        return result;
    }
}