/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode removeNodes(ListNode head) {
			
			ArrayDeque<ListNode>stack = new ArrayDeque<ListNode>(); 
			while(head != null)
			{
				if(stack.isEmpty())
				{
					stack.add(head);
					head=head.next;
				}
				else {
					while(!stack.isEmpty() && head.val>stack.getLast().val)
					{
						stack.pollLast();
					}
					stack.add(head);
					head=head.next;
				}
			}
			ListNode result = stack.pollFirst();
			ListNode it = result;
			while(!stack.isEmpty())
			{
				it.next = stack.pollFirst();
				it = it.next;
			}
			return result;
		}
}