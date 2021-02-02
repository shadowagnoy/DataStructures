package cn.jsledd.leetcode;

class ListNode {
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

/**
 * @version 1.0
 * @ClassName : AddTwoNumbersSolution
 * @Description : 2. 两数相加
 * @Author : JSLEDD
 * @Date: 2021-01-05 14:13
 */
public class AddTwoNumbersSolution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = null, flagnode = null;
        int nextneedsum = 0;
        while (l1 != null || l2 != null) {
            int n1 = l1 != null ? l1.val : 0;
            int n2 = l2 != null ? l2.val : 0;
            int c = n1 + n2 + nextneedsum;
            nextneedsum = c / 10;
            if (head == null) {
                //第一个
                head = flagnode = new ListNode(c % 10);
            } else {
                //其他值
                flagnode.next = new ListNode(c % 10);
                flagnode = flagnode.next;
            }
            if(l1 != null) l1 = l1.next;
            if(l2 != null) l2 = l2.next;
        }
        //最后一个
        if (nextneedsum == 1) {
            flagnode.next = new ListNode(1);
        }
        return head;
    }

    public static void main(String[] args) {
        AddTwoNumbersSolution addTwoNumbersSolution = new AddTwoNumbersSolution();
        ListNode l1 = new ListNode(2, new ListNode(4, new ListNode(3)));
        ListNode l2 = new ListNode(5, new ListNode(6, new ListNode(4)));
        addTwoNumbersSolution.addTwoNumbers(l1, l2);
    }
}
