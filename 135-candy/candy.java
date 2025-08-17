class Solution {
    public int candy(int[] ratings) {
        int totcnt = 1;
        int i=1;
        int n = ratings.length;
        
        while(i<n){
            if(ratings[i] == ratings[i-1]){
                totcnt++;
                i++;
                continue;
            }
            int peak = 1;
            while(i<n && ratings[i]>ratings[i-1]){
                peak++;
                totcnt+=peak;
                i++;
            }
            int down = 1;
            while(i<n && ratings[i]<ratings[i-1]){
                totcnt+=down;
                down++;
                i++;
            }
            if(down > peak){
                totcnt += (down-peak);
            }
      } 
      return totcnt;
    }
}