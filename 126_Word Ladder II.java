import javafx.util.Pair;

import java.util.*;

class Solution {

    HashMap<String, Integer> path = new HashMap<>();

    private void BFS(String beginWord, String endWord, HashSet<String> dic) {
        Queue<String> wordQueue = new LinkedList<>();
        wordQueue.add(beginWord);
        path.put(beginWord, 0);
        String wordCurr;
        while (!wordQueue.isEmpty()) {

            wordCurr = wordQueue.poll();
            if (wordCurr == endWord)
                continue;
            for (int i = 0; i < wordCurr.length(); i++) {
                char[] wordChar = wordCurr.toCharArray();
                for (char c = 'a'; c <= 'z'; c++) {
                    if (wordChar[i] == c)
                        continue;

                    wordChar[i] = c;
                    String wordNew = new String(wordChar);
                    if (wordNew.equals(endWord) || dic.contains(wordNew)) {
                        if (path.get(wordNew) == null) {
                            int depth = path.get(wordCurr);
                            path.put(wordNew, depth + 1);
                            wordQueue.add(wordNew);
                        }
                    }

                }
            }
        }
    }

    private void DFS(String beginWord, String endWord, List<String> pathArr, List<List<String>> result) {

        if (beginWord.equals(endWord)) {
            pathArr.add(beginWord);
            Collections.reverse(pathArr);
            result.add(pathArr);
            return;
        }
        if (path.get(beginWord) == null)
            return;
        pathArr.add(beginWord);
        int nextdepth = path.get(beginWord) - 1;
        for (int i = 0; i < beginWord.length(); i++) {
            char[] wordChar = beginWord.toCharArray();
            for (char c = 'a'; c <= 'z'; c++) {
                if (wordChar[i] == c)
                    continue;
                wordChar[i] = c;
                String wordNew = new String(wordChar);
                if(path.get(wordNew)!=null&&(path.get(wordNew)==nextdepth)){
                    List<String> newpathway = new ArrayList<>(pathArr);
                    DFS(wordNew,endWord,newpathway,result);
                }
            }
        }


    }


    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
//        if(!wordList.contains(endWord))
//            return Collections.emptyList();
//        List<List<String>> result = new ArrayList<>();
//        int min = 0;
//        Set<String> wordSet = new HashSet<>(wordList);
//        wordSet.remove(beginWord);
//        Queue<Pair<String, Pair<List<String>, Set<String>>>> wordQueue = new LinkedList<>();
//        List<String> begin = new ArrayList<>();
//        begin.add(beginWord);
//        wordQueue.offer(new Pair(beginWord, new Pair(begin, wordSet)));
//        String alph = "abcdefghijklmnopqrstuvwxyz";
//
//        while (!wordQueue.isEmpty()) {
//
//            Pair<String, Pair<List<String>, Set<String>>> curr = wordQueue.remove();
//            String wordCurr = curr.getKey();
//            List<String> listCurr = curr.getValue().getKey();
//            Set<String> setCurr = curr.getValue().getValue();
//
//            if (wordCurr.equals(endWord)) {
//                if (min == 0) {
//                    result.add(listCurr);
//                    min = listCurr.size();
//                } else if (listCurr.size() == min) {
//                    result.add(listCurr);
//                } else if (listCurr.size() < min) {
//                    result = new ArrayList<>();
//                    result.add(listCurr);
//                    min = listCurr.size();
//                }
//            } else {
//                for (int i = 0; i < wordCurr.length(); i++) {
//                    for (int j = 0; j < alph.length(); j++) {
//                        String wordNew = wordCurr.substring(0, i) + alph.charAt(j) + wordCurr.substring(i + 1);
//                        if (setCurr.contains(wordNew) && !wordNew.equals(wordCurr)) {
//                            List<String> listNew = new ArrayList<>();
//                            for (String s : listCurr) {
//                                listNew.add(s);
//                            }
//                            listNew.add(wordNew);
//                            Set<String> setNew = new HashSet<>();
//                            for(String s:setCurr){
//                                if(!s.equals(wordNew))
//                                    setNew.add(s);
//                            }
//                            wordQueue.add(new Pair(wordNew, new Pair(listNew,setNew)));
//                        }
//                    }
//                }
//            }
//        }
//        return result;
        List<List<String>> result = new ArrayList<>();
        if(beginWord==null||endWord==null||wordList==null||!wordList.contains(endWord))
            return result;

        HashSet<String> dic = new HashSet<>(wordList);
        List<String> patharr = new ArrayList<>();
        BFS(beginWord, endWord, dic);
        DFS(endWord,beginWord,patharr,result);
        return result;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        String beginWord = "hit";
        String endWord = "cog";
        List<String> wordList = new ArrayList<>();
        wordList.add("hot");
        wordList.add("dot");
        wordList.add("dog");
        wordList.add("lot");
        wordList.add("log");
        wordList.add("cog");
        System.out.println(s.findLadders(beginWord, endWord, wordList));
    }
}

