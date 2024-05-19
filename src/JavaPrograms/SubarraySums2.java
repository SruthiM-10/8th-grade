package JavaPrograms;
import java.util.*;

public class SubarraySums2 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt(), x = scan.nextInt();
        Integer[] arr = new Integer[N];
        for (int i = 0; i < N; i ++){
            arr[i] = scan.nextInt();
        }
        long prefixSum = 0, answer = 0;
        Map<Long, Integer> sums = new HashMap<>();
        sums.put((long) 0, 1);
        for (int i : arr){
            prefixSum += i;
            if (sums.containsKey(prefixSum - x)) answer += sums.get(prefixSum - x);
            if (!sums.containsKey(prefixSum)) sums.put(prefixSum, 1);
            else sums.put(prefixSum, sums.get(prefixSum) + 1);
        }
        System.out.print(answer);
        scan.close();
    }
}
