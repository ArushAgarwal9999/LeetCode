import java.util.Map.Entry;
class Solution {
  class Disjoint{
		ArrayList<Integer> ranked = new ArrayList<Integer>();
		ArrayList<Integer> parent  = new ArrayList<Integer>();
		public Disjoint(int v) {
			for(int i = 0;i<v;i++)
			{
				ranked.add(0);
				parent.add(i);
			}
		}
		public int getParent(int node)
		{
			if(node==parent.get(node))
				return node;
			int num = getParent(parent.get(node));
			parent.set(node, num);
			return parent.get(node);
		}
		public void union(int u, int v)
		{
			int parentU = getParent(u);
			int parentV = getParent(v);
			if(parentU==parentV)
				return;
			if(ranked.get(parentU)>ranked.get(parentV))
			{
				parent.set(parentV, parentU);
			}
			else if(ranked.get(parentV)==ranked.get(parentU))
			{
				ranked.set(parentU, ranked.get(parentU)+1);
				parent.set(parentV, parentU);
			}
			else {
				parent.set(parentU, parentV);
			}
			
		}
	}
		
	 public List<List<String>> accountsMerge(List<List<String>> accounts) {
		 List<List<String>> result = new ArrayList<List<String>>();
		 Disjoint set = new Disjoint(accounts.size());
		 HashMap<String, Integer> map = new HashMap<String, Integer>();
		 for(int i = 0;i<accounts.size();i++)
		 {
			
			 for(int j = 1;j<accounts.get(i).size();j++)
			 {
				 String email = accounts.get(i).get(j);
				 if(map.containsKey(email))
				 {
					 set.union(map.get(email),i);
				 }
				 else {
					 map.put(email, i);
				 }
			 }
		 }
		 
		ArrayList<String>[] arr = new ArrayList[accounts.size()];
		for(Entry<String, Integer> entry:map.entrySet())
		{
			int index = set.getParent(entry.getValue());
			if(arr[index]==null)
				arr[index]= new ArrayList<String>();
			arr[index].add(entry.getKey());
		}
		for(int i = 0;i<arr.length;i++)
		{
			if(arr[i]==null)
				continue;
			result.add(new ArrayList<String>());
			Collections.sort(arr[i]);
			result.get(result.size()-1).add(accounts.get(i).get(0));
			result.get(result.size()-1).addAll(arr[i]);
		}
		
		 
		
		 return result;
	        
	    }
}