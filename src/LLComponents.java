import java.util.ArrayList;
import java.util.HashSet;

public class LLComponents {
    public int numComponents(ListNode head, int[] G) {

        ArrayList<HashSet<Integer>> components = new ArrayList<>();

        for(int i : G){
            HashSet<Integer> temp = new HashSet<>();
            temp.add(i);
            components.add(temp);
        }
        System.out.println(components.size());
        HashSet<Integer> first=null, second=null;

        while(head != null && head.next != null){
            first=null;
            second=null;
            for(HashSet<Integer> set : components){
                if(set.contains(head.val) && set.contains(head.next.val))
                    break;
                else if(set.contains(head.val)){
                    first = set;
                    //components.remove(set);
                }
                else if(set.contains(head.next.val))
                    second = set;
                //components.remove(set);

            }
            if(first != null && second != null){
                System.out.println("lll");
                first.addAll(second);
                //components.add(first);
                // components.remove(first);
                components.remove(second);
            }
            head = head.next;
        }
        return components.size();

    }

    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        ListNode head = list.createList(1,4);
        int[] set = new int[]{0,1,3};
        LLComponents llc = new LLComponents();
        int comp = llc.numComponents(head, set);
        System.out.println("comp" + comp);
    }
}
