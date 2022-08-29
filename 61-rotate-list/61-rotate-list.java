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
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null || head.next == null || k == 0){
            return head;
        }
        
        int len = computeLength(head);
        k = k % len;
        
        while(k-- > 0){
            ListNode trav = head,prev = null;
            while(trav.next != null){
                prev = trav;
                trav = trav.next;
            }
            trav.next = head;
            head = trav;
            prev.next = null;
        }
        return head;
    }
    
    private int computeLength(ListNode head){
        int len = 0;
        while(head != null){
            len++;
            head = head.next;
        }
        return len;
    }
}