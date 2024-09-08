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
    public ListNode[] splitListToParts(ListNode root, int k) {
        ListNode[] parts = new ListNode[k];
        int length = 0;
        ListNode current = root;
        while (current != null) {
            length++;
            current = current.next;
        }
        int partSize = length / k;
        int extraNodes = length % k;
        current = root;
        for (int i = 0; i < k; i++) {
            parts[i] = current;
            int currentPartSize = partSize + (i < extraNodes ? 1 : 0);
            for (int j = 0; j < currentPartSize - 1; j++) {
                if (current != null) current = current.next;
            }
            if (current != null) {
                ListNode next = current.next;
                current.next = null;
                current = next;
            }
        }
        return parts;
    }
}