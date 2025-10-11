// https://cses.fi/problemset/task/1629/
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt(), prev=0, cnt=0;
        List<List<Integer>> movies = new ArrayList<>();
        for(int i=0;i<n;i++)
            movies.add(Arrays.asList(sc.nextInt(), sc.nextInt()));
        Collections.sort(movies, (a,b)->a.get(1)-b.get(1));
        for(int i=0;i<n;i++) {
            if(movies.get(i).get(0)>=prev) {
                cnt++;
                prev=movies.get(i).get(1);
            }
        }
        System.out.println(cnt);
    }
}
