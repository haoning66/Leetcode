import java.util.*;

class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Map<String, Integer> wordMap = new HashMap<>();
        wordMap.put(beginWord, 1);
        Set<String> wordSet = new HashSet<>(wordList);
        Queue<Map> wordQueue = new ArrayDeque<>();
        wordQueue.offer(wordMap);
        String alph = "abcdefghijklmnopqrstuvwxyz";
        while (!wordQueue.isEmpty()) {
            Map<String, Integer> temp = ((ArrayDeque<Map>) wordQueue).pollFirst();
            String wordCurr = "";
            for (String s : temp.keySet()) {
                wordCurr = s;
            }
            int length = temp.get(wordCurr);
            if (wordCurr.equals(endWord)) return length;
            else {
                for (int i = 0; i < wordCurr.length(); i++) {
                    for (int j = 0; j < alph.length(); j++) {
                        String wordNew = wordCurr.substring(0,i)+alph.charAt(j)+wordCurr.substring(i+1,wordCurr.length());
                        if(wordSet.contains(wordNew)&&!wordNew.equals(wordCurr)){
                            Map<String,Integer> tempNew = new HashMap<>();
                            tempNew.put(wordNew,length+1);
                            wordQueue.offer(tempNew);
                            wordSet.remove(wordNew);
                        }
                    }
                }
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        String beginWord = "hit";
        String endWord = "cog";
        List<String> wordList = new ArrayList<>();
        wordList.add("hot");
        wordList.add("dot");
        wordList.add("lot");
        wordList.add("log");
        wordList.add("cog");
        System.out.println(s.ladderLength(beginWord, endWord, wordList));
    }
}

