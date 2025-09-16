// https://cses.fi/problemset/task/2162
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        boolean flag=true;
        Queue<Integer> queue = new ArrayDeque<>();
        for(int i=1;i<=n;i++)
            queue.add(i);
        while(!queue.isEmpty()) {
            int ele = queue.remove();
            if(flag)
                queue.add(ele);
            else
                System.out.print(ele + " ");
            flag = !flag;
        }
        System.out.println();
    }
}
