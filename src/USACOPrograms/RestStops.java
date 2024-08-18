package USACOPrograms;
import java.io.*;
import java.util.Arrays;

//USACO 2018 Feb Contest, Silver

public class RestStops {
    static class RestStop implements Comparable<RestStop>{
        int pos, c;
        RestStop(int pos, int c){
            this.pos = pos;
            this.c = c;
        }
        public int compareTo(RestStop a){
            return -Integer.compare(this.c, a.c);
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader read = new BufferedReader (new FileReader("reststops.in"));
        BufferedWriter write = new BufferedWriter (new FileWriter("reststops.out"));
        String s = read.readLine(); String[] arr = s.split(" ");
        int L = Integer.parseInt(arr[0]), N = Integer.parseInt(arr[1]);
        int rF = Integer.parseInt(arr[2]), rB = Integer.parseInt(arr[3]);

        RestStop[] stops = new RestStop[N];
        for (int i = 0; i < N; i ++){
            s = read.readLine(); arr = s.split(" ");
            stops[i] = new RestStop(Integer.parseInt(arr[0]), Integer.parseInt(arr[1]));
        }
        Arrays.sort(stops);

        int pos = 0;
        long maxUnits = 0;
        for (RestStop stop : stops){
            if (stop.pos > pos){
                int extraDist = stop.pos - pos;
                long extraSec = (long) rF * extraDist - (long) rB * extraDist;
                maxUnits += stop.c * extraSec;
                pos = stop.pos;
            }
        }
        write.write(maxUnits + "");
        write.close();
    }
}
