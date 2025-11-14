// Time Complexity :O(n*log k). n is total number of nodes and k is number of lists
// Space Complexity : O(k).
// Did this code successfully run on Leetcode : Yes
// Approach : We use a min heap here, to first store the all heads of the lists, so that when we poll() we get the minimum
// value. We then create a dummy linked list and append the minimum value to the dummy array and increment the pointer. Once the node
// is appendend to the dummy array we check the next node in that list and add to the priority queue. Finally return the dummy.next.

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
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> queue = new PriorityQueue<>((a, b) -> a.val - b.val);
        for (ListNode li : lists) {
            if (li != null) {
                queue.add(li); //add the heads of each list to the Priority queue
            }
        }

        ListNode dummy = new ListNode(-1);
        ListNode curr = dummy;
        while(!queue.isEmpty()){
            ListNode min = queue.poll();
            curr.next = min; //assign the minimum value
            curr = curr.next; //increase curr
            if(min.next != null){
                queue.add(min.next);//add next node in that list to the Priority queue
            }
        }

        return dummy.next; //gives the head of newly contructed linkedList
    }
}