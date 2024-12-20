package cn.bw.leetcode;

import cn.bw.leetcode.common.ListNode;

public class L142环形链表II {

    public ListNode detectCycle(ListNode head) {


        ListNode fast=head,slow=head;

        while (fast!=null && fast.next!=null){
            fast = fast.next.next;
            slow = slow.next;

            if(fast==slow){
                break;
            }
        }

        if(fast==null||fast.next==null){
            return null;
        }

        fast = head;
        while (fast!=slow){
            fast = fast.next;
            slow = slow.next;
        }
        return fast;

    }
}
