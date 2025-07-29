class Solution {
    public void rotate(int[][] matrix) {
        matrixRotate(matrix);
    }
    public void matrixRotate(int[][] mat){
        int n = mat.length;
        int m = mat[0].length;
        for(int i=0;i<n-1;i++){
            for(int j=i+1;j<n;j++){
                int tem = mat[i][j];
                mat[i][j] = mat[j][i];
                mat[j][i] = tem;
            }
        }
        for(int i=0;i<n;i++){
            reverse(mat[i],0,n-1);
        }
    }
    private void reverse(int[] arr, int start, int end) {
        while (start < end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }
}