import java.util.*;
class Solution {
    public boolean isValid(String s) {
        Stack<Character> s1 = new Stack<>();
        if(s.length()<=1)
            return false;
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            if(c=='(' || c=='{'||c=='['){
                s1.push(c);
            }
            else{
                if(s1.empty())
                    return false;
                char top = s1.peek();
                if(c==')' && top=='(')
                        s1.pop();
                else if(c==']' && top=='[')
                        s1.pop();
                else if(c=='}' && top=='{')
                        s1.pop();
                else
                    return false;
            }
        }
        if(!s1.empty())
                return false;
    return true;
    }    
}
