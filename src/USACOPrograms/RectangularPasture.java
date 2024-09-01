package USACOPrograms;
import java.util.*;

//USACO 2020 December Contest, Silver

public class RectangularPasture {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();
        int[][] cows = new int[N][2];
        for (int c = 0; c < N; c ++){
            cows[c][0] = scan.nextInt();
            cows[c][1] = scan.nextInt();
        }
        Arrays.sort(cows, Comparator.comparingInt(c -> c[0]));  // sort by x
        Map<Integer, Integer> reducedX = new HashMap<>();
        for (int c = 0; c < N; c++) { reducedX.put(cows[c][0], c); }

        Arrays.sort(cows, Comparator.comparingInt(c -> c[1]));  // sort by y
        Map<Integer, Integer> reducedY = new HashMap<>();
        for (int c = 0; c < N; c++) { reducedY.put(cows[c][1], c); }

        for (int c = 0; c < N; c++) {
            cows[c][0] = reducedX.get(cows[c][0]);
            cows[c][1] = reducedY.get(cows[c][1]);
        }

        // sort by x again
        Arrays.sort(cows, Comparator.comparingInt(c -> c[0]));
        int[][] ltY = new int[N][N + 1];
        int[][] gtY = new int[N][N + 1];
        for (int c = 0; c < N; c++) {
            int currY = cows[c][1];
            for (int x = 1; x <= N; x++) {
                ltY[currY][x] =
                        (ltY[currY][x - 1] + (cows[x - 1][1] < currY ? 1 : 0));
                gtY[currY][x] =
                        (gtY[currY][x - 1] + (cows[x - 1][1] > currY ? 1 : 0));
            }
        }

        long total = 0;
        for (int c1 = 0; c1 < N; c1++) {
            for (int c2 = c1 + 1; c2 < N; c2++) {
                int bottom = Math.min(cows[c1][1], cows[c2][1]);
                int top = Math.max(cows[c1][1], cows[c2][1]);

                int bottomTotal = 1 + ltY[bottom][c2 + 1] - ltY[bottom][c1];
                int topTotal = 1 + gtY[top][c2 + 1] - gtY[top][c1];
                total += (long)bottomTotal * topTotal;
            }
        }

        total += N + 1;

        System.out.println(total);
    }
}
