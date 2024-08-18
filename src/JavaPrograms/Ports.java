package JavaPrograms;
import java.io.*;
import java.util.Arrays;

//(CF) USACO Guide Section "Greedy Algorithms with Sorting"

public class Ports {
    static class Mouse implements Comparable<Mouse>{
        int cost;
        boolean type; //true = USB, false = PS/2
        Mouse(int cost, String type){
            this.cost = cost;
            this.type = type.equals("USB");
        }
        public int compareTo(Mouse a){
            return Integer.compare(this.cost, a.cost);
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader read = new BufferedReader (new InputStreamReader(System.in));
        String s = read.readLine(); String[] arr = s.split(" ");
        int a = Integer.parseInt(arr[0]), b = Integer.parseInt(arr[1]);
        int c = Integer.parseInt(arr[2]);
        int m = Integer.parseInt(read.readLine());

        Mouse[] mouses = new Mouse[m];
        for (int i = 0; i < m; i ++){
            s = read.readLine(); arr = s.split(" ");
            mouses[i] = new Mouse(Integer.parseInt(arr[0]), arr[1]);
        }
        Arrays.sort(mouses);

        long computers = 0, totalCost = 0;
        for (Mouse i : mouses){
            if (a + b + c == 0) break;
            totalCost += i.cost;
            computers ++;
            if (i.type){
                if (a > 0) a --;
                else if (c > 0) c --;
                else{ totalCost -= i.cost; computers --; }
            }
            else{
                if (b > 0) b --;
                else if (c > 0) c --;
                else{ totalCost -= i.cost; computers --; }
            }
        }
        System.out.println(computers + " " + totalCost);
    }
}
