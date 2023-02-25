import java.util.Stack;

class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}

public class BM1_ReverseList
{
    // 使用栈解决
    public ListNode ReverseList1(ListNode head) {
        Stack<ListNode> stk = new Stack<>();
        // 将原链表全部入栈
        while(head != null){
            stk.push(head);
            head = head.next;
        }
        // 若原链表为空则返回
        if(stk.empty()) return null;

        // 构造新链表
        ListNode ans = stk.pop();
        ListNode pre = ans;
        while(!stk.empty()){
            ListNode tmp = stk.pop();
            tmp.next = null;
            pre.next = tmp;
            pre = pre.next;
        }
        return ans;
    }

    // 使用双链表解决
    public ListNode ReverseList2(ListNode head) {
        ListNode ans = null;
        while(head != null){
            // 暂存原链表下一结点
            ListNode tmp = head.next;
            // 构造新链表
            head.next = ans;
            ans = head;
            // 访问原链表下一结点
            head = tmp;
        }
        return ans;
    }
}
