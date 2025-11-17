// https://leetcode.com/problems/divide-players-into-teams-of-equal-skill/description/
//  using sorting
// t.c.=O(nlogn), s.c.=O(logn)
class Solution {
    public long dividePlayers(int[] skill) {
        int len=skill.length, left=1, right=len-2;
        Arrays.sort(skill);
        long res=skill[0]*skill[len-1];
        int totalSkill=skill[0]+skill[len-1];
        while(left<right) {
            if(skill[left]+skill[right]!=totalSkill)
                return -1;
            res+=skill[left++]*skill[right--];
        }
        return res;
    }
}

// using frequency table
// t.c.=O(n), s.c.=O(1)
class Solution {
    public long dividePlayers(int[] skill) {
        int len=skill.length, sum=0, teams=len/2;
        int[] freq=new int[2000];
        for(int i=0;i<len;i++) {
            freq[skill[i]]++;
            sum+=skill[i];
        }
        if(sum%teams>0)
            return -1;
        int totalSkill=sum/teams;
        long res=0;
        for(int playerSkill:skill) {
            int partnerSkill=totalSkill-playerSkill;
            if(freq[partnerSkill]==0)
                return -1;
            res+=playerSkill*partnerSkill;
            freq[partnerSkill]--;
        }
        return res/2;
    }
}

// using map
// t.c.=O(n), s.c.=O(1)
class Solution {
    public long dividePlayers(int[] skill) {
        int len=skill.length, totalSkill=0, teams=len/2;
        Map<Integer, Integer> freq=new HashMap<>();
        for(int s:skill) {
            totalSkill+=s;
            freq.put(s, freq.getOrDefault(s, 0)+1);
        }
        if(totalSkill%teams>0)
            return -1;
        int teamSkill=totalSkill/teams;
        long totalChemistry=0;
        for(int playerSkill:freq.keySet()) {
            int playerFreq=freq.get(playerSkill), partnerSkill=teamSkill-playerSkill;
            if(!freq.containsKey(partnerSkill) || freq.get(partnerSkill)!=playerFreq)
                return -1;
            totalChemistry+=(long)playerSkill*partnerSkill*playerFreq;
        }
        return totalChemistry/2;
    }
}
