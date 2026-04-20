class Solution {
    public String countAndSay(int n) {
        int val = 1;
        String res = Integer.toString(val);
        for(int i=1;i<n;i++){
            res = count(res);
        }
        return res;
    }
    public String count(String s1){
        int n = s1.length();
        StringBuilder str = new StringBuilder();
        int count = 1;
        char initial = s1.charAt(0);
        for(int i=1;i<n;i++){
            char c = s1.charAt(i);
            if(initial == c) count++;
            else{
                str.append(count);
                str.append(initial);
                initial = c;
                count = 1;
            }
        }
        str.append(count);
        str.append(initial);
        
        return str.toString();
    }
   
}