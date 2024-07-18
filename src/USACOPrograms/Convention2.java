package USACOPrograms;
import java.io.*;
import java.util.*;

//USACO 2018 Dec Contest, Silver

public class Convention2 {
    public static class Cow implements Comparable<Cow>{
        int arrival, time, senior;
        Cow(int arrival, int time, int senior){
            this.arrival = arrival;
            this.time = time;
            this.senior = senior;
        }
        public int compareTo(Cow a){
            if (this.arrival == a.arrival){
                return Integer.compare(this.senior, a.senior);
            }
            return Integer.compare(this.arrival, a.arrival);
        }
    }
    public static void main(String[] args) throws IOException{
//        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader read = new BufferedReader(new FileReader("convention2.in"));
        BufferedWriter write = new BufferedWriter (new FileWriter("convention2.out"));
        int N = Integer.parseInt(read.readLine());

        Cow[] unsortedCows = new Cow[N];
        Cow[] cows = new Cow[N];
        for (int i = 0; i < N; i ++){
            String s = read.readLine(); String[] arr = s.split(" ");
            unsortedCows[i] = new Cow(Integer.parseInt(arr[0]), Integer.parseInt(arr[1]), i);
            cows[i] = unsortedCows[i];
        }
        Arrays.sort(cows);

        ArrayList<TreeSet<Integer>> lines = new ArrayList<>();
        ArrayList<Integer> endTimes = new ArrayList<>();
        endTimes.add(0);
        boolean waiting = false;
        int runningTime = 0;
        for (int i = 0; i < N; i ++){
            int endTime = Collections.max(endTimes) + runningTime;
            if (cows[i].arrival > endTime){
                endTimes.add(cows[i].arrival + cows[i].time);
                runningTime = 0;
                waiting = false;
            }
            else{
                TreeSet<Integer> newVal = new TreeSet<>();
                if (!waiting) {
                    newVal.add(cows[i].senior);
                    lines.add(newVal);
                    waiting = true;
                }
                else{
                    newVal = lines.get(lines.size() - 1);
                    newVal.add(cows[i].senior);
                    lines.set(lines.size() - 1, newVal);
                }
                runningTime += cows[i].time;
            }
        }

        int runningSum = 0, maxWait = 0;
        for (int i = 0; i < lines.size(); i ++){
            TreeSet<Integer> line = lines.get(i);
            int endTime = endTimes.get(i + 1);
            for (Integer cow : line) {
                maxWait = Math.max(maxWait, endTime - unsortedCows[cow].arrival + runningSum);
                runningSum += unsortedCows[cow].time;
            }
            runningSum = 0;
        }
//        System.out.println(maxWait);
        write.write(maxWait + "");
        write.close();
    }
}
