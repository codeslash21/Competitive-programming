// https://cses.fi/problemset/task/1645
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0;i<n;i++)
            arr[i] = sc.nextInt();
        Stack<Integer> stack = new Stack<>();
        for(int i=0;i<n;i++) {
            while(!stack.isEmpty() && arr[stack.peek()]>=arr[i])
                stack.pop();
            System.out.print((stack.isEmpty()?0:stack.peek()+1)+" ");
            stack.add(i);
        }
    }
}
