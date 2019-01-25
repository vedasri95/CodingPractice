public class SumLists {

    public int length(ListNode head){
        int count=0;
        while(head!=null){
            count++;
            head=head.next;
        }
        return count;
    }
    public ListNode padList(ListNode head, int count){
        while(count != 0){
            ListNode node = new ListNode(0);
            node.next= head;
            head = node;
            count--;
        }
        return head;
    }

    ListNode newHead=null;
    public int addListsHelper(ListNode head1, ListNode head2){
        if(head1==null && head2==null)
            return 0;
        int prevcarry = addListsHelper(head1.next, head2.next);
        int sum = head1.val + head2.val + prevcarry;
        int carry = 0;
         if(sum > 9) {
             carry = sum%10;
             sum = sum/10;
         }
        ListNode node = new ListNode(sum);
        node.next=newHead;
        newHead = node;
        return carry;

    }
    public ListNode addLists(ListNode head1, ListNode head2){
        int n1 = length(head1);
        int n2 = length(head2);
        if(n1>n2)
            head2 = padList(head2, n1-n2);
        else if(n2>n1)
            head1 = padList(head1, n2-n1);

        addListsHelper(head1, head2);
        return newHead;

    }

    public static void main(String[] args) {
        LinkedList list1 = new LinkedList();
        LinkedList list2 = new LinkedList();
        ListNode head1 = list1.createList(1, 2);
        ListNode head2 = list2.createList(5,3);
        SumLists sl = new SumLists();
        sl.addLists(head1, head2);
        list1.printList(sl.newHead);
    }
}
