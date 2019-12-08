import java.util.*;

class Solution {
    public String reorganizeString(String S) { //add the character with the most appear time first, greedy it is
        String result = "";
        Map<Character, Integer> map = new HashMap<>();
        PriorityQueue<Map.Entry<Character, Integer>> pq = new PriorityQueue<>((o1, o2) -> o2.getValue() == o1.getValue() ? o2.getKey() - o1.getKey() : o2.getValue() - o1.getValue());

        for (char c : S.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            pq.offer(entry);
        }
        System.out.println(pq);

        while (!pq.isEmpty()) {
            Map.Entry<Character, Integer> entry = pq.poll();

            if (result.length() == 0 || result.charAt(result.length() - 1) != entry.getKey()) {
                result += entry.getKey();
                if (entry.getValue() != 1) {
                    entry.setValue(entry.getValue() - 1);
                    pq.offer(entry);
                }
            } else if (result.charAt(result.length() - 1) == entry.getKey()) {
                if (pq.isEmpty())
                    return "";
                Map.Entry<Character, Integer> entry2 = pq.poll();
                result += entry2.getKey();
                if (entry2.getValue() != 1) {
                    entry2.setValue(entry2.getValue() - 1);
                    pq.offer(entry2);
                }
                pq.offer(entry);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.reorganizeString("aab"));
    }
}
