import java.util.*;

class Solution {
    public boolean isAnagram(String s, String t) {
        int n1 = s.length();
        int n2 = t.length();
        char c[] = s.toCharArray();
        Arrays.sort(c);
        s = new String(c);
        c = t.toCharArray();
        Arrays.sort(c);
        t = new String(c);
        if(s.equals(t)) return true;
        return false;
    }
}