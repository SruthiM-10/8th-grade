package JavaPrograms;
import java.io.*;
import java.util.*;

//(CSES) USACO Guide Section "More on Sorted Sets"

public class ConcertTickets {
    static TreeMap<Integer, Integer> multiset = new TreeMap<>();
    static void add(int x){
        if (multiset.containsKey(x)) multiset.put(x, multiset.get(x) + 1);
        else multiset.put(x, 1);
    }
    static void remove(int x){
        multiset.put(x, multiset.get(x) - 1);
        if (multiset.get(x) == 0) multiset.remove(x);
    }
    public static void main(String[] args) throws IOException{
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        String s = read.readLine(); String[] arr = s.split(" ");
        int N = Integer.parseInt(arr[0]), M = Integer.parseInt(arr[1]);

        s = read.readLine(); arr = s.split(" ");
        for (int i = 0; i < N; i ++){
            add(Integer.parseInt(arr[i]));
        }
        s = read.readLine(); arr = s.split(" ");
        for (int i = 0; i < M; i ++){
            int maxPrice = Integer.parseInt(arr[i]);
            if (multiset.isEmpty() || maxPrice < multiset.firstKey()){
                System.out.println(-1);
                continue;
            }
            int price = multiset.floorKey(maxPrice);
            System.out.println(price);
            remove(price);
        }
    }
}
