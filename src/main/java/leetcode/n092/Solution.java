package leetcode.n092;

/**
 * Created by zhenfei7 on 2024/6/12.
 */
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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode dumpNode = new ListNode(-1, head);
        dumpNode.next = head;
        ListNode cur = dumpNode;

        ListNode leftNode = null;
        ListNode preLeft = null;
        ListNode rightNode = null;
        ListNode posRight = null;

        int i = 0;
        while(cur!=null) {
            if(i==left-1) {
                preLeft = cur;
                leftNode = cur.next;
            }
            if(i==right) {
                rightNode = cur;
                posRight = cur.next;
            }
            i++;
            cur = cur.next;
        }

        preLeft.next = null;
        rightNode.next = null;

        ListNode tempHeadNode = reverse(leftNode);
        ListNode tempTailNode = getTailNode(tempHeadNode);
        preLeft.next = tempHeadNode;
        tempTailNode.next = posRight;

        return dumpNode.next;
    }

    public ListNode reverse(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        ListNode next = null;
        while(cur!=null) {
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }

    public ListNode getTailNode(ListNode head) {
        ListNode cur = head;
        while(cur!=null){
            if(cur.next==null){
                break;
            }
            cur = cur.next;
        }
        return cur;
    }

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

    public static void main(String[] args) {

        ListNode ListNode1 = new ListNode(1);
        ListNode ListNode2 = new ListNode(2);
        ListNode ListNode3 = new ListNode(3);
        ListNode ListNode4 = new ListNode(4);
        ListNode ListNode5 = new ListNode(5);

        ListNode1.next = ListNode2;
        ListNode2.next = ListNode3;
        ListNode3.next = ListNode4;
        ListNode4.next = ListNode5;

        Solution solution = new Solution();
        print(solution.reverseBetween(ListNode1, 2, 4));

//        ListNode head = new ListNode(5);
//        Solution solution = new Solution();
//        print(solution.reverseBetween(head, 1, 1));

    }

    public static void print(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
    }

}