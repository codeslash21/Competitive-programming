// Using heap and map
// t.c.=O(nlogn), s.c.=O(n)
class Solution {
    public String reorganizeString(String s) {
        Map<Character, Integer> map = new HashMap<>();
        PriorityQueue<Character> maxHeap = new PriorityQueue<>((a,b)->map.get(b)-map.get(a));
        int n=s.length();
        for(int i=0;i<n;i++)
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0)+1);
        maxHeap.addAll(map.keySet());
        StringBuilder sb = new StringBuilder();
        while(maxHeap.size()>1) {
            char first = maxHeap.poll();
            char second = maxHeap.poll();
            sb.append(first);
            sb.append(second);
            map.put(first, map.get(first)-1);
            map.put(second, map.get(second)-1);
            if(map.get(first)>0)
                maxHeap.offer(first);
            if(map.get(second)>0)
                maxHeap.offer(second);
        }
        if(!maxHeap.isEmpty()) {
            if(map.get(maxHeap.peek())>1)
                return "";
            else
                sb.append(maxHeap.poll());
        }
        return sb.toString();
    }
}

// t.c.=O(n), s.c.=O(n)
class Solution {
    public String reorganizeString(String s) {
        int len=s.length(), maxAllowedFreq=(len+1)/2, maxFreq=0, maxChar=0, idx=0;
        char[] result=new char[len];
        int[] freq=new int[26];
        for(int i=0;i<len;i++) 
            freq[s.charAt(i)-'a']++;
        for(int i=0;i<26;i++) 
            if(freq[i]>maxFreq) {
                maxFreq=freq[i];
                maxChar=i;
            }
        if(maxFreq>maxAllowedFreq)
            return "";
        while(freq[maxChar]!=0) {
            result[idx]=(char)(maxChar+'a');
            freq[maxChar]--;
            idx+=2;
        }
        for(int i=0;i<26;i++)
            while(freq[i]!=0) {
                if(idx>=len)
                    idx=1;
                result[idx]=(char)(i+'a');
                freq[i]--;
                idx+=2;
            }
        return new String(result);
    }
}
