// Using greedy approach
// t.c.=O(n), s.c.=O(1)
class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] freq = new int[26];
        int len = tasks.length;
        for(int i=0;i<len;i++)
            freq[tasks[i]-'A']++;
        Arrays.sort(freq);
        int f_max=freq[25], idle=(f_max-1)*n;
        for(int i=24;i>=0 && idle>0;i--)
            idle-=Math.min(f_max-1, freq[i]);
        idle=Math.max(idle, 0);
        return len+idle;
    }
}

// Using math trick
// t.c.=O(n), s.c.=O(1)
class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] freq = new int[26];
        for(char c:tasks)
            freq[c-'A']++;
        int f_max=0, n_max=0;
        for(int f:freq)
            f_max=Math.max(f_max, f);
        for(int f:freq)
            if(f==f_max)
                n_max++;
        return Math.max(tasks.length, (f_max-1)*(n+1)+n_max);
    }
}
