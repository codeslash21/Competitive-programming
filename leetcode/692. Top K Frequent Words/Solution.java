// Using hashmap and sorting
// t.c.=O(nlogn), s.c.=O(n)
class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> map = new HashMap<>();
        for(String word : words)
            map.put(word, map.getOrDefault(word, 0)+1);
        List<String> list = new ArrayList<>(map.keySet());
        Collections.sort(list, (s1, s2)->map.get(s1).equals(map.get(s2))?s1.compareTo(s2):map.get(s2)-map.get(s1));
        return list.subList(0,k);
    }
}

// Using minheap
// t.c.=o(nlogk), s.c.=O(n)
class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> map = new HashMap<>();
        for(String word : words)
            map.put(word, map.getOrDefault(word, 0)+1);
        PriorityQueue<String> h = new PriorityQueue<>((s1, s2)->map.get(s1).equals(map.get(s2))?s2.compareTo(s1):map.get(s1)-map.get(s2));
        for(String word : map.keySet()) {
            h.offer(word);
            if(h.size()>k)
                h.poll();
        }
        List<String> res = new ArrayList<>();
        while(!h.isEmpty())
            res.add(h.poll());
        Collections.reverse(res);
        return res;
    }
}

// Using Trie
// t.c.=O(n), s.c.=O(n)
class Solution {
    int k;
    List<String> res;
    class TrieNode {
        TrieNode[] children;
        boolean isWord;
        TrieNode() {
            children = new TrieNode[26];
            isWord = false;
        }
    }

    void addWord(TrieNode root, String word) {
        TrieNode curr = root;
        for(char c : word.toCharArray()) {
            if(curr.children[c-'a']==null)
                curr.children[c-'a']=new TrieNode();
            curr = curr.children[c-'a'];
        }
        curr.isWord = true;
    }

    void getWord(TrieNode root, String prefix) {
        if(k==0)
            return;
        if(root.isWord){
            res.add(prefix);
            k--;
        }
        for(int i=0;i<26;i++) {
            if(root.children[i]!=null && k!=0)
                getWord(root.children[i], prefix+(char)(i+'a'));
        }
    }

    public List<String> topKFrequent(String[] words, int k) {
        this.k = k;
        res = new ArrayList<String>();
        int n = words.length;
        TrieNode[] bucket = new TrieNode[n+1];
        Map<String, Integer> map = new HashMap<>();
        for(String word:words)
            map.put(word, map.getOrDefault(word, 0)+1);
        for(var entry : map.entrySet()) {
            if(bucket[entry.getValue()]==null)
                bucket[entry.getValue()] = new TrieNode();
            addWord(bucket[entry.getValue()], entry.getKey());
        }
        for(int i=n;i>0;i--) {
            if(bucket[i]!=null)
                getWord(bucket[i], "");
            if(this.k==0)
                break;
        }
        return res;
    }
}
