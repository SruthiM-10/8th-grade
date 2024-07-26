package JavaPrograms;
import java.io.*;
import java.util.*;

//(CSES) USACO Guide Section "Greedy Algorithms With Sorting"

public class FerrisWheel {
    public static void main(String[] args) throws IOException{
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        String s = read.readLine(); String[] arr = s.split(" ");
        int n = Integer.parseInt(arr[0]), x = Integer.parseInt(arr[1]);
        s = read.readLine(); arr = s.split(" ");

        int[] weights = new int[n];
        for (int i = 0; i < n; i ++) { weights[i] = Integer.parseInt(arr[i]); }
        Arrays.sort(weights);

        int pos1 = 0, pos2 = n - 1;
        int gondolas = 0;
        while(pos1 < pos2){
            if (weights[pos1] + weights[pos2] <= x) pos1 ++;
            pos2 --;
            gondolas ++;
        }
        if (pos1 == pos2) gondolas ++;
        System.out.println(gondolas);
    }
}
