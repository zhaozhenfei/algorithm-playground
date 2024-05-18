package code.guide.linked;

/**
 * Created by zhenfei7 on 2024/5/19.
 */

/**
 * 反转单向和双向链表
 */
public class Solution04 {
    //反转单链表
    public Node reverseList(Node head) {
        Node prev = null;
        Node curr = head;
        Node next = null;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }


}
