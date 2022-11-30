class Solution {
    public boolean uniqueOccurrences(int[] arr) {
         HashMap<Integer, Integer> map= new HashMap<Integer, Integer>();
        for(int a:arr)
        	map.put(a, map.getOrDefault(a, 0)+1);
        HashSet<Integer> set = new HashSet<Integer>(map.values());
        return set.size() ==map.size();
    }
}