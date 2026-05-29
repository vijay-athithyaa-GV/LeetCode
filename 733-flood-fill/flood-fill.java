class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int res[][] = image;
        int n = res.length;
        int m = res[0].length;
        int tem = res[sr][sc];
        solut(res,sr,sc,color,n,m,tem);
        return res;
    }

    public void solut(int[][] res,int i,int j,int color,int n,int m,int tem){
        if(i>=n || j>=m || i<0 || j<0) return;
        if(res[i][j] == color) return;
        if(tem == res[i][j]){
            res[i][j] = color;
            solut(res,i+1,j,color,n,m,tem);
            solut(res,i,j+1,color,n,m,tem);
            solut(res,i-1,j,color,n,m,tem);
            solut(res,i,j-1,color,n,m,tem);
        }
        return;
    }
}