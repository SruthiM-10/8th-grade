package USACOPrograms;
import java.io.*;
import java.util.*;

//USACO 2017 Dec Contest, Silver

public class MilkMeasurement {
    public static class Measurement implements Comparable<Measurement>{
        int day, id, change;
        public Measurement(int day, int id, int change){
            this.day = day;
            this.id = id;
            this.change = change;
        }
        public int compareTo(Measurement a) {
            return Integer.compare(this.day, a.day);
        }
    }
    public static TreeMap<Integer, Integer> multiset = new TreeMap<>();
    // maps each amount of milk to its frequency
    public static void add(int x){
        if (multiset.containsKey(x)) multiset.put(x, multiset.get(x) + 1);
        else multiset.put(x, 1);
    }
    public static void remove(int x){
        if (multiset.containsKey(x)){
            multiset.put(x, multiset.get(x) - 1);
            if (multiset.get(x) == 0) multiset.remove(x);
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader read = new BufferedReader (new FileReader("measurement.in"));
        BufferedWriter write = new BufferedWriter (new FileWriter ("measurement.out"));
        String s = read.readLine(); String[] arr = s.split(" ");
        int N = Integer.parseInt(arr[0]), G = Integer.parseInt(arr[1]);

        Measurement[] logs = new Measurement[N];
        for (int i = 0; i < N; i ++){
            s = read.readLine(); arr = s.split(" ");
            char c = arr[2].charAt(0);
            int change = Integer.parseInt(arr[2].substring(1));
            if (c == '-') change *= -1;
            logs[i] = new Measurement((Integer.parseInt(arr[0])), Integer.parseInt(arr[1]), change);
        }
        Arrays.sort(logs);

        int changedDays = 0;
        TreeMap<Integer, Integer> cows = new TreeMap<>();
        // maps each cow to its milk output

        multiset.put(G, N);
        for (int i = 0; i < N; i ++){
            int id = logs[i].id, change = logs[i].change;

            int milkAmt = cows.getOrDefault(id, G);
            boolean wasTop = milkAmt == multiset.lastKey();
            int prevCount = multiset.get(milkAmt);

            remove(cows.getOrDefault(id, G));
            cows.put(id, cows.getOrDefault(id, G) + change);
            add(cows.getOrDefault(id, G));

            milkAmt = cows.get(id);
            boolean isTop = milkAmt == multiset.lastKey();
            int currCount = multiset.get(milkAmt);
            if (wasTop){
                if (isTop && currCount == prevCount) continue;
                changedDays ++;
            }
            else if (isTop) changedDays ++;
        }
        write.write(changedDays + "");
        write.close();
    }
}
