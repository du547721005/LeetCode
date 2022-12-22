package src.easy;

/**
 * @Author bxdu
 * @Date 2022年12月22日 22:51
 **/
public class 合并两个有序链表21 {
    /**
     * 将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode() {}
     *     ListNode(int val) { this.val = val; }
     *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */
    /*
     * 1.迭代
     */
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        //创建一个头节点是-1的链表
        ListNode preHead = new ListNode(-1);
        ListNode pre = preHead;
        while(list1 != null && list2 != null){
            if(list1.val <= list2.val){
                pre.next = list1;
                list1 = list1.next;
            }else{
                pre.next = list2;
                list2 = list2.next;
            }
            pre = pre.next;
        }
        // 合并后 l1 和 l2 最多只有一个还未被合并完，我们直接将链表末尾指向未合并完的链表即可
        pre.next = list1 == null ? list2 : list1;
        //返回-1指向的链表，就是合并后的链表
        return preHead.next;
    }

    /*
     *2.递归
     */
    public ListNode mergeTwoLists2(ListNode list1, ListNode list2) {
        //递归出口
        if(list1 == null){
            return list2;
        }
        //递归出口
        else if(list2 == null){
            return list1;
        }
        //list1.val比较小，选list1作为下一个节点。并将list1剩下的节点和list2重新计算。
        else if(list1.val <= list2.val){
            list1.next = mergeTwoLists2(list1.next,list2);
            return list1;
        }
        else{
            //list2.val比较小，选list2作为下一个节点。并将list2剩下的节点和list1重新计算。
            list2.next = mergeTwoLists2(list1,list2.next);
            return list2;
        }
    }








    public class ListNode {
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
}
