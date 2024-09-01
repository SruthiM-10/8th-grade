package JavaPrograms;
import java.util.*;

public class GoodSubarrays {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int T = scan.nextInt();
        for (int i = 0; i < T; i ++){
            int N = scan.nextInt(); scan.nextLine();
            String s = scan.nextLine();
            int[][] lengths = new int[N][N];
            int[] prefix = new int[N + 1];
            for (int a = 1; a <= N; a ++){
                prefix[a] = prefix[a - 1] + (s.charAt(a - 1) - '0');
            }

            Map<Integer, Long> sumDist = new HashMap<>();
            for (int a = 0; a <= N; a ++){
                int val = prefix[a] - a;
                sumDist.put(val, sumDist.getOrDefault(val, 0L) + 1);
            }

            long goodArrays = 0;
            for (long f : sumDist.values()){
                goodArrays += f * (f - 1) / 2;
            }

            System.out.println(goodArrays);
        }
    }
}
