class Solution {
    public int[] numMovesStones(int a, int b, int c) {
        int res[] = new int[2];
        int x,y,z;

        if(a<=b && a<=c){
            x = a;
            z = Math.max(b,c);
            y = b+c-z;
        }
    else if(b<=a && b<=c){
            x = b;
            z = Math.max(a,c);
            y = a+c-z;
        }
        else{
            x = c;
            z = Math.max(a,b);
            y = a+b-z;
        }
        int[] arr = {x,y,z};
        if(arr[2] - arr[0] == 2) 
            return new int[]{0,0};
        return new int[]{Math.min(arr[1]-arr[0],arr[2]-arr[1])<=2?1:2, arr[2]-arr[0]-2}; 
    }
}