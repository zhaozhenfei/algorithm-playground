package code.guide.linked;

/**
 * Created by zhenfei7 on 2024/5/18.
 */

/**
 * 打印两个有序链表的公共部分
 */
public class Solution01 {
    public void printCommonPart(Node head1, Node head2) {
        while (head1 != null && head2 != null) {
            if (head1.value < head2.value) {
                head1 = head1.next;
            } else if (head1.value > head2.value) {
                head2 = head2.next;
            } else {
                System.out.println(head1.value);
                head1 = head1.next;
                head2 = head2.next;
            }
        }
    }
}
