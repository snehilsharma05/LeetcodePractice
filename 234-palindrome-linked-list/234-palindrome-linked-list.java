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
    public boolean isPalindrome(ListNode head) {
        if(head == null || head.next == null){
            return true;
        }
        Stack<Integer> s = new Stack<>();
        ListNode curr = head;
        
        while(curr != null){
            s.push(curr.val);
            curr = curr.next;
        }
        
        curr = head;
        while(curr != null){
            if(s.pop() != curr.val){
                return false;
            }
            curr = curr.next;
        }
        return true;
    }
}