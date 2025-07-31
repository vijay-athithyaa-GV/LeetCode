class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int n = matrix.length;
        int m = matrix[0].length;
        boolean flg = false;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(matrix[i][j] == target){
                    flg = true;
                    break;
                }
            }
            if(flg)
                break;

        }
        return flg;
    }
}