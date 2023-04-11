import java.util.HashMap;

public class L1836 {

    /*题目 : 给一个未排序的链表，删除所有的重复元素*/
    /*思路 : 先遍历一遍找出所有重复元素，然后再遍历一遍选择将不重复的元素放入新链表中*/
    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public ListNode deleteDuplicatesUnsorted(ListNode head) {
        HashMap<ListNode, Integer> valToCount = new HashMap<>();
        ListNode cur = head;
        while (cur != null) {
            valToCount.put(cur, valToCount.getOrDefault(cur, 0) + 1);
            cur = cur.next;
        }

        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        cur = dummy;

        while (cur != null) {
            ListNode unique = cur.next;
            while (unique != null && valToCount.get(unique) > 1) unique = unique.next;
            cur.next = unique;
            cur = cur.next;
        }
        return dummy.next;
    }
}
