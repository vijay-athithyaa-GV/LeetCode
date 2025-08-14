import java.util.*;
class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        List<String> tem = new ArrayList<>();
        partString(0,tem,res,s);
        return res;
    }
    public void partString(int ind,List<String> tem,List<List<String>> res,String s){
        if(ind == s.length()){
            res.add(new ArrayList<>(tem));
            return;
        }
        for(int i=ind;i<s.length();i++){
            if(isPalin(s,ind,i)){
                tem.add(s.substring(ind,i+1));
                partString(i+1,tem,res,s);
                tem.remove(tem.size()-1);
            }
        }
    }
    public boolean isPalin(String s,int ind,int i){
        int start = ind;
        int end = i;
        while(start<=end){
            if(s.charAt(start++)!=s.charAt(end--))
                return false;
        }
        return true;
    }
}