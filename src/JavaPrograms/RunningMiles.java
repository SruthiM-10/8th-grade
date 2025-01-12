package JavaPrograms;
import java.util.*;

//USACO Guide Silver PrefixSums Part 1, Problem: Running Miles on Codeforces

public class RunningMiles {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int T = scan.nextInt();
        for (int t = 0; t < T; t ++){
            int N = scan.nextInt();
            int[] beauties = new int[N];
            for (int i = 0; i < N; i ++){ beauties[i] = scan.nextInt(); }

            int[] pref_max = new int[N];
            int[] suff_max = new int[N];
            for (int i = 0; i < N; i++) {
                pref_max[i] = beauties[i] + i;
                suff_max[i] = beauties[i] - i;
            }

            for (int i = 1; i < N; i++) {
                pref_max[i] = Math.max(pref_max[i], pref_max[i - 1]);
            }
            for (int i = N - 2; i >= 0; i--) {
                suff_max[i] = Math.max(suff_max[i], suff_max[i + 1]);
            }

            int ans = 0;
            for (int i = 1; i < N - 1; i++) {
                ans = Math.max(ans, pref_max[i - 1] + beauties[i] + suff_max[i + 1]);
            }
            System.out.println(ans);
        }
    }
}
