// https://codeforces.com/problemset/problem/1665/B
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-->0) {
            int n = sc.nextInt(), maxFreq=Integer.MIN_VALUE, res=0;
            Map<Integer, Integer> freq = new HashMap<>();
            for(int i=0;i<n;i++) {
                int ele = sc.nextInt();
                freq.put(ele, freq.getOrDefault(ele, 0)+1);
                maxFreq=Math.max(maxFreq, freq.get(ele));
            }
            int diff = n-maxFreq;
            while(diff>0) {
                if(diff>maxFreq) {
                    res+=(maxFreq+1);
                    diff-=maxFreq;
                }
                else {
                    res+=(diff+1);
                    diff=0;
                }
                maxFreq*=2;
            }
            System.out.println(res);
        }
    }
}
