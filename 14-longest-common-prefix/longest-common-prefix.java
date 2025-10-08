class Solution {
    public String longestCommonPrefix(String[] strs) {
        int n = strs.length;
        String pref = strs[0];
        for(int i=1;i<n;i++){
            while(strs[i].indexOf(pref)!=0){
                pref = pref.substring(0,pref.length()-1);
                if(pref.isEmpty())  return "";
            }
            
        }
        return pref;
    }
}