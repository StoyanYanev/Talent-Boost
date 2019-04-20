package RemoveNthNodeFromEndOfList;

public class RemoveNthNodeFromEndOfList {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) {
            return null;
        }
        ListNode first = head;
        ListNode second = head;

        for (int i = 0; i < n; i++) {
            first = first.next;
        }
        if (first == null) {
            head = head.next;
            return head;
        }

        while (first.next != null) {
            first = first.next;
            second = second.next;
        }
        second.next = second.next.next;
        return head;
    }

    //1->2->3->4->5, and n = 2 becomes 1->2->3->5.
    // [1,2] n=2  becomes 2
    // [1] n=1 becomes []

    public static void main(String[] args) {
        ListNode list = new ListNode(1);
        list.next = new ListNode(2);
        list.next.next = new ListNode(3);
        list.next.next.next = new ListNode(4);
        list.next.next.next.next = new ListNode(5);

        int n = 2;

        removeNthFromEnd(list, n);

        ListNode currentNode = list;
        while (currentNode != null) {
            System.out.print(currentNode.val + "->");
            currentNode = currentNode.next;
        }
    }
}