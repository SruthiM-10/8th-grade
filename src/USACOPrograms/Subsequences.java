package USACOPrograms;
import java.io.*;
import java.util.*;

//2016 January Silver Contest

public class Subsequences {
    public static void main (String[] args) throws IOException{
        BufferedReader scan = new BufferedReader (new FileReader ("div7.in"));
        BufferedWriter write = new BufferedWriter (new FileWriter ("div7.out"));
        int N = Integer.parseInt(scan.readLine());
        int maxLen = 0;
        int[] first = new int[7];
        first[0] = 0;
        Arrays.fill(first, -1);
        int mod = 0;
        for (int c = 0; c < N; c ++){
            int cow = Integer.parseInt(scan.readLine());
            mod = (mod + cow) % 7;
            if (first[mod] == - 1) first[mod] = c;
            else maxLen = Math.max(maxLen, c - first[mod]);
        }
        write.write(maxLen + "");
        write.close();
    }
}
