import java.util.*;

class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int n = numCourses;
        List<List<Integer>> ls = new ArrayList<>();
        int res[] = new int[n];
        for(int i=0;i<n;i++){
            ls.add(new ArrayList<>());
        }
        for(int i=0;i<prerequisites.length;i++){
            int u = prerequisites[i][1];
            int v = prerequisites[i][0];
            ls.get(u).add(v);
        }
        int pvis[] = new int[n];
        int vis1[] = new int[n];
        //logic to detect if any cycles..
        for(int i=0;i<numCourses;i++){
            if(vis1[i]!=1){
                if(!dfs1(i,vis1,pvis,ls)) return new int[]{};
            }
        }
        // till here....
        int vis2[] = new int[n];
        Stack<Integer> st = new Stack<>();
        Arrays.fill(vis1,0);
        Arrays.fill(vis2,0);
        Arrays.fill(pvis,0);
        for(int i=0;i<numCourses;i++){
            if(vis2[i]!=1){
                dfs(i,vis2,ls,st);
            }
        }
        int i = 0;
        while(!st.isEmpty() && i<n){res[i++] = st.pop();}
        return res;
    } 

    public void dfs(int node,int vis[],List<List<Integer>> ls,Stack<Integer> st){
        vis[node] = 1;
        for(int x:ls.get(node)){
            if(vis[x]!=1) dfs(x,vis,ls,st);
        }
        st.push(node);
    } 

    public boolean dfs1(int node,int vis[],int pvis[],List<List<Integer>> ls){
        vis[node] = 1;
        pvis[node] = 1;
        for(int x:ls.get(node)){
            if(vis[x]!=1){
                if(!dfs1(x,vis,pvis,ls)) return false;
            }
            if(pvis[x] == 1) return false;
        }
        pvis[node] = 0;
        return true;
    }
}



