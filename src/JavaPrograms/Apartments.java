package JavaPrograms;
import java.io.*;
import java.util.*;

//(CSES) USACO Guide Section "Greedy Algorithms with Sorting"

public class Apartments {
    public static void main(String[] args) throws IOException{
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        String s = read.readLine(); String[] arr = s.split(" ");
        int n = Integer.parseInt(arr[0]), m = Integer.parseInt(arr[1]), k = Integer.parseInt(arr[2]);
        int[] apartments = new int[n];
        s = read.readLine(); arr = s.split(" ");
        for (int i = 0; i < n; i ++) { apartments[i] = Integer.parseInt(arr[i]); }
        int[] applicants = new int[m];
        s = read.readLine(); arr = s.split(" ");
        for (int i = 0; i < m; i ++) { applicants[i] = Integer.parseInt(arr[i]); }

        Arrays.sort(apartments);
        Arrays.sort(applicants);

        int pos1 = 0, pos2 = 0;
        int ans = 0;
        while (pos1 < n && pos2 < m){
            if (apartments[pos1] < applicants[pos2] - k) pos1 ++;
            else if (apartments[pos1] <= applicants[pos2] + k){
                ans ++;
                pos1 ++;
                pos2 ++;
            }
            else pos2 ++;
        }
        System.out.println(ans);
    }
}
