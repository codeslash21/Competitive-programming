// https://cses.fi/problemset/task/1629/
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), count=0, currEnd=0;
        List<List<Integer>> movieList = new ArrayList<>();
        for(int i=0;i<n;i++) {
            List<Integer> movie = new ArrayList<>();
            movie.add(sc.nextInt());
            movie.add(sc.nextInt());
            movieList.add(movie);
        }
        Collections.sort(movieList, (a,b)->a.get(1)-b.get(1));
        for(List<Integer> movie:movieList) {
            if(movie.get(0)>=currEnd) {
                currEnd=movie.get(1);
                count++;
            }
        }
        System.out.println(count);
    }
}
