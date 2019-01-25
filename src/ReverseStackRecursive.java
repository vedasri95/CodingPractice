import java.util.Iterator;
import java.util.Stack;

public class ReverseStackRecursive {
    //Time complexity: O(n^2)
    //Could reverse the stack in O(n) using linkedlist reversal logic

    private void reverse(Stack<Integer> stack){
        if(!stack.isEmpty()){
            //hold the values in function call stack
            Integer temp = stack.pop();
            reverse(stack);
            pushAtBottom(stack,temp);
        }
    }

    //function to push a value at the bottom of the stack
    private void pushAtBottom(Stack<Integer> stack, int temp){
        if(stack.isEmpty())
            stack.push(temp);
        else{
            Integer curr = stack.pop();
            pushAtBottom(stack,temp);
            stack.push(curr);
        }
    }
    private void printStack(Stack<Integer> stack){
        Iterator iter = stack.iterator();
        while(iter.hasNext()){
            System.out.println(iter.next());
        }
    }
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<Integer>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        ReverseStackRecursive rsr = new ReverseStackRecursive();
        rsr.printStack(stack);
        rsr.reverse(stack);
        System.out.println("Stack reversed");
        rsr.printStack(stack);
    }
}
