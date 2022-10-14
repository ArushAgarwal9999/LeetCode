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
   public static ListNode deleteMiddle(ListNode head) {
	ListNode slowPointer = head;
	ListNode fastPointer = head;
	ListNode prePointer = null;
	while(fastPointer != null &&  fastPointer.next != null)
	{
		fastPointer = fastPointer.next.next;
		prePointer = slowPointer;
		slowPointer = slowPointer.next;
	}
    if(prePointer == null)
		return null;

	        prePointer.next = slowPointer.next;
	
	
	return head;
        
    }


}