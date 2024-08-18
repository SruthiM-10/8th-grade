package JavaPrograms;
import java.io.*;
import java.util.*;

//(CF) USACO Guide Section "Greedy Algorithms with Sorting"

public class ThePartyAndSweets {
    public static void main(String[] args) throws IOException{
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        String s = read.readLine(); String[] arr = s.split(" ");
        int b = Integer.parseInt(arr[0]), g = Integer.parseInt(arr[1]);

        s = read.readLine(); arr = s.split(" ");
        long minTotal = 0;
        int[] boys = new int[b];
        for (int i = 0; i < b; i ++){
            boys[i] = Integer.parseInt(arr[i]);
            minTotal += boys[i];
       }
        Arrays.sort(boys);

        s = read.readLine(); arr = s.split(" ");
        int[] girls = new int[g];
        for (int i = 0; i < g; i ++){
            girls[i] = Integer.parseInt(arr[i]);
        }
        Arrays.sort(girls);

        long minSweets = minTotal * g;
        if (boys[b - 1] > girls[0]) System.out.println(-1);
        else{
            for (int i = 1; i < g; i ++) {minSweets += girls[i] - boys[b - 1];}
            if (girls[0] > boys[b - 1]) minSweets += girls[0] - boys[b - 2];
            System.out.println(minSweets);
        }
    }
}
