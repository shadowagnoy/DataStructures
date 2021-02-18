package cn.jsledd.leetcode.linkedList;

import com.sun.xml.internal.bind.v2.schemagen.xmlschema.List;

/**
 * @version 1.0
 * @ClassName : DeleteNodeInALinkedList
 * @Description : 237. 删除链表中的节点
 * @Author : JSLEDD
 * @Date: 2021-02-18 14:30
 */
public class DeleteNodeInALinkedList {
    static ListNode head = new ListNode(0);
    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        head.next = node1;
        node1.next = node2;
        //node2.next = node3;
        //node3.next = node4;
        DeleteNodeInALinkedList deleteNodeInALinkedList = new DeleteNodeInALinkedList();
        deleteNodeInALinkedList.deleteNode(node1);
    }

    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}
