import java.util.Iterator;
import java.util.Scanner;
import java.util.Stack;

/**
 * Given a string with unbalanced brackets how do you remove minimum number
 *  * of extra brackets so that you are left with balanced brackets in the string
 *  *
 *  * e.g )( -> empty string
 *  *     (a) -> (a)
 *  *     ((mnq)abc))) -> ((mna)abc)
 *  *     (abc)(( -> (abc)
 */
public class RemoveExtraBraces {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String s = scan.next();
        char[] chars = s.toCharArray();
        Stack<Character> stack = new Stack<Character>();
        int open=0;
        for(int i=0; i<chars.length; i++){
            if(chars[i]==')'){
                if(open!=0) {
                    stack.push(chars[i]);
                    open--;
                }
            }
            else if(chars[i] == '('){
                open++;
                stack.push(chars[i]);
            }
            else
                stack.push(chars[i]);
        }
        while(open != 0){
            Character curr = stack.pop();
            if(curr=='(')
                open--;
        }
        Iterator iter = stack.iterator();
        StringBuffer buff = new StringBuffer();

        while(iter.hasNext()){
            buff.append(iter.next());
        }
        System.out.println("result : " + buff.toString());
    }
}
