package USACOPrograms;
import java.util.*;

//2012 Jan Contest (Old Bronze)

public class HaybaleStacking {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt(), K = scan.nextInt();
        int[] difference = new int[N+1];
        int[] stacks = new int[N + 1];
        for (int i = 0; i < K; i ++){
            int A = scan.nextInt() - 1, B = scan.nextInt() - 1;
            difference[A] ++;
            difference[B + 1] --;
        }
        int total = 0;
        for (int i = 0; i < N; i ++){
            total += difference[i];
            stacks[i] = total;
        }
        Arrays.sort(stacks);
        System.out.println(stacks[N/2 + 1]);
    }
}
