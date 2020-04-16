package Problems;

import java.util.Stack;

/**
 * ValidBracketsExpression
 */
public class ValidBracketsExpression {

    public static void main(String[] args) {
        new ValidBracketsExpression().braces("((a+b))");
    }
    public int braces(String A) {
        Stack<Character> s = new Stack<>();
        for(char c:A.toCharArray()){
            if(c=='(' ||c=='+' || c=='-'||c=='*'||c=='/'){
                s.push(c);
                continue;
            }
            if(c==')'){
                if(s.peek()=='(')
                    return 0;
                else{
                    while(s.peek()!='(')
                        s.pop();
                    s.pop();
                }
            }
            System.out.println(s);
                    
        }
    return 1;
    }
}