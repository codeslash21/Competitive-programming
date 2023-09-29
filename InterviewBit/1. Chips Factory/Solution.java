// Using two pinters
// t.c.=O(n), s.c.=O(1)
public class Solution {
    public ArrayList<Integer> solve(ArrayList<Integer> A) {
        int len=A.size(), start=0, end=0;
        while(start<len && end<len) {
            if(A.get(start)==0) {
                if(end<start)
                    end=start+1;
                while(end<len && A.get(end)==0)
                    end++;
                if(end==len)
                    break;
                A.set(start, A.get(end));
                A.set(end++, 0);
            }
            else
                start++;
        }
        return A;
    }
}

