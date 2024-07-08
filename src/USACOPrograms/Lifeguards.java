package USACOPrograms;
import java.io.*;
import java.util.*;

//USACO 2018 Jan Contest, Silver

public class Lifeguards {
    public static class Lifeguard implements Comparable<Lifeguard>{
        int time, lifeguardNum;
        public Lifeguard(int time, int lifeguardNum){
            this.time = time;
            this.lifeguardNum = lifeguardNum;
        }
        public int compareTo(Lifeguard a){
            return Integer.compare(time, a.time);
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader read = new BufferedReader( new FileReader("lifeguards.in"));
        BufferedWriter write = new BufferedWriter (new FileWriter("lifeguards.out"));
        int N = Integer.parseInt(read.readLine());
        Lifeguard[] times = new Lifeguard[2 * N];
        for (int i = 0; i < N; i ++){
            String s = read.readLine();
            String[] arr = s.split(" ");
            int a = Integer.parseInt(arr[0]), b = Integer.parseInt(arr[1]);
            times[2 * i] = new Lifeguard(a, i);
            times[2 * i + 1] = new Lifeguard(b, i);
        }
        Arrays.sort(times);
        TreeSet<Integer> set = new TreeSet<>();
        int[] aloneTime = new int[N];
        int actualCover = 0, last = 0;
        for (Lifeguard out: times){
            if (set.size() == 1){
                aloneTime[set.first()] += out.time - last;
            }
            if (!set.isEmpty()){
                actualCover += out.time - last;
            }
            if (set.contains(out.lifeguardNum)){
                set.remove(out.lifeguardNum);
            }
            else
                set.add(out.lifeguardNum);
            last = out.time;
        }
        int ans = 0;
        for (int out: aloneTime){
            ans = Math.max(ans, actualCover - out);
        }
        write.write(ans + "");
        write.close();
    }
}
