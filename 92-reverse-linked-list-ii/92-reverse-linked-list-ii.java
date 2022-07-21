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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode trav = dummy;
        for(int steps=1;steps<=left-1;steps++){
            trav = trav.next;
        }
        
        if(trav!=null){
            trav.next = reverse(trav.next,left,right);
        }
        return dummy.next;
    }
    
    private ListNode reverse(ListNode head, int left, int right){
        ListNode prev = null,next = null,curr = head;
        while(curr != null && left<=right){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
            left++;
        }
        head.next = next;
        return prev;
    }
}