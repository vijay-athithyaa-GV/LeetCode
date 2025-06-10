class Solution {
   public int numTrees(int n) {
        long num = 1;
        for (int i = 0; i < n; i++) {
            num = num * (2 * n - i) / (i + 1); 
        }
        return (int) (num / (n + 1));
    }
    }
