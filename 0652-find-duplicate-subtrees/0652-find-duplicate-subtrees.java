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
   public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        Map<String, Integer> set = new HashMap<>();
       List<TreeNode> result = new ArrayList<>();
        
       trav(root,set,result);
       //System.out.println("set --->>"+set);
        return result;
    }
    public String trav(TreeNode root, Map<String, Integer> set,List<TreeNode> result)
    {
        if(root == null)
            return "x";
        
        StringBuilder res = new StringBuilder();
        res.append(trav(root.left,set,result));
        res.append(",");
        res.append(trav(root.right,set,result));
        res.append(",");
        res.append(root.val);
        res.append(",");           
        set.put(res.toString(),set.getOrDefault(res.toString(),0)+1);
        if(set.get(res.toString()) == 2)
            result.add(root);
        
        
        return res.toString();
    }
    
}
