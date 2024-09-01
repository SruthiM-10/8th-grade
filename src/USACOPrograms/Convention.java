package USACOPrograms;
import java.io.*;
import java.util.Arrays;

//USACO 2018 Dec Contest, Silver

public class Convention {
    static int[] cows;
    static int N;
    static int numBus;
    static int cap;
    public static void main(String[] args) throws IOException{
        BufferedReader read = new BufferedReader(new FileReader("convention.in"));
        BufferedWriter write = new BufferedWriter(new FileWriter("convention.out"));
        String s = read.readLine(); String[] arr = s.split(" ");
        N = Integer.parseInt(arr[0]);
        numBus = Integer.parseInt(arr[1]);
        cap = Integer.parseInt(arr[2]);
        cows = new int[N];
        s = read.readLine(); arr = s.split(" ");
        for (int i = 0; i < N; i ++){
            cows[i] = Integer.parseInt(arr[i]);
        }
        Arrays.sort(cows);

        int l = 0;
        int r = cows[N - 1];
        while (l <= r){
            int mid = (l + r)/2;
            if (check(mid)){
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        write.write(l + "");
        write.close();
    }
    private static boolean check(int minWait){
        int first = cows[0];
        int used = 1;
        int curCap = 0;
        for (int i = 0; i < N; i ++){
            if (cows[i] - first > minWait || curCap >= cap){
                used ++;
                curCap = 0;
                first = cows[i];
            }
            curCap ++;
        }
        return used <= numBus;
    }
}
