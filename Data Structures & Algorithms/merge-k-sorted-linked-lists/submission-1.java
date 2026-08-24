class Solution {

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {

        if (list1 == null) return list2;
        if (list2 == null) return list1;

        ListNode head;

        if (list1.val < list2.val) {
            head = list1;
            list1 = list1.next;
        } else {
            head = list2;
            list2 = list2.next;
        }

        ListNode current = head;

        while (list1 != null && list2 != null) {

            if (list1.val < list2.val) {
                current.next = list1;
                list1 = list1.next;
            } else {
                current.next = list2;
                list2 = list2.next;
            }

            current = current.next;
        }

        current.next = (list1 != null) ? list1 : list2;

        return head;
    }


    public ListNode mergeKLists(ListNode[] lists) {

        if (lists == null || lists.length == 0) {
            return null;
        }

        ListNode head = lists[0];

        for (int i = 1; i < lists.length; i++) {
            head = mergeTwoLists(head, lists[i]);
        }

        return head;
    }
}