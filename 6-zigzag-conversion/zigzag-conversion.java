import java.util.*;

class Solution {
    public String convert(String s, int numRows) {
        int n = s.length();
        if(numRows == 1 || numRows>=n)  return s;
        char mat[][] = new char[numRows][n];
        for(int i=0;i<numRows;i++){
            Arrays.fill(mat[i],'\0');
        }

        int x = 0,y = 0;
        boolean goingDown = true;
        for(int i=0;i<n;i++){
            mat[x][y] = s.charAt(i);
            if(goingDown){
                if(x == numRows-1){
                    goingDown = false;
                    x--;
                    y++;
                }
                else
                    x++;
            }else{ 
                if(x == 0){
                    goingDown = true;
                    x++;
                    y++;

                }else{
                    x--;
                    y++;
                }    
            }
        }
        StringBuilder res = new StringBuilder();

        for(int i=0;i<numRows;i++){
            for(int j=0;j<n;j++){
                if(mat[i][j] != '\0')
                   res.append(mat[i][j]);
            }
        }
        return res.toString();

    }
}