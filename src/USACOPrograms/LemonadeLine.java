package USACOPrograms;
import java.io.*;
import java.util.*;

//USACO 2018 US Open Contest, Silver

public class LemonadeLine {
    public static void main(String[] args) throws IOException{
        BufferedReader read = new BufferedReader(new FileReader("lemonade.in"));
        BufferedWriter write = new BufferedWriter(new FileWriter("lemonade.out"));
        int n = Integer.parseInt(read.readLine());

        String s = read.readLine(); String[] arr = s.split(" ");
        Integer[] w = new Integer[n];
        for (int i = 0; i < n; i ++) {w[i] = Integer.parseInt(arr[i]);}
        Arrays.sort(w, Collections.reverseOrder());

        int minCows = 0;
        for (int i = 0; i < n; i ++){
            if (w[i] >= minCows) minCows ++;
            else break;
        }
        write.write(minCows + "");
        write.close();
    }
}
