class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int top = 0;
        int down = n-1;
        int left = 0;
        int right = m-1;

        List<Integer> res = new ArrayList<>();
    while(top<=down && left<=right){
            for(int i=left;i<=right;i++){
                res.add(matrix[top][i]);
            }
            top++;

            for(int j=top;j<=down;j++){
                res.add(matrix[j][right]);
            }
            right--;
            if(top<=down){
                for(int i=right;i>=left;i--){
                    res.add(matrix[down][i]);
                }
                down--;
            }
            if(left<=right){
                for(int j=down;j>=top;j--){
                    res.add(matrix[j][left]);
                }
                left++;
            }
        }
        return res;
    }
}