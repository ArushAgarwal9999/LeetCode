class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<>();
        HashMap<String, ArrayList<String>> map = new HashMap<>();
        for(int i = 0;i<strs.length;i++)
        {
             char[] ch = strs[i].toCharArray();
            Arrays.sort(ch);
            String key = new String(ch);
            if(!map.containsKey(key))
                map.put(key,new ArrayList<String>());
            
            map.get(key).add(strs[i]);
        }
        for(ArrayList<String> a:map.values())
        {
            result.add(a);
        }
        return result;
    }
}