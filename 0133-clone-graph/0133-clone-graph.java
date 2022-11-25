/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
  public Node cloneGraph(Node node) {
	       if(node==null)
	           return null;
			HashSet<Node> visited = new HashSet<Node>();
			HashMap<Integer, Node> cloneMap = new HashMap<Integer, Node>();
			dfs(node, null, visited,cloneMap);
			//System.out.println(map);
			//System.out.println(cloneMap);
	        return cloneMap.get(node.val);
	    }
		public void dfs(Node current, Node prev,HashSet<Node> visited,HashMap<Integer, Node> cloneMap)
		{
			if(!cloneMap.containsKey(current.val))
			{
				Node clone = new Node(current.val);
				cloneMap.put(current.val, clone);
			}
			visited.add(current);
			for(Node n:current.neighbors)
			{
				if(!cloneMap.containsKey(n.val))
				{
					Node clone = new Node(n.val);
					cloneMap.put(n.val, clone);
				}
				cloneMap.get(current.val).neighbors.add(cloneMap.get(n.val)) ;
				
				if(visited.contains(n)|| (prev!= null && prev==n))
					continue;
				dfs(n, current, visited,cloneMap);
			}
		}
}