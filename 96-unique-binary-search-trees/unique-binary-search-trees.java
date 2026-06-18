class Solution {
    public int numTrees(int n) {
        long cat = 1;
        for(int i=0;i<n;i++){
            cat = cat * (2*n - i) / (i + 1);
        }
        return (int)(cat/(n+1));
    }
}