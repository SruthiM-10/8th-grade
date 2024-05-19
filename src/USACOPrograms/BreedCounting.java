package USACOPrograms;
import java.io.*;
import java.util.*;

//2015 December Silver Contest

public class BreedCounting {
    public static void main(String[] args) throws IOException{
        BufferedReader scan = new BufferedReader (new FileReader ("bcount.in"));
        BufferedWriter write = new BufferedWriter (new FileWriter ("bcount.out"));
        String s = scan.readLine();
        String[] arr = s.split(" ");
        int N = Integer.parseInt(arr[0]), Q = Integer.parseInt(arr[1]);
        int[] row = new int[N];
        int[] prefix_h = new int[N + 1];
        int[] prefix_g = new int[N + 1];
        int[] prefix_j = new int[N + 1];
        for (int i = 0; i < N; i ++){
            row[i] = Integer.parseInt(scan.readLine());
        }
        if (row[0] == 1) prefix_h[1] = 1;
        else if (row[0] == 2) prefix_g[1] = 1;
        else prefix_j[1] = 1;
        for (int i = 1; i < N; i ++){
            if (row[i] == 1) prefix_h[i + 1] = 1 + prefix_h[i];
            else prefix_h[i + 1] = prefix_h[i];
            if (row[i] == 2) prefix_g[i + 1] = 1 + prefix_g[i];
            else prefix_g[i + 1] = prefix_g[i];
            if (row[i] == 3) prefix_j[i + 1] = 1 + prefix_j[i];
            else prefix_j[i + 1] = prefix_j[i];
        }
        for (int i = 0; i < Q; i ++){
            s = scan.readLine(); arr = s.split(" ");
            int a = Integer.parseInt(arr[0]), b = Integer.parseInt(arr[1]);
            int h = prefix_h[b] - prefix_h[a - 1];
            int g = prefix_g[b] - prefix_g[a - 1];
            int j = prefix_j[b] - prefix_j[a - 1];
            write.write(h + " " + g + " " + j);
            write.newLine();
        }
        write.close();
    }
}
