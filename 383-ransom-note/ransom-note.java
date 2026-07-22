import java.util.*;

class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        int n = ransomNote.length();
        int m = magazine.length();
        int s1[] = new int[26];
        int s2[] = new int[26];
        Arrays.fill(s1,0);
        Arrays.fill(s2,0);
        
        for(char c:magazine.toCharArray()){
            s1[c-'a']++;
        }
        // for(char c:magazine){
        //     s2[c-'a']++;
        // }
         
        for(char c:ransomNote.toCharArray()){
            if(s1[c-'a']>0){
                s1[c-'a']--;
            }else return false;
        }
        return true;
    }
}