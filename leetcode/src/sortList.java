/**
 * @author ziv
 * @date 2019/12/12  14:47
 * 自下而上进行归并
 */

//在O(n log n)的时间内使用常数级空间复杂度对链表进行排序。
//Sort a linked list in O(n log n) time using constant space complexity.
//O (n log n)时间复杂度的有 快排、堆排、归并 这里选择快排试一波
public class sortList {

    /**
     * Definition for singly-linked list.
     * class ListNode {
     * int val;
     * ListNode next;
     * ListNode(int x) {
     * val = x;
     * next = null;
     * }
     * }
     */

    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode sortList(ListNode head) {

        if (head == null || head.next == null) {
            return head;
        }

        //设置一个单链表 这里设置的数量是64
        ListNode[] list = new ListNode[64];
        ListNode node = head;
        //遍历到的最大的list数组的索引
        int maxIndex = 0;
        while (node != null) {
            //之后的这三行就是把单个节点拿出来
            ListNode cnode = node;
            //循环的条件改变
            node = node.next;
            //切断cnode节点与原来链表之间的关系  把cnode放到合适的位置
            cnode.next = null;
            //利用其辅助的list数组，利用数组的变化可以实现归并的效果
            int i = 0;
            //如果数组的位置还不是null 就接着进行合并、找当前位置的后一个位置，直到下一个位置为空为止
            while (list[i] != null) {
                ListNode mergeNode = merge(cnode, list[i]);
                list[i] = null;
                i++;
                cnode = mergeNode;
            }
            //放到运行之后的数组空位置，等待之后的合并
            list[i] = cnode;
            //记录list中最后一个节点在哪，最后合并的时候可以用上
            if (i > maxIndex) {
                maxIndex = i;
            }
        }
            //开始最后的合并,就是把最后合并的单链从数组中取出来
        ListNode retList = null;
        for (int i = 0; i <= maxIndex; i++) {
            if (list[i] != null) {
                retList = merge(retList, list[i]);
            }
        }
        return retList;
    }

    //归并两个已经排好顺序的单链表 返回的就是已经排好顺序的单链表了
    public ListNode merge(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        if (l1.val < l2.val) {
            l1.next = merge(l1.next, l2);
            return l1;
        }else {
            l2.next = merge(l1, l2.next);
            return l2;
        }
    }


}
