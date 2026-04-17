package Stack;
import java.util.*;

public class validParenthesis {
    public static boolean isValid(String s){
        int n = s.length();
        Stack<Character> st = new Stack<>();
        for(int i=0; i<n; i++){
            char ch = s.charAt(i);
            if(ch == '(' || ch == '{' || ch == '['){
                st.push(ch);
            } else {
                if(st.isEmpty()){
                    return false;
                }
                char top = st.pop();
                if((ch ==')' && top!='(') || (ch ==']' && top!='[') || (ch =='}' && top!='{')){
                    return false;
                }
            }  
    }
        return st.isEmpty();
    }

    public static boolean isDuplicate(String s){
        int n = s.length();
        Stack<Character> st = new Stack<>();
        for(int i=0;i<n;i++){
            char ch = s.charAt(i);
            if(ch == ')'){
                int count =0;
                while(!st.isEmpty() && st.peek() != '('){
                    st.pop();
                    count++;
                }
                if(count < 1){
                    return true;
                } else {
                    st.pop();
                }
            } else{
                st.push(ch);
            }
        }
        return false;
    }
    public static void main(String args[]){
        // String s = "({[]})";
        // System.out.println(isValid(s));
        String s = "((a+b))";
        System.out.println(isDuplicate(s));
    }
}
