package USACOPrograms;
import java.io.*;

//2017 February Contest (Silver)

public class WhyDidTheCrossTheRoad2 {
    public static void main(String[] args) throws IOException{
        BufferedReader scan = new BufferedReader (new FileReader ("maxcross.in"));
        BufferedWriter write = new BufferedWriter (new FileWriter ("maxcross.out"));
        String s = scan.readLine();
        String[] array = s.split(" ");
        int N = Integer.parseInt(array[0]), K = Integer.parseInt(array[1]), B = Integer.parseInt(array[2]);
        int[] arr = new int[N + 1];
        for (int i = 0; i < B; i ++){
            int num = Integer.parseInt(scan.readLine());
            arr[num] ++;
        }
        int[] prefix = new int[N + 1];
        for (int i = 1; i <= N; i++){
            prefix[i] = prefix[i - 1] + arr[i];
        }
        int min = Integer.MAX_VALUE;
        for (int i = N; i >= K; i --){
            int signals = prefix[i] - prefix[i - K];
            if (signals < min) min = signals;
        }
        write.write(min + "");
        write.close();
    }
}
