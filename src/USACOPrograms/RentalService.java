package USACOPrograms;
import java.io.*;
import java.util.*;

//USACO 2018 Jan Contest, Silver -> 7/10 solution below
// Corrections:
    // primitive arrays to save space
    // For calculating how much money this cow can make if we sell its milk, we just used a nested while loop
    // Main solution: at each step either milk the highest-producing cow or rent the lowest-producing cow, depending
    // on each respective cost

public class RentalService {
    public static class Comp implements Comparator<int[]>{
        public int compare(int[] o1, int[] o2) {
            return -Integer.compare(o1[1], o2[1]);
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader read = new BufferedReader (new FileReader("rental.in"));
        BufferedWriter write = new BufferedWriter (new FileWriter ("rental.out"));
        String s = read.readLine();
        String[] arr = s.split(" ");
        int N = Integer.parseInt(arr[0]), M = Integer.parseInt(arr[1]), R = Integer.parseInt(arr[2]);
        ArrayList<Integer> milk = new ArrayList<>();
        for (int i = 0; i < N; i ++){
            milk.add(Integer.parseInt(read.readLine()));
        }
        milk.sort(Collections.reverseOrder());

        ArrayList<int[]> stores = new ArrayList<>();
        int maxGal = 0;
        for (int i = 0; i < M; i ++){
            s = read.readLine();
            arr = s.split(" ");
            stores.add(new int[]{Integer.parseInt(arr[0]), Integer.parseInt(arr[1])});
            maxGal += Integer.parseInt(arr[0]);
        }
        stores.sort(new Comp());
        long[] costs = new long[maxGal + 1];
        int pos = 1, storeNum = 0;
        long num = costs[1];
        for (int i = 1; i < maxGal + 1; i ++){
            if (i == pos){
                costs[pos] = stores.get(storeNum)[1];
                pos += stores.get(storeNum)[0];
                storeNum ++;
            }
            if (costs[i] == 0) costs[i] = costs[i - 1] + num;
            else{ num = costs[i]; costs[i] += costs[i - 1]; }
        }

        ArrayList<Integer> rents = new ArrayList<>();
        for (int i = 0; i < R; i ++){
            rents.add(Integer.parseInt(read.readLine()));
        }
        rents.sort(Collections.reverseOrder());

        int finished = 0, finished2 = 0;
        long profit1 = 0, profit2 = 0;
        pos = 0;
        int pos2 = 0;

        long[] milkMax = new long[N];
        ArrayList<Integer> rentIndices = new ArrayList<>();
        long[] rentMax = new long[N];
        ArrayList<Integer> milkIndices = new ArrayList<>();
        for (int i = 0; i < N; i ++){
            if (finished + milk.get(i) < maxGal + 1) {
                milkMax[i] = costs[finished + milk.get(i)] - costs[finished];
                finished += milk.get(i);
            }
            else{
                milkMax[i] = rents.get(pos);
                pos ++;
                rentIndices.add(i);
            }
            if (i < R){
                rentMax[i] = rents.get(i);
            }
            else{
                rentMax[i] = costs[finished2 + milk.get(pos2)] - costs[finished2];
                finished2 += milk.get(pos2);
                pos2 ++;
                milkIndices.add(i);
            }
            profit1 += milkMax[i];
            profit2 += rentMax[i];
        }

        long profit = 0;
        if (profit2 > profit1){
            for (int i = N - 1; i >= 0; i --){
                if (!milkIndices.contains(i)){
                    long newCost = costs[finished2 + milk.get(pos2)] - costs[finished2];
                    if (newCost > rentMax[i]){
                        rentMax[i] = newCost;
                        finished2 += milk.get(pos2);
                        pos2 ++;
                    }
                }
                profit += rentMax[i];
            }
        }
        else {
            for (int i = N - 1; i >= 0; i--) {
                if (!rentIndices.contains(i)) {
                    int newCost = rents.get(pos);
                    if (newCost > milkMax[i]) {
                        milkMax[i] = newCost;
                        pos++;
                    }
                }
                profit += milkMax[i];
            }
        }
        write.write(profit + "");
        write.close();
    }
}
