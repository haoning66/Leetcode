import java.util.*;

class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        List<String> result = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();
        for (String word : words) {
            if (map.containsKey(word))
                map.put(word, map.get(word) + 1);
            else
                map.put(word, 1);
        }

        PriorityQueue<Map.Entry<String,Integer>> pq = new PriorityQueue<>(    //for this problem we use descending order
                (a,b) -> a.getValue() == b.getValue()? a.getKey().compareTo(b.getKey()) :b.getValue()-a.getValue()
                                                      //this will return 0 if a=b, + if a is alphabetically bigger than b which makes b be in front of a in pq
                                                     //because in this problem b is bigger than a
        );


        for(Map.Entry<String,Integer> entry : map.entrySet()){
            pq.offer(entry);
        }

        while(k>0){
            result.add(pq.poll().getKey());
            k--;
        }

        return result;
    }

    public static void main(String[] args) {
        String[] words = {"i", "love", "leetcode", "i", "love", "coding"};
        Solution s = new Solution();
        System.out.println(s.topKFrequent(words,2));
    }
}