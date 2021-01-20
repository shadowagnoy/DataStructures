package cn.jsledd.linkedList;


import java.util.Stack;

/**
 * @version 1.0
 * @ClassName : SingleLinkedListDemo
 * @Description : 单链表的举例说明
 * @Author : JSLEDD
 * @Date: 2016-6-2 13:50
 */
public class SingleLinkedListDemo {
    public static void main(String[] args) {
        //先创建节点
        StudentNode node1 = new StudentNode(1, "张三");
        StudentNode node2 = new StudentNode(2, "李四");
        StudentNode node3 = new StudentNode(3, "王五");
        StudentNode node4 = new StudentNode(4, "赵六");
        //创建要给链表
        SingleLinkedList singleLinkedList = new SingleLinkedList();
        singleLinkedList.add(node1);
        singleLinkedList.add(node2);
        singleLinkedList.add(node3);
        singleLinkedList.add(node4);
        //打印学生列表
        singleLinkedList.printList();
        singleLinkedList.addByOrder(new StudentNode(6,"刘八"));
        singleLinkedList.addByOrder(new StudentNode(5,"刘七"));
        singleLinkedList.printList();
        singleLinkedList.del(new StudentNode(6,"刘八"));
        singleLinkedList.printList();
        singleLinkedList.update(new StudentNode(5,"刘九"));
        singleLinkedList.printList();
        singleLinkedList.reversePrintList();
        System.out.println(singleLinkedList.findLeftIndexNode(2));
        System.out.println(singleLinkedList.findRightIndexNode(2));
        singleLinkedList.printList();
        singleLinkedList.reversetList();
        singleLinkedList.printList();

    }
}


/**
 * @author JSLEDD
 * @description 定义一个学生链表来管理学僧
 * @date 2016-6-2 14:07
 * @return
 * @throws
 */
class SingleLinkedList {
    //先初始化一个头节点, 头节点不要动, 不存放具体的数据
    private StudentNode head = new StudentNode(0, "");


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

        //因为head节点不能动，因此我们需要一个辅助遍历 temp
        StudentNode temp = head;
        //遍历链表，找到最后
        while (true) {
            //找到链表的最后
            if (temp.next == null) {//
                break;
            }
            //如果没有找到最后, 将将temp后移
            temp = temp.next;
        }
        //当退出while循环时，temp就指向了链表的最后
        //将最后这个节点的next 指向 新的节点
        temp.next = studentNode;
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
            if (temp.next == null) {//说明temp已经在链表的最后
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
     * @param studentNode
     * @return void
     * @throws
     * @description 按学号更改学生
     * @author JSLEDD
     * @date 2016/6/2 14:15
     */
    public void update(StudentNode studentNode) {
        //判断是否空
        if (head.next == null) {
            System.out.println("链表为空~");
            return;
        }
        //找到需要修改的节点, 根据no编号
        //定义一个辅助变量
        StudentNode temp = head.next;
        boolean flag = false; //表示是否找到该节点
        while (true) {
            if (temp == null) {
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
        StudentNode temp = head;
        boolean flag = false; // 标志是否找到待删除节点的
        while (true) {
            if (temp.next == null) { //已经到链表的最后
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
        if (head.next == null) {
            System.out.println("链表为空");
            return;
        }
        //因为头节点，不能动，因此我们需要一个辅助变量来遍历
        StudentNode temp = head.next;
        while (true) {
            //判断是否到链表最后
            if (temp == null) {
                break;
            }
            //输出节点的信息
            System.out.println(temp);
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
        if (head.next == null) {
            return;//空链表，不能打印
        }
        //创建要给一个栈，将各个节点压入栈
        Stack<StudentNode> stack = new Stack<StudentNode>();
        StudentNode cur = head.next;
        //将链表的所有节点压入栈
        while (cur != null) {
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
        if (head.next == null) { //空链表
            return 0;
        }
        int length = 0;
        //定义一个辅助的变量, 这里我们没有统计头节点
        StudentNode cur = head.next;
        while (cur != null) {
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

        if (head.next == null) { //空链表
            return null;
        }
        int size = size();
        if (index <= 0 || index > size) {//越界
            return null;
        }
        //定义一个辅助的变量, 这里我们没有统计头节点
        StudentNode cur = head.next;
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
        if (head.next == null || head.next.next == null) {
            return;
        }
        //定义一个新的头
        StudentNode newHead = new StudentNode(0, "");
        StudentNode cur = head.next;//指针遍历的节点
        StudentNode curnext = null;//指针遍历的节点的下一个节点
        while (cur != null) {
            curnext = cur.next;//当前节点的下一个节点
            cur.next = newHead.next;//将新的头节点指向的下一节点赋予当前节点的下一节点
            newHead.next = cur; //将新的头节点指向当前的节点
            cur = curnext; //开始遍历下
        }
        head.next = newHead.next;
    }
}

/**
 * @author JSLEDD
 * @description 定义一个学生的对象
 * @date 2016-6-2 13:59
 * @return
 * @throws
 */
class StudentNode {
    public int numno;//学号
    public String name;// 姓名
    public StudentNode next; //指向下一个节点

    //构造器
    public StudentNode(int numno, String name) {
        this.numno = numno;
        this.name = name;
    }

    //为了显示方法，我们重新toString
    @Override
    public String toString() {
        return "学生 [学号=" + numno + ", 姓名=" + name + "]";
    }

}
