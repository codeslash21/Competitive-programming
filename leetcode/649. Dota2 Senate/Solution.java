// https://leetcode.com/problems/dota2-senate/description/
// simulate the process
// t.c.=O(n^2), s.c.=O(n)
class Solution {
    public String predictPartyVictory(String senate) {
        List<Character> chars=new ArrayList<>();
        for(char ch:senate.toCharArray())
            chars.add(ch);
        while(true) {
            int i=0;
            while(i<chars.size()) {
                if(!chars.contains('D'))    return "Radiant";
                if(!chars.contains('R'))    return "Dire";
                int j=(i+1)%chars.size();
                if(chars.get(i)=='R') {
                    while(chars.get(j)=='R')
                        j=(j+1)%chars.size();
                } else {
                    while(chars.get(j)=='D')
                        j=(j+1)%chars.size();
                }
                chars.remove(j);
                if(j<i) i--;
                i++;
            }
        }
    }
}

// using queue
// t.c.=O(n), s.c.=O(n)
class Solution {
    public String predictPartyVictory(String senate) {
        int len=senate.length(), cnt=0;
        Queue<Character> senators=new LinkedList<>();
        for(char ch:senate.toCharArray())
            senators.offer(ch);
        while(!senators.isEmpty()) {
            char currSenator=senators.poll();
            if(currSenator=='R') {
                if(cnt<0)
                    senators.offer('D');
                cnt++;
            } else {
                if(cnt>0)
                    senators.offer('R');
                cnt--;
            }
        }
        return cnt>0?"Radiant":"Dire";
    }
}
