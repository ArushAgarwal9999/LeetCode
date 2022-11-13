/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
   class Pair{
		int node;
		int index;
		public Pair(int node, int index)
		{
			this.node = node;
			this.index = index;
		}
		
	}
    public int minimumOperations(TreeNode root) {
        int result = 0;
        Queue<TreeNode> quee = new LinkedList<TreeNode>();
        quee.add(root);
        while(!quee.isEmpty())
        {
        	int size = quee.size();
        	ArrayList<Integer> list = new ArrayList<Integer>();
        	while(size>0)
        	{
        		size--;
        		TreeNode p = quee.poll();
        		list.add(p.val);
        		if(p.left != null)
        			quee.add(p.left);
        		if(p.right != null)
        			quee.add(p.right);
        		
        	}
        	result+=minSwap(list);
        }
        return result;
    }
    public int minSwap(ArrayList<Integer> list)
    {
    	int result = 0;
    	ArrayList<Pair> arr = new ArrayList<Pair>();
    	for(int i = 0;i<list.size();i++)
    	{
    		arr.add(new Pair(list.get(i), i));
    	}
    	Collections.sort(arr,(a,b)->a.node-b.node);
    	boolean[] visited = new boolean[list.size()];
    	for(int i = 0;i<arr.size();i++)
    	{
    		if(visited[i] || arr.get(i).index==i)
    			continue;
    		
    		
    		int j = i;
    		int count = 0;
    		while(!visited[j])
    		{
    			visited[j] = true;
    			j = arr.get(j).index;
    			count++;
    		}
    		result+=(count-1);
    	}
    	
    	return result;
    }
}