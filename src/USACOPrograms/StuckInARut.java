package USACOPrograms;
import java.util.*;

//USACO 2020 December Contest, Silver

public class StuckInARut {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();
        scan.nextLine();
        ArrayList<Integer> eastCows = new ArrayList<>();
        ArrayList<Integer> northCows = new ArrayList<>();
        ArrayList<long[]> cows = new ArrayList<>();
        for (int i = 0; i < N; i ++){
            String s = scan.next();
            long x = scan.nextLong(), y = scan.nextLong();
            if (s.equals("E"))
                eastCows.add(i);
            else
                northCows.add(i);
            cows.add(new long[]{x, y});
            scan.nextLine();
        }
        eastCows.sort(Comparator.comparingLong(c -> cows.get(c)[1]));
        northCows.sort(Comparator.comparingLong(c -> cows.get(c)[0]));

        boolean[] stopped = new boolean[N];
        int[] amountStopped = new int[N];
        for (int north : northCows){
            for (int east : eastCows) {
                long[] n = cows.get(north), e = cows.get(east);
                long dist_x = n[0] - e[0], dist_y = e[1] - n[1];
                if (dist_x < 0 || dist_y < 0
                        || stopped[east] || stopped[north])
                    continue;
                if (dist_x > dist_y) {
                    stopped[east] = true;
                    amountStopped[north] += (1 + amountStopped[east]);
                }
                else if (dist_y > dist_x){
                    stopped[north] = true;
                    amountStopped[east] += (1 + amountStopped[north]);
                }
            }
        }
        for (int blame : amountStopped){
            System.out.println(blame);
        }
    }
}
