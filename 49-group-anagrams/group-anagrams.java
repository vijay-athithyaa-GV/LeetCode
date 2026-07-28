import java.util.*;

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>> map = new HashMap<>();
        for(String st:strs){
            char ch[] = st.toCharArray();
            Arrays.sort(ch);
            String tem = new String(ch);
            if(!map.containsKey(tem)){
                map.put(tem,new ArrayList<>());
            } 
            map.get(tem).add(st);
        }
        return new ArrayList<>(map.values());
    }
}