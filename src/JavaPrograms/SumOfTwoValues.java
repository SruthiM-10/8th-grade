package JavaPrograms;
import java.util.*;

//USACO Guide Section Two Pointers

public class SumOfTwoValues {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt(), x = scan.nextInt();
        int[] arr = new int[N];
        for (int i = 0; i < N; i ++){ arr[i] = scan.nextInt(); }
        int left = -1, right = -1;
        Map<Integer, Integer> valToInd = new HashMap<>();
        for (int i = 0; i < N; i ++){
            if(valToInd.containsKey(x - arr[i])){
                left = i; right = valToInd.get(x - arr[i]);
                break;
            }
            valToInd.put(arr[i], i);
        }
        if (left == -1)
            System.out.println("IMPOSSIBLE");
        else
            System.out.println((left + 1) + " " + (right + 1));
    }
}
