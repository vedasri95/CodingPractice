public class LinkedList {
    ListNode head=null;
    ListNode last=null;
    public void printList(ListNode head){
        ListNode temp = head;
        while(temp != null){
            System.out.println(temp.val);
            temp = temp.next;

        }

    }
    public ListNode createList(int i, int count){
        int c = 0;
        while(c < count){
            c++;
            if(head==null){
                head = last = new ListNode(i);
            }
            else{
                last.next = new ListNode(i);
                last = last.next;
            }
            i++;
        }
        return head;
    }
}
