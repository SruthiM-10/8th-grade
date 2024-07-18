package JavaPrograms;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.TreeMap;

//(CSES) USACO Guide Section "More on Sorted Sets"
//Will TLE due to java's slow speed

public class TrafficLights {
    static TreeMap<Integer, Integer> maxLength = new TreeMap<>();
    public static void add(int x){
        if (maxLength.containsKey(x)){
            maxLength.put(x, maxLength.get(x) + 1);
            return;
        }
        maxLength.put(x, 1);
    }
    public static void remove(int x){
        if (maxLength.containsKey(x)){
            maxLength.put(x, maxLength.get(x) - 1);
            if (maxLength.get(x) == 0) maxLength.remove(x);
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        String s = read.readLine(); String[] arr = s.split (" ");
        int X = Integer.parseInt(arr[0]), N = Integer.parseInt(arr[1]);
        TreeMap<Integer, Integer> intervals = new TreeMap<>();
        add(0); add(X);
        intervals.put(0, X);
        //make a map with all the start and end points of the gaps
        s = read.readLine(); arr = s.split(" ");
        for (int i = 0; i < N; i ++){
            int pos = Integer.parseInt(arr[i]);
            if (intervals.lowerKey(pos) != null){
                int start = intervals.lowerKey(pos);
                int end = intervals.get(start);
                remove(end - start);
                intervals.remove(start);
                intervals.put(pos, end);
                intervals.put(start, pos);
                add(end - pos);
                add(pos - start);
            }
            System.out.print(maxLength.lastKey() + " ");
        }
    }
}
