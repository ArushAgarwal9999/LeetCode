class Solution {
    public List<String> findAllRecipes(String[] recipes, List<List<String>> ingredients, String[] supplies) {
        List<String> result = new ArrayList<String>();
        HashSet<String> set = new HashSet<String>();
        HashMap<String, List<String>> map = new HashMap<String, List<String>>();
        for(int i = 0;i<recipes.length;i++)
        {
        	map.put(recipes[i], ingredients.get(i));
        }
        for(String a:supplies)
        	set.add(a);
        
        for(int i = 0;i<recipes.length;i++)
        {
        	if(set.contains(recipes[i]) || dfs(recipes[i], set, map, new HashSet<String>()))
        		result.add(recipes[i]);
        }
        return result;
    }
	public boolean dfs(String recipes,  HashSet<String> set,HashMap<String, List<String>> map,HashSet<String> visited)
	{
		if(visited.contains(recipes))
			return false;
		
		visited.add(recipes);
			for(String a:map.get(recipes))
			{
				if(!set.contains(a) && !(map.containsKey(a) && dfs(a, set, map,visited)))
					return false;
					
					
			}
			visited.remove(recipes);
			set.add(recipes);
			return true;
	}
}