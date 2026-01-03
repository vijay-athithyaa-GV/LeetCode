class Solution {
    public int compress(char[] chars) {
        StringBuilder s = new StringBuilder();
        int cnt = 1;
        int ind = 0;
        int n = chars.length;
        for(int i=1;i<=n;i++){
            if(i<chars.length && chars[i-1] == chars[i]) cnt++;
            else{
                chars[ind++] = chars[i-1];
                if(cnt>1){
                    String cntstr = Integer.toString(cnt);
                    for(char c : cntstr.toCharArray()){
                        chars[ind++] = c;
                    }
                }
                cnt = 1;
            }
        }
       return ind;        
    }
}