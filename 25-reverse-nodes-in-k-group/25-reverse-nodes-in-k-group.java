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
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head == null || head.next == null){
            return head;
        }
        
        int count = 0;
        ListNode curr = head;
        while(count < k){
            count++;
            if(curr == null){
                return head;
            }
            curr = curr.next;
        }
        
        count = 0;
        curr = head;
        ListNode next = null, prev = null;
        while(curr != null && count < k){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
            count++;
        }
        
        head.next = reverseKGroup(next,k);
        return prev;
    }
}