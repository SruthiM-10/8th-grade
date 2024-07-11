package USACOPrograms;
import java.io.*;
import java.util.*;

//USACO 2017 US Open Contest, Silver

public class PairedUp {
    public static class MilkToCows{
        public int milk, cows;
        public MilkToCows(int milk, int cows){
            this.milk = milk;
            this.cows = cows;
        }
    }
    public static class Comp implements Comparator<MilkToCows>{
        public int compare(MilkToCows a, MilkToCows b){
            return Integer.compare(a.milk, b.milk);
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader read = new BufferedReader (new FileReader("pairup.in"));
        BufferedWriter write = new BufferedWriter (new FileWriter("pairup.out"));
        int N = Integer.parseInt(read.readLine());
        ArrayList<MilkToCows> data = new ArrayList<>();
        for (int i = 0; i < N; i ++){
            String s = read.readLine(); String[] arr = s.split(" ");
            int milk = Integer.parseInt(arr[1]), cows = Integer.parseInt(arr[0]);
            data.add(new MilkToCows(milk, cows));
        }
        data.sort(new Comp());

        int time = 0;
        while (!data.isEmpty()){
            int length = data.size();
            if (length > 1) {
                int milk1 = data.get(0).milk, cow1 = data.get(0).cows;
                int milk2 = data.get(length - 1).milk, cow2 = data.get(length - 1).cows;
                time = Math.max(time, milk2 + milk1);
                data.get(0).cows -= Math.min(cow1, cow2);
                data.get(length - 1).cows -= Math.min(cow1, cow2);
                if (data.get(length - 1).cows == 0)
                    data.remove(length - 1);
                if (data.get(0).cows == 0)
                    data.remove(0);
            }
            else{
                time = Math.max(time, 2 * data.get(0).milk);
                data.remove(0);
            }
        }
        write.write(time + "");
        write.close();
    }
}
