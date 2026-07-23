import java.util.*;

class Solution {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        for(int i=0;i<n-1;i++){
            for(int j=i+1;j<n;j++){
                Swap(matrix,i,j,j,i);
            }
        }
        for(int i=0;i<n;i++){
            //reverse operation..
            reverse(matrix,i);
        }
    }

    public void Swap(int arr[][],int i1,int j1,int i2,int j2){
        int tem = arr[i1][j1];
        arr[i1][j1] = arr[i2][j2];
        arr[i2][j2] = tem;
    }
    public void reverse(int matrix[][],int ind){
        int n = matrix.length;
        for(int i=0;i<n/2;i++){
            Swap(matrix,ind,i,ind,n-1-i);
        }
    }
}