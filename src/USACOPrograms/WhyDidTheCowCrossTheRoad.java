package USACOPrograms;
import java.io.*;
import java.util.*;

//USACO 2017 Feb Contest, Silver

public class WhyDidTheCowCrossTheRoad {
    static class Cow implements Comparable<Cow>{
        int A, B;
        Cow(int a, int b){
            A = a; B = b;
        }
        public int compareTo(Cow c){
            if (this.B == c.B) return Integer.compare(this.A, c.A);
            return Integer.compare(this.B, c.B);
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader read = new BufferedReader(new FileReader("helpcross.in"));
        BufferedWriter write = new BufferedWriter(new FileWriter("helpcross.out"));
        String s = read.readLine(); String[] arr = s.split(" ");
        int C = Integer.parseInt(arr[0]), N = Integer.parseInt(arr[1]);

        TreeMap<Integer, Integer> chickens = new TreeMap<>();
        for (int i = 0; i < C; i ++){
            int key = Integer.parseInt(read.readLine());
            chickens.put(key, chickens.getOrDefault(key, 0) + 1);
        }

        Cow[] cows = new Cow[N];
        for (int i = 0; i < N; i ++){
            s = read.readLine(); arr = s.split(" ");
            cows[i] = new Cow(Integer.parseInt(arr[0]), Integer.parseInt(arr[1]));
        }
        Arrays.sort(cows);

        int pairs = 0;
        for (Cow cow : cows){
            if (chickens.ceilingKey(cow.A) != null){
                int key = chickens.ceilingKey(cow.A);
                if (key <= cow.B) {
                    pairs++;
                    if (chickens.get(key) > 1) chickens.put(key, chickens.get(key) - 1);
                    else chickens.remove(key);
                }
            }
        }
        write.write(pairs + "");
        write.close();
    }
}
