import java.util.*;

class Solution {
    public int maximumWidth(int[] planks) {
        // Frequency of each distinct plank value (no array indexed by value!)
        Map<Integer, Integer> freq = new HashMap<>();
        for (int x : planks) freq.merge(x, 1, Integer::sum);

        Integer[] distinct = freq.keySet().toArray(new Integer[0]);
        Arrays.sort(distinct);
        int D = distinct.length;

        // Accumulate pair counts for every achievable sum H, all at once.
        Map<Long, Integer> pairsForH = new HashMap<>();

        for (int i = 0; i < D; i++) {
            int v = distinct[i];
            int fv = freq.get(v);

            // Self-pairing: two planks of the same value v, summing to 2v
            long selfH = 2L * v;
            pairsForH.merge(selfH, fv / 2, Integer::sum);

            for (int j = i + 1; j < D; j++) {
                int w = distinct[j];
                int fw = freq.get(w);
                long h = (long) v + w;
                pairsForH.merge(h, Math.min(fv, fw), Integer::sum);
            }
        }

        // Candidate H's: every plank value (singles) and every achievable pair-sum
        Set<Long> candidates = new HashSet<>(pairsForH.keySet());
        for (int v : distinct) candidates.add((long) v);

        int ans = 1;
        for (long H : candidates) {
            int singles = (H <= Integer.MAX_VALUE && freq.containsKey((int) H))
                    ? freq.get((int) H) : 0;
            int pairs = pairsForH.getOrDefault(H, 0);
            ans = Math.max(ans, singles + pairs);
        }
        return ans;
    }
}