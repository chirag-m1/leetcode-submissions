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
    ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode(Integer.MIN_VALUE);
        ListNode temp = dummy;
        while(list1 != null && list2 != null) {
            if(list1.val < list2.val) {
                temp.next = list1;
                list1 = list1.next;
            }
            else {
                temp.next = list2;
                list2 = list2.next;
            }
            temp = temp.next;
        }
        if(list1 != null) {
            temp.next = list1;
        }
        else {
            temp.next = list2;
        }
        return dummy.next;
    }

    ListNode findMid(ListNode root) {
        ListNode slow = root;
        ListNode fast = root.next;
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public ListNode sortList(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }
        ListNode mid = findMid(head);
        ListNode list2 = mid.next;
        mid.next = null;

        ListNode left = sortList(head);
        ListNode right = sortList(list2);
        return mergeTwoLists(left, right);
    }
}