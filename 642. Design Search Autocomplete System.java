import java.util.*;

class AutocompleteSystem {
    String prefix;
    TrieNode root;

    class TrieNode {
        Map<Character, TrieNode> children;         //this stores the children of the current node according to a char, which makes the trie a tree
        Map<String, Integer> counts;
        boolean isWord;

        public TrieNode() {
            children = new HashMap<>();
            counts = new HashMap<>();
            isWord = false;
        }
    }

    class Node {      //this is for node in priority queue, make it easy to compare
        String word;
        int count;

        public Node(String w, int c) {
            this.word = w;
            this.count = c;
        }
    }

    public void add(String word, int count) {
        TrieNode cur = root;
        for (char ch : word.toCharArray()) {
            TrieNode next = cur.children.get(ch);
            if (next == null) {
                next = new TrieNode();
                cur.children.put(ch, next);
            }
            cur = next;
            cur.counts.put(word, cur.counts.getOrDefault(word, 0) + count);
        }
        cur.isWord = true;

    }


    public AutocompleteSystem(String[] sentences, int[] times) {
        root = new TrieNode();
        prefix = "";
        for (int i = 0; i < sentences.length; i++) {
            add(sentences[i], times[i]);
        }
    }

    public List<String> input(char c) {
        if (c == '#') {
            add(prefix, 1);
            prefix = "";
            return new ArrayList<>();
        }

        prefix += c;
        TrieNode cur = root;
        for (char ch : prefix.toCharArray()) {
            TrieNode next = cur.children.get(ch);
            if (next == null) return new ArrayList<>();
            else cur = next;
        }

        PriorityQueue<Node> pq = new PriorityQueue<>((a, b) -> a.count == b.count ? a.word.compareTo(b.word) : b.count - a.count);

        for (Map.Entry<String, Integer> entry : cur.counts.entrySet()) {
            pq.offer(new Node(entry.getKey(), entry.getValue()));
        }
        List<String> res = new ArrayList<>();

        for (int i = 0; i < 3 && !pq.isEmpty(); i++) {
            res.add(pq.poll().word);
        }
        return res;
    }
}
