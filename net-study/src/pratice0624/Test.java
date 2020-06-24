package pratice0624;

import java.util.HashMap;
import java.util.Map;

class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}
public class Test {
    public int getValue(int[] gifts, int n) {
        int length = n / 2;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            Integer count = map.get(gifts[i]);
            if (count == null) {
                map.put(gifts[i],1);
            } else {
                map.put(gifts[i], count + 1);
            }
        }
        boolean flag = false;
        int cur = 0;
        int returns = 0;
        for (Map.Entry<Integer, Integer> maps : map.entrySet()) {
            cur = maps.getValue();
            if (cur >= length) {
                flag = true;
                returns = maps.getKey();
                break;
            }
        }
        if (flag) {
            return returns;
        }
        return 0;
    }

    public ListNode partition(ListNode pHead, int x) {
        if (pHead == null || pHead.next == null) {
            return pHead;
        }
        ListNode newHead = new ListNode(-1);
        ListNode smallHead = newHead;
        ListNode tail = new ListNode(-1);
        ListNode bigHead = tail;
        for (ListNode cur = pHead; cur != null; cur = cur.next) {
            if (cur.val < x) {
                newHead.next = new ListNode(cur.val);
                newHead = newHead.next;
            } else {
                tail.next = new ListNode(cur.val);
                tail = tail.next;
            }
        }
        newHead.next = bigHead.next;
        return smallHead.next;
    }

}
