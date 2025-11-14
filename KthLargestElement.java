// Time Complexity : O(nlogk) - n is the size of array nums[]
// Space Complexity : O(k).
// Did this code successfully run on Leetcode : Yes
// Approach : We use a min heap here, and if any value comes into the priority queue after reaching k capacity, we remove it from the
// queue. We continue until we navigate till the end of nums array, finally the peek() on the queue will give the kth largest element.

class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();//default min heap
        for(int num : nums){
            queue.add(num);
            if(queue.size() > k){ //remove the k+1 from the queue
                queue.poll();
            }
        }
        return queue.peek();
    }
}