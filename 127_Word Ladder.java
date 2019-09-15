
import javafx.util.Pair;

import java.util.*;

class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordSet = new HashSet<>(wordList);
        Queue<Pair<String,Integer>> wordQueue = new LinkedList<>();
        wordQueue.offer(new Pair(beginWord,1));
        String alph = "abcdefghijklmnopqrstuvwxyz";
        while (!wordQueue.isEmpty()) {
            Pair<String,Integer> curr = wordQueue.remove();
            String wordCurr = curr.getKey();
            int length = curr.getValue();
            if (wordCurr.equals(endWord)) return length;
            else {
                for (int i = 0; i < wordCurr.length(); i++) {
                    for (int j = 0; j < alph.length(); j++) {
                        String wordNew = wordCurr.substring(0,i)+alph.charAt(j)+wordCurr.substring(i+1,wordCurr.length());
                        if(wordSet.contains(wordNew)&&!wordNew.equals(wordCurr)){
                            wordQueue.add(new Pair(wordNew,length+1));
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

