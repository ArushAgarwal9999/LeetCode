class Solution {
          public String mostCommonWord(String paragraph, String[] banned) {
                    HashSet<String> bannedSet = new HashSet<>();
                for(String word:banned)
                    bannedSet.add(word.toLowerCase());
                 paragraph = paragraph.replaceAll("[!?',;.]"," ");
        String [] words = paragraph.split(" ");
        HashMap<String,Integer> map = new HashMap<>();
        String result = "";
        int mostFrequancy=0;
       // System.out.println("paragraph -->>"+paragraph);
        //System.out.println("words -->>"+Arrays.toString(words));
        for(String word:words)
        {
             word = word.toLowerCase().trim();
            word= word.trim();
            if(bannedSet.contains(word) || word.trim().isEmpty())
                continue;
           
           // System.out.println("word -->>"+word);
            
            map.put(word,map.getOrDefault(word,0)+1);
            if(mostFrequancy<map.get(word))
            {
            mostFrequancy = map.get(word);
        result = word;	
            }
        }
        return result;


            }

}