// https://codeforces.com/problemset/problem/1676/F
import java.util.*;

public class F_Longest_Strike {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-->0) {
            int n=sc.nextInt(), k=sc.nextInt();
            Map<Integer, Integer> freq = new HashMap<>();
            List<Integer> arr = new ArrayList<>();
            for(int i=0;i<n;i++) {
                int num=sc.nextInt();
                freq.put(num, freq.getOrDefault(num, 0)+1);
            }
            for(Integer key:freq.keySet())
                if(freq.get(key)>=k)
                    arr.add(key);
            if(arr.size()==0) {
                System.out.println(-1);
                continue;
            }
            Collections.sort(arr);
            int maxLen=1, l=0, r=0, left=arr.get(0), right=arr.get(0);
            while(r<arr.size()-1) {
                if(arr.get(r+1)-arr.get(r)==1)
                    r++;
                else {
                    if((r-l+1)>maxLen) {
                        maxLen=r-l+1;
                        left=arr.get(l);
                        right=arr.get(r);
                    }
                    l=r+1;
                    r++;
                }
            }
            if((r-l+1)>maxLen) {
                maxLen=r-l+1;
                left=arr.get(l);
                right=arr.get(r);
            }
            System.out.println(left+" "+right);
        }
    }
}
