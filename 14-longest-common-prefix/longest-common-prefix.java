class Solution {
    public String longestCommonPrefix(String[] strs) {
        int n = strs.length;
        int flg = 0;
        String res = "";
        String sub = strs[0];
        int minsize = Integer.MAX_VALUE;
        for(int i=0;i<n;i++){
            minsize = Math.min(minsize,strs[i].length());
        }
        for(int ind=0;ind<minsize;ind++){
            for(int i=1;i<n;i++){
                String sub2 = strs[i];
                if(sub.charAt(ind) != sub2.charAt(ind)){
                    flg = 1;
                    break;
                }
            } 
            if(flg == 0){
                res = res+sub.charAt(ind);
            }else{
                break;
            }
        }
        return res;
    }
}