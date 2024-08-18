package USACOPrograms;
import java.io.*;
import java.util.*;

//USACO 2020 Jan Contest, Silver

public class BerryPicking {
    public static void main(String[] args) throws IOException{
        BufferedReader read = new BufferedReader(new FileReader("berries.in"));
        BufferedWriter write = new BufferedWriter(new FileWriter("berries.out"));

        String s = read.readLine(); String[] arr = s.split(" ");
        int N = Integer.parseInt(arr[0]), K = Integer.parseInt(arr[1]);
        int[] trees = new int[N];

        s = read.readLine(); arr = s.split(" ");
        for (int i = 0; i < N; i ++) trees[i] = Integer.parseInt(arr[i]);
        Arrays.sort(trees);

        int berries = -1;
        for (int b = 1; b < trees[N - 1]; b ++){
            int count = 0;
            int[] leftOver = new int[N];
            for (int i = 0; i < N; i ++){
                count += trees[i] / b;
                leftOver[i] = trees[i] % b;
            }
            if (count >= K) berries = Math.max(berries, K/2 * b);
            else if (count >= K/2){
                int res = 0;
                res += (count - K/2) * b;
                Arrays.sort(leftOver);
                int pos = N - 1;
                for (int j = count - K/2; j < K/2 && pos >= 0; j ++){
                    res += leftOver[pos];
                    pos --;
                }
                berries = Math.max(berries, res);
            }
        }
        write.write(berries + "");
        write.close();
    }
}
