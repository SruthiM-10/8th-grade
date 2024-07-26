package JavaPrograms;
import java.io.*;
import java.util.*;

// (CSES) USACO Guide Section "Greedy Algorithms with Sorting"

public class StickLengths {
    public static void main(String[] args) throws IOException{
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(read.readLine());
        String s = read.readLine(); String[] arr = s.split(" ");
        int[] sticks = new int[N];
        for (int i = 0; i < N; i ++) sticks[i] = Integer.parseInt(arr[i]);
        Arrays.sort(sticks);
        int median;
        if (N % 2 == 0)
            median = (sticks[N/2 - 1] + sticks[N / 2])/2;
        else
            median = sticks[N/2];
        long cost = 0;
        for (int i = 0; i < N; i ++){
            cost += Math.abs(sticks[i] - median);
        }
        System.out.println(cost);
    }
}
