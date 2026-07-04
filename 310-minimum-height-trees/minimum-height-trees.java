import java.util.*;

class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<Integer> res = new ArrayList<>();
        if(n == 1){
            res.add(0);
            return res;
        }
        List<List<Integer>> ls = new ArrayList<>();
        for(int i=0;i<n;i++){
            ls.add(new ArrayList<>());
        }
        for(int i=0;i<edges.length;i++){
            int u = edges[i][1];
            int v = edges[i][0];
            ls.get(u).add(v);
            ls.get(v).add(u);
        }
        int min = Integer.MAX_VALUE;
        int deg[] = new int[n];
        Arrays.fill(deg,0); 
        for(int i=0;i<n;i++){
            for(int x:ls.get(i)){
                deg[x]++;
            }
        }
        Queue<Integer> q = new LinkedList<>();
        for(int i=0;i<n;i++){
            if(deg[i]==1){//leaf of the tree, then remove it..
                q.add(i);
            }
        }
        int rem = n;
        while(rem>2){
            int size = q.size();
            rem -= size;
            for(int i=0;i<size;i++){
                int node = q.poll();
                for(int x:ls.get(node)){
                    deg[x]--;
                    if(deg[x] == 1) q.add(x);
                }
            } 
        }
    
        while(!q.isEmpty()){
            res.add(q.poll());
        }
        return res;
    }
}