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
    public ListNode partition(ListNode head, int x) {
        ListNode trav = head;
        List<Integer> list = new ArrayList<>();
        while(trav != null){
            list.add(trav.val);
            trav = trav.next;
        }
        
        trav = head;
        for(int num:list){
            if(num<x){
                trav.val = num;
                trav = trav.next;
            }
        }
        
        for(int num:list){
            if(num>=x){
                trav.val = num;
                trav = trav.next;
            }
        }
        return head;
    }
}