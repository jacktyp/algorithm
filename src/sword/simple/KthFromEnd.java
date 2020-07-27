package sword.simple;


/**
 * 链表中倒数第k个节点
 *
 * 输入一个链表，输出该链表中倒数第k个节点。为了符合大多数人的习惯，本题从1开始计数，即链表的尾节点是倒数第1个节点。
 * 例如，一个链表有6个节点，从头节点开始，它们的值依次是1、2、3、4、5、6。这个链表的倒数第3个节点是值为4的节点。
 *
 * 示例：
 * 给定一个链表: 1->2->3->4->5, 和 k = 2.
 * 返回链表 4->5.
 */

public class KthFromEnd {

    public static ListNode getKthFromEnd(ListNode head, int k) {
        //先找链表长度，然后遍历到指定位置返回
        int num = 0;
        ListNode curNode = head;
        while (curNode != null){
            curNode = curNode.next;
            num++;
        }
        ListNode node = head;
        for (int i = 0; i < num - k; i++) {
            node = node.next;
        }
        return node;

    }

    public static void main(String[] args) {
        //测试增加元素
        MyLinkedList myLinkedList = new MyLinkedList();
        myLinkedList.addNode(1);
        myLinkedList.addNode(2);
        myLinkedList.addNode(3);
        myLinkedList.addNode(4);
        myLinkedList.addNode(5);
        myLinkedList.printLink();
    }

}


class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

class MyLinkedList {

    /**链表的头结点*/
    ListNode head = null;

    /**
     * 链表添加结点:
     * 找到链表的末尾结点，把新添加的数据作为末尾结点的后续结点
     */
    public void addNode(int data){
        ListNode newNode = new ListNode(data);
        if(head == null){
            head = newNode;
            return;
        }
        ListNode temp = head;
        while(temp.next != null){
            temp = temp.next;
        }
        temp.next = newNode;
    }

    /**
     * 打印结点
     */
    public void printLink(){
        ListNode curNode = head;
        while(curNode !=null){
            System.out.println(curNode.val);
            curNode = curNode.next;
        }
    }
}