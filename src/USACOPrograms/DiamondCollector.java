package USACOPrograms;
import java.io.*;
import java.util.*;

//USACO 2016 US Open Contest, Silver

public class DiamondCollector {
    public static void main(String[] args) throws IOException {
        BufferedReader read = new BufferedReader(new FileReader("diamond.in"));
        BufferedWriter write = new BufferedWriter(new FileWriter("diamond.out"));
        String s = read.readLine();
        String[] arr = s.split(" ");
        int N = Integer.parseInt(arr[0]), K = Integer.parseInt(arr[1]);
        int[] sizes = new int[N];
        for (int i = 0; i < N; i++) {
            sizes[i] = Integer.parseInt(read.readLine());
        }
        Arrays.sort(sizes);

        //at each index, checks what's the leftmost diamond it can store
        int[] leftmostIndex = getLeftmost(sizes, K);
        int[] leftSize = new int[N];
        for (int i = 0; i < N; i ++){
            leftSize[i] = i - leftmostIndex[i] + 1;
            if (i > 0) leftSize[i] = Math.max(leftSize[i], leftSize[i - 1]);
        }

        //at each index, checks what's the rightmost diamond it can store
        int[] rightmostIndex = getRightmost(sizes, K);
        int[] rightSize = new int[N];
        for (int i = N - 1; i >= 0; i --){
            rightSize[i] = rightmostIndex[i] - i + 1;
            if (i < N - 1) rightSize[i] = Math.max(rightSize[i], rightSize[i + 1]);
        }
        int ans = 0;
        for (int i = 0; i < N - 1; i ++){
            ans = Math.max(ans, leftSize[i] + rightSize[i + 1]);
        }
        write.write(ans + "");
        write.close();
    }
    public static int[] getRightmost(int[] list, int k ){
        int[] ret = new int[list.length];
        int j = list.length - 1;
        for (int i = list.length - 1; i >= 0; i --){
            while (j >= 0 && list[j] - list[i] > k) {j --; }
            ret[i] = j;
        }
        return ret;
    }
    public static int[] getLeftmost(int[] list, int k){
        int[] ret = new int[list.length];
        int j = 0;
        for (int i = 0; i < list.length; i ++){
            while (j < list.length && list[i] - list[j] > k){ j ++; }
            ret[i] = j;
        }
        return ret;
    }
}
