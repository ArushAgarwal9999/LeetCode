class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        List<String> result = new ArrayList<String>();
        HashMap<String,Integer> map = new HashMap<>();
        for(String a:words)
            map.put(a,map.getOrDefault(a,0)+1);
        
        PriorityQueue<Pair> quee= new PriorityQueue<Pair>(new Comparator<Pair>(){
            
            public int compare(Pair a, Pair b)
            {
                if(a.count != b.count)
                   return b.count-a.count;
               return  a.words.compareTo(b.words);
            }
        });
        
       for(Map.Entry<String, Integer> entry:map.entrySet())
       {
           Pair p =new Pair(entry.getKey(),entry.getValue());
           quee.add(p);
       }
        while(k>0 && quee.size()>0)
        {
            result.add(quee.poll().words);
            k--;
        }
        return result;
    }
    class Pair{
        String words;
        int count;
        public Pair(String words,int count)
        {
            this.words = words;
            this.count = count;
        }
    }
}