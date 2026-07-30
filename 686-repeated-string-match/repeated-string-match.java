class Solution {
    public int repeatedStringMatch(String a, String b) {
        int cnt = 1;
        StringBuilder tem = new StringBuilder(a);
        while(tem.length() < b.length()){
            cnt++;
            tem.append(a);    
        }
        if(tem.toString().contains(b)){
            return cnt;
        }
        if(tem.append(a).toString().contains(b)){
            return cnt+1;
        }
        return -1;
    }
}