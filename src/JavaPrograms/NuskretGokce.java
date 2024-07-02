package JavaPrograms;
import java.util.*;

//USACO Guide Silver PrefixSums Part 2, Problem: NuskretGokce on Codeforces

public class NuskretGokce {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int m = scan.nextInt();
        ArrayList<Long> salt = new ArrayList<>();
        for (int i = 0; i < n; i ++){
            salt.add(scan.nextLong());
        }
        for (int i = 0; i < n - 1; i ++){
            salt.set(i + 1, Math.max(salt.get(i) - m, salt.get(i + 1)));
        }
        for (int i = n - 1; i > 0; i --){
            salt.set(i - 1, Math.max(salt.get(i) - m, salt.get(i - 1)));
        }
        for (int i = 0; i < n; i ++){
            System.out.print(salt.get(i) + " ");
        }
    }
}
