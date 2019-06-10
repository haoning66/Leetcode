import java.util.*;
class test {
    public boolean isValid(String s) {
        Stack<Character> Parentheses = new Stack<Character>();
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            System.out.println(c);
            if(c=='('||c=='['||c=='{'){
                Parentheses.push(c);
            }
            if(c==')'||c==']'||c=='}'){
                if(Parentheses.empty()){
                    return false;
                }
                else{
                    if(c==')' && Parentheses.peek()!='('){
                        return false;
                    }
                    if(c==']' && Parentheses.peek()!='['){
                        return false;
                    }
                    if(c=='}' && Parentheses.peek()!='{'){
                        return false;
                    }
                    Parentheses.pop();
                }
            }
        }
        return Parentheses.empty();
    }
    public static void main(String[] args){
        test t1=new test();
        System.out.println(t1.isValid(""));
    }
}