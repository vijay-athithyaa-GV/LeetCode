
class Solution {
    public void solveSudoku(char[][] board) {
        solve(board);
    }

    public boolean solve(char[][]arr){
        int n = arr.length;
        int m = arr[0].length;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                
                if(arr[i][j] == '.'){
     
                    for(char c='1';c<='9';c++){
                        if(isValid(arr,i,j,c)){
                            arr[i][j] = c;

                        if(solve(arr))
                            return true;
                        else 
                            arr[i][j] = '.';
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }

    public boolean isValid(char[][] arr,int row,int col,char c){
        for(int i=0;i<9;i++){
            if(arr[i][col] == c)
                return false;
            if(arr[row][i] == c)
                return false;
            if(arr[3*(row/3)+i/3][3*(col/3)+i%3] == c)
                return false;
        }
        return true;
    }
}