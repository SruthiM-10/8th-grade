package USACOPrograms;
import java.io.*;
import java.util.*;

//USACO 2017 Jan Contest, Silver

public class CowDanceShow {
    public static void main(String[] args) throws IOException{
        BufferedReader read = new BufferedReader(new FileReader("cowdance.in"));
        BufferedWriter write = new BufferedWriter (new FileWriter("cowdance.out"));
        String s = read.readLine(); String[] arr = s.split(" ");
        int n = Integer.parseInt(arr[0]), maxT = Integer.parseInt(arr[1]);
        int[] cows = new int[n];
        for (int i = 0; i < n; i ++){
            cows[i] = Integer.parseInt(read.readLine());
        }
        int min = 1, max = n; //fast method of looping through all k values to avoid N^2 time complexity
        while (min != max){
            int mid = (min + max)/2; // rounds down because we want to find minimum
            if (possible(cows, mid, maxT)){
                max = mid;
            }
            else {
                min = mid + 1;
            }
        }
        write.write(min + "");
        write.close();
    }
    public static boolean possible(int[] cows, int k, int t){ //simulation
        int lastTime = 0;
        PriorityQueue<Integer> line = new PriorityQueue<>();
        for (int i = 0; i < cows.length; i ++){
            if (line.size() == k && k != 0) lastTime = line.poll();
            if (lastTime + cows[i] > t) return false;
            line.add(lastTime + cows[i]);
        }
        return true;
    }
}
