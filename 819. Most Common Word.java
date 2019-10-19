import java.util.*;

class Solution {
    public String mostCommonWord(String paragraph, String[] banned) {
//        paragraph += ' ';
        Set<String> bannedset = new HashSet<>(Arrays.asList(banned));
        Map<String, Integer> wordmap = new HashMap<>();
        int maxcount = 0;
        String result = "";
        StringBuilder sb = new StringBuilder();

        for (char c : paragraph.toLowerCase().toCharArray()) {
            if (Character.isLetter(c)) {
                sb.append(c);
            } else {
                String word = sb.toString();
                sb.setLength(0);
                if (!bannedset.contains(word) && !word.equals("")) {
                    wordmap.put(word, wordmap.getOrDefault(word, 0) + 1);
                    if (wordmap.get(word) > maxcount) {
                        maxcount = wordmap.get(word);
                        result = word;
                    }
                }
            }
        }

        if(result.equals(""))
            result = sb.toString();      //it may happen that paragraph="bob", there is no stop point for it to go to the else condition

        return result;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        String[] ban = {};
        String para = "Bob";
        System.out.println(s.mostCommonWord(para, ban));
    }
}