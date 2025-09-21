// https://cses.fi/problemset/task/1644
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), a = sc.nextInt(), b = sc.nextInt();
        long ans = Long.MIN_VALUE;
        long[] arr = new long[n+1];
        Deque<Integer> dq = new ArrayDeque<>();
        for(int i=1;i<=n;i++)
            arr[i] = arr[i-1]+sc.nextLong();
        for(int i=1;i<b;i++) {
            while(!dq.isEmpty() && arr[dq.peekFirst()]<=arr[i])
                dq.pollFirst();
            dq.addFirst(i);
        }
        for(int i=0;i<=n-a;i++) {
            while(i+b<=n && !dq.isEmpty() && arr[dq.peekFirst()]<=arr[i+b])
                dq.pollFirst();
            if(i+b<=n)
                dq.addFirst(i+b);
            while(!dq.isEmpty() && dq.peekLast()<(i+a))
                dq.pollLast();
            ans = Math.max(ans, arr[dq.peekLast()] - arr[i]);
        }
        System.out.println(ans);
    }
}
