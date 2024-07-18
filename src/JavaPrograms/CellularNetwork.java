package JavaPrograms;
import java.io.*;
import java.util.*;

//(CF) USACO Guide Section "More on Sorted Sets"

public class CellularNetwork {
    public static void main(String[] args) throws IOException{
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        String s = read.readLine(); String[] arr = s.split(" ");
        int N = Integer.parseInt(arr[0]), M = Integer.parseInt(arr[1]);

        int[] cities = new int[N];
        TreeSet<Integer> towers = new TreeSet<>();

        s = read.readLine(); arr = s.split(" ");
        for (int i =0 ; i< N; i ++) cities[i] = Integer.parseInt(arr[i]);
        s = read.readLine(); arr = s.split(" ");
        for (int i = 0; i < M; i ++) towers.add(Integer.parseInt(arr[i]));

        int r = 0;
        for (int i = 0; i < N; i ++){
            int value;
            if (towers.floor(cities[i]) != null && towers.ceiling(cities[i]) != null) {
                value = Math.min(cities[i] - towers.floor(cities[i]), towers.ceiling(cities[i]) - cities[i]);
                r = Math.max(r, value);
            }
            else if (towers.floor(cities[i]) != null)
                r = Math.max(r, cities[i] - towers.floor(cities[i]));
            else if (towers.ceiling(cities[i]) != null)
                r = Math.max(r, towers.ceiling(cities[i]) - cities[i]);
        }
        System.out.println(r);
    }
}
