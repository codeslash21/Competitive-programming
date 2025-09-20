// https://cses.fi/problemset/task/2428
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), k = sc.nextInt(), dist = 0, left = 0, right = 0;
        long res = 0;
        int[] arr = new int[n];
        Map<Integer, Integer> freq = new HashMap<>();
        for(int i=0;i<n;i++)
            arr[i] = sc.nextInt();
        while(right<n) {
            if(freq.getOrDefault(arr[right], 0)==0)
                dist++;
            freq.put(arr[right], freq.getOrDefault(arr[right], 0)+1);
            while(dist>k) {
                freq.put(arr[left], freq.get(arr[left])-1);
                if(freq.get(arr[left])==0)
                    dist--;
                left++;
            }
            res+=(long)right-left+1;
            right++;
        }
        System.out.println(res);
    }
}
