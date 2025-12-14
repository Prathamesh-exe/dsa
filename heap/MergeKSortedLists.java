// https://leetcode.com/problems/merge-k-sorted-lists/description/
import java.util.*;

public class MergeKSortedLists {

    // Definition for singly-linked list.
    static class ListNode {
        int val;
        ListNode next;

        ListNode() {}

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    // Helper method to print linked list
    private static void printList(ListNode head) {
        ListNode curr = head;
        while (curr != null) {
            System.out.print(curr.val);
            if (curr.next != null) System.out.print(" -> ");
            curr = curr.next;
        }
        System.out.println();
    }

    // Helper method to build linked list from array
    private static ListNode buildList(int[] arr) {
        ListNode dummy = new ListNode(-1);
        ListNode curr = dummy;
        for (int val : arr) {
            curr.next = new ListNode(val);
            curr = curr.next;
        }
        return dummy.next;
    }

    // psvm
    public static void main(String[] args) {

        // Example input:
        // [
        //   1 -> 4 -> 5,
        //   1 -> 3 -> 4,
        //   2 -> 6
        // ]

        ListNode l1 = buildList(new int[]{1, 4, 5});
        ListNode l2 = buildList(new int[]{1, 3, 4});
        ListNode l3 = buildList(new int[]{2, 6});

        ListNode[] lists = new ListNode[]{l1, l2, l3};

        Solution solution = new Solution();
        ListNode result = solution.mergeKLists(lists);

        System.out.print("Merged List: ");
        printList(result);
    }


    static class Solution {

        public ListNode mergeKLists(ListNode[] lists) {
            PriorityQueue<ListNode> minHeap = new PriorityQueue<>(
                    (a, b) -> Integer.compare(a.val, b.val)
            );

            // Add the head of each list to the min-heap
            for (ListNode node : lists) {
                if (node != null) {
                    minHeap.add(node);
                }
            }

            ListNode result = new ListNode(0);
            ListNode current = result;

            while (!minHeap.isEmpty()) {
                ListNode smallestNode = minHeap.remove();
                current.next = smallestNode;
                current = current.next;

                if (smallestNode.next != null) {
                    minHeap.add(smallestNode.next);
                }
            }

            return result.next;
         
        }
    }
}
