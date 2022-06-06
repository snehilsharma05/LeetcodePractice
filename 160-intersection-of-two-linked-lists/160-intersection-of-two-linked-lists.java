/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode travA = headA, travB = headB;
        while(travA != travB){
            travA = travA == null ? headB : travA.next;
            travB = travB == null ? headA : travB.next;
        }
        return travA;
    }
}