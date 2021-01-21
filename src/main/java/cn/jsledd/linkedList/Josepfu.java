package cn.jsledd.linkedList;

import java.util.Stack;

/**
 * @version 1.0
 * @ClassName : Josepfu
 * @Description : 约瑟夫问题的举例，单项环形链表
 * @Author : JSLEDD
 * @Date: 2016-6-2 10:02
 */
public class Josepfu {
    public static void main(String[] args) {
        //先创建节点
        StudentNode node1 = new StudentNode(1, "张三");
        StudentNode node2 = new StudentNode(2, "李四");
        StudentNode node3 = new StudentNode(3, "王五");
        StudentNode node4 = new StudentNode(4, "赵六");
        //创建要给链表
        CircleSingleLinkedList circlesingleLinkedList = new CircleSingleLinkedList();
        circlesingleLinkedList.add(node1);
        circlesingleLinkedList.add(node2);
        circlesingleLinkedList.add(node3);
        circlesingleLinkedList.add(node4);
        System.out.println("head" + circlesingleLinkedList.getHead());
        //打印学生列表
        circlesingleLinkedList.printList();
        circlesingleLinkedList.addByOrder(new StudentNode(6, "刘八"));
        circlesingleLinkedList.addByOrder(new StudentNode(5, "刘七"));
        circlesingleLinkedList.printList();
        circlesingleLinkedList.del(new StudentNode(6, "刘八"));
        circlesingleLinkedList.printList();
        circlesingleLinkedList.del(new StudentNode(1, "张三"));
        System.out.println("head" + circlesingleLinkedList.getHead());
        circlesingleLinkedList.printList();
        circlesingleLinkedList.update(new StudentNode(5, "刘九"));
        circlesingleLinkedList.update(new StudentNode(1, "张二"));
        circlesingleLinkedList.printList();
        circlesingleLinkedList.reversePrintList();
        System.out.println(circlesingleLinkedList.size());
        System.out.println(circlesingleLinkedList.findLeftIndexNode(2));
        System.out.println(circlesingleLinkedList.findRightIndexNode(2));
        circlesingleLinkedList.printList();
        circlesingleLinkedList.reversetList();
        circlesingleLinkedList.printList();
        System.out.println(circlesingleLinkedList.getByNo(2));
        CircleSingleLinkedList josepfuList = new CircleSingleLinkedList();
        josepfuList.bacthadd(40);
        josepfuList.jonsepfu(1, 3, 40);
        josepfuList.printList();
    }
}

/**
 * @author JSLEDD
 * @description 定义一个学生链表来管理学僧
 * @date 2016-6-2 14:07
 * @return
 * @throws
 */
class CircleSingleLinkedList {
    //先初始化一个头节点, 头节点不要动, 不存放具体的数据
    private StudentNode head = null;

    //返回头节点
    public StudentNode getHead() {
        return head;
    }

    /**
     * @param studentNode
     * @return void
     * @throws
     * @description 直接将新增节点加到最后
     * @author JSLEDD
     * @date 2016/6/2 14:10
     */
    public void add(StudentNode studentNode) {
        if (head == null) {
            head = studentNode;
            head.next = head;
            return;
        }
        //因为head节点不能动，因此我们需要一个辅助遍历 temp
        StudentNode temp = head;
        //遍历链表，找到最后
        while (true) {
            //找到链表的最后
            if (temp.next == head) {//
                break;
            }
            //如果没有找到最后, 将将temp后移
            temp = temp.next;
        }
        //当退出while循环时，temp就指向了链表的最后
        //将最后这个节点的next 指向 新的节点
        temp.next = studentNode;
        studentNode.next = head;
    }

    /**
     * @param nums
     * @return void
     * @throws
     * @description 批量添加
     * @author JSLEDD
     * @date 2016/6/2 14:10
     */
    public void bacthadd(int nums) {
        int startNo = 0;
        int i = startNo;
        if (head == null) {
            head = new StudentNode(i, "景" + i++);
            head.next = head;
        }
        //因为head节点不能动，因此我们需要一个辅助遍历 temp
        StudentNode temp = head;
        //遍历链表，找到最后
        for (; i < startNo + nums; i++) {
            temp.next = new StudentNode(i, "景" + i);
            temp = temp.next;
        }
        //当退出while循环时，temp就指向了链表的最后
        //将最后这个节点的next 指向 新的节点
        temp.next = head;
    }

    /**
     * @param studentNode
     * @return void
     * @throws
     * @description 按学号新增节点
     * @author JSLEDD
     * @date 2016/6/2 14:11
     */
    public void addByOrder(StudentNode studentNode) {
        //因为头节点不能动，因此我们仍然通过一个辅助指针(变量)来帮助找到添加的位置
        //因为单链表，因为我们找的temp 是位于 添加位置的前一个节点，否则插入不了
        StudentNode temp = head;
        boolean flag = false; // flag标志添加的编号是否存在，默认为false
        while (true) {
            if (temp.next == head) {//说明temp已经在链表的最后
                break; //
            }
            if (temp.next.numno > studentNode.numno) { //位置找到，就在temp的后面插入
                break;
            } else if (temp.next.numno == studentNode.numno) {//说明希望添加的学号已然存在
                flag = true; //说明编号存在
                break;
            }
            temp = temp.next; //后移，遍历当前链表
        }
        //判断flag 的值
        if (flag) { //不能添加，说明编号存在
            System.out.printf("按学号插入列表错误，学号 %d 已经存在了, 不能加入\n", studentNode.numno);
        } else {
            //插入到链表中, temp的后面
            studentNode.next = temp.next;
            temp.next = studentNode;
        }
    }

    /**
     * @param startNo  开始的地方
     * @param countNum 步长
     * @param nums     取出个数
     * @throws
     * @description
     * @author JSLEDD
     * @date 2016/6/215:55
     */
    public void jonsepfu(int startNo, int countNum, int nums) {
        if (head == null || startNo < 1 || startNo > nums) {
            System.out.println("参数错误");
            return;
        }
        StudentNode newhead = head;
        StudentNode last = head;
        //循环获取最后一个元素
        while (true) {
            if (last.next == head) {
                break;
            }
            last = last.next;
        }
        for (int i = 0; i < startNo - 1; i++) {
            newhead = newhead.next;
            last = last.next;
        }
        while (true) {
            if (newhead == last) {
                System.out.println("最后去除" + newhead);
                head = null;
                break;
            }
            for (int i = 0; i < countNum - 1; i++) {
                newhead = newhead.next;
                last = last.next;
            }
            System.out.println("去除" + newhead);
            newhead = newhead.next;
            last.next = newhead;
        }
    }

    public StudentNode getByNo(int numno) {
        //判断是否空
        if (head == null) {
            System.out.println("链表为空~");
            return null;
        }
        //找到需要修改的节点, 根据no编号
        //定义一个辅助变量
        StudentNode temp = head.next;
        boolean flag = false; //表示是否找到该节点
        while (true) {
            if (temp == head) {
                break; //已经遍历完链表
            }
            if (temp.numno == numno) {
                return temp;
            }
            temp = temp.next;
        }
        return null;
    }

    /**
     * @param studentNode
     * @return void
     * @throws
     * @description 按学号更改学生
     * @author JSLEDD
     * @date 2016/6/2 14:15
     */
    public void update(StudentNode studentNode) {
        //判断是否空
        if (head == null) {
            System.out.println("链表为空~");
            return;
        }
        //找到需要修改的节点, 根据no编号
        //定义一个辅助变量
        StudentNode temp = head.next;
        boolean flag = false; //表示是否找到该节点
        while (true) {
            if (temp == head) {
                break; //已经遍历完链表
            }
            if (temp.numno == studentNode.numno) {
                //找到
                flag = true;
                break;
            }
            temp = temp.next;
        }
        //根据flag 判断是否找到要修改的节点
        if (flag) {
            temp.name = studentNode.name;
        } else { //没有找到
            System.out.printf("没有找到学号 %d 的节点，不能修改\n", studentNode.numno);
        }
    }

    /**
     * @param studentNode
     * @return void
     * @throws
     * @description 删除学生
     * @author JSLEDD
     * @date 2016/6/2 14:18
     */
    public void del(StudentNode studentNode) {
        if (head == null) {
            System.out.println("链表为空~");
            return;
        }
        StudentNode temp = head;
        boolean flag = false; // 标志是否找到待删除节点的
        while (true) {
            if (temp.next == head) { //已经到链表的最后
                if (studentNode.numno == head.numno) { //找到最后之后 判断是不是头元素，只能在最后的时候判断
                    flag = true;
                    head = head.next;
                    break;
                }
                break;
            }
            if (temp.next.numno == studentNode.numno) {
                //找到的待删除节点的前一个节点temp
                flag = true;
                break;
            }
            temp = temp.next; //temp后移，遍历
        }
        //判断flag
        if (flag) { //找到
            //可以删除
            temp.next = temp.next.next;

        } else {
            System.out.printf("要删除的 %s 节点不存在\n", studentNode);
        }
    }

    /**
     * @return void
     * @throws
     * @description 打印学生信息
     * @author JSLEDD
     * @date 2016/6/2 14:20
     */
    public void printList() {
        System.out.println("---------------------------");
        //判断链表是否为空
        if (head == null) {
            System.out.println("链表为空");
            return;
        }
        //因为头节点，不能动，因此我们需要一个辅助变量来遍历
        StudentNode temp = head;
        while (true) {
            //输出节点的信息
            System.out.println(temp);
            //判断是否到链表最后
            if (temp.next.numno == head.numno) {
                break;
            }
            //将temp后移， 一定小心
            temp = temp.next;
        }
    }

    /**
     * @return void
     * @throws
     * @description 反序打印学生信息
     * @author JSLEDD
     * @date 2016/6/2 14:36
     */
    public void reversePrintList() {
        System.out.println("---------------------------");
        if (head == null) {
            return;//空链表，不能打印
        }
        //创建要给一个栈，将各个节点压入栈
        Stack<StudentNode> stack = new Stack<StudentNode>();
        StudentNode cur = head.next;
        stack.push(head);
        //将链表的所有节点压入栈
        while (cur != head) {
            stack.push(cur);
            cur = cur.next; //cur后移，这样就可以压入下一个节点
        }
        //将栈中的节点进行打印,pop 出栈
        while (stack.size() > 0) {
            System.out.println(stack.pop()); //stack的特点是先进后出
        }
    }

    /**
     * @return int
     * @throws
     * @description 打印学生数量
     * @author JSLEDD
     * @date 2016/6/2 14:22
     */
    public int size() {
        if (head == null) { //空链表
            return 0;
        }
        int length = 1;
        //定义一个辅助的变量, 这里我们没有统计头节点
        StudentNode cur = head.next;
        while (cur != head) {
            length++;
            cur = cur.next; //遍历
        }
        return length;
    }

    /**
     * @param index 索引
     * @return void
     * @throws
     * @description 正序查找第几个学生
     * @author JSLEDD
     * @date 2016/6/2 14:25
     */
    public StudentNode findLeftIndexNode(int index) {

        if (head == null) { //空链表
            return null;
        }
        int size = size();
        if (index <= 0 || index > size) {//越界
            return null;
        }
        //定义一个辅助的变量, 这里我们没有统计头节点
        StudentNode cur = head;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        return cur;
    }

    /**
     * @param index 索引
     * @return void
     * @throws
     * @description 反序查找第几个学生
     * @author JSLEDD
     * @date 2016/6/2 14:25
     */
    public StudentNode findRightIndexNode(int index) {
        return findLeftIndexNode(size() - index - 1);
    }

    /**
     * @return void
     * @throws
     * @description 将列表反转
     * @author JSLEDD
     * @date 2016/6/2 14:39
     */
    public void reversetList() {
        //如果当前链表为空，或者只有一个节点，无需反转，直接返回
        if (head == null || head.next == head) {
            return;
        }
        //思路 先生成一个单链表再转换成环形单链表
        StudentNode newHead = new StudentNode(-1, "");
        StudentNode cur = head;//指针遍历的节点
        StudentNode curnext = null;//指针遍历的节点的下一个节点
        while (cur.next != null) {
            curnext = cur.next;//当前节点的下一个节点
            cur.next = newHead.next;//将新的头节点指向的下一节点赋予当前节点的下一节点
            newHead.next = cur; //将新的头节点指向当前的节点
            cur = curnext; //开始遍历下
        }
        head = newHead.next;
        cur.next = head;
    }
}
