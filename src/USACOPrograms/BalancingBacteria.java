package USACOPrograms;
import java.util.*;

//USACO 2024 January Contest (Bronze) -> passed 10/15 test cases

public class BalancingBacteria {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();
        ArrayList<Long> grass = new ArrayList<>();
        ArrayList<Long> final_val = new ArrayList<>();
        for (int i = 0; i < N; i ++) {
            grass.add(scan.nextLong());
        }
        final_val.add(grass.get(0));

        int power, sign;
        long count, tot_count = 1;
        for (int i = 1; i < N; i ++){
            sign = 1;
            if (grass.get(0) < 0) sign = -1;
            final_val.add((Math.abs(grass.get(0)) + i) * sign);
            count = final_val.get(i) - grass.get(i);
            tot_count += Math.abs(count);
            power = N - i;
            if (count == 0) continue;
            for (int j = N - 1; j >= i; j --){
                grass.set(j, grass.get(j) + count * (power - (N - 1 - j)));
            }
        }
        System.out.println(tot_count);
    }
}
