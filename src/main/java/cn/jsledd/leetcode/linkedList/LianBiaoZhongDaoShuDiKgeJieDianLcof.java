package cn.jsledd.leetcode.linkedList;

/**
 * @version 1.0
 * @ClassName : DeleteNodeInALinkedList
 * @Description : 剑指 Offer 22. 链表中倒数第k个节点
 * @Author : JSLEDD
 * @Date: 2021-09-02 12:30
 */
public class LianBiaoZhongDaoShuDiKgeJieDianLcof {
    static ListNode head = new ListNode(0);
    public static void main(String[] args) {
        LianBiaoZhongDaoShuDiKgeJieDianLcof lianBiaoZhongDaoShuDiKgeJieDianLcof = new LianBiaoZhongDaoShuDiKgeJieDianLcof();
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        head.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        System.out.println(lianBiaoZhongDaoShuDiKgeJieDianLcof.getKthFromEnd(head, 2).val);
    }
    public ListNode getKthFromEnd(ListNode head, int k) {
        ListNode first = head;
        ListNode slow = head;
        for(;first !=null && k>0 ; k--){
            first = first.next;
        }
        while(first !=null){
            first = first.next;
            slow = slow.next;
        }
        return slow;
    }
}
