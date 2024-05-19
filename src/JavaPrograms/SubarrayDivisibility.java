package JavaPrograms;
import java.util.*;

public class SubarrayDivisibility {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        long N = scan.nextInt();
        ArrayList<Long> arr = new ArrayList<>();
        for (int i = 0; i < N; i ++) arr.add(scan.nextLong());

        Map<Long, Long> mod = new HashMap<>();
        mod.put(0L, 1L);
        long prefixSum = 0;
        long ans = 0;
        for (long i : arr){
            prefixSum += i;
            long modulus = prefixSum % N;
            if (modulus < 0) modulus += N;
            if (mod.containsKey(modulus)) {
                ans += mod.get(modulus);
                mod.put(modulus, mod.get(modulus) + 1);
            }
            if (!mod.containsKey(modulus)) mod.put(modulus, 1L);
        }
        System.out.println(ans);
    }
}
