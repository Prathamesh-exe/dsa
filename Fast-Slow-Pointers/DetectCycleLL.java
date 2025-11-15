// https://leetcode.com/problems/linked-list-cycle/description/
//https://leetcode.com/problems/linked-list-cycle-ii/
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
        next = null;
    }
}

public class DetectCycleLL {

    private static boolean hasCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                return true;
            }
        }
        return false;
    }
    public ListNode startCycleNode(ListNode head) {
         ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                slow=head;
                while(slow!=fast){
                    slow=slow.next;
                    fast=fast.next;
                }
                return slow;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(3);
        ListNode second = new ListNode(2);
        ListNode third = new ListNode(0);
        ListNode fourth = new ListNode(-4);

        head.next = second;
        second.next = third;
        third.next = fourth;

        fourth.next = second;

        boolean hasCycle = hasCycle(head);
        ListNode startNode = new DetectCycleLL().startCycleNode(head);

        System.out.println("Cycle detected? " + hasCycle);
        if (startNode != null) {
            System.out.println("Cycle starts at node with value: " + startNode.val);
        } else {
            System.out.println("No cycle detected.");
        }
    }
}
