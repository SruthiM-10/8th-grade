package USACOPrograms;
import java.io.*;
import java.util.TreeSet;

//USACO 2016 Jan Contest, Silver

public class AngryCows {
    static TreeSet<Integer> haybales;
    static int cows;
    public static void main(String[] args) throws IOException{
        BufferedReader read = new BufferedReader(new FileReader("angry.in"));
        BufferedWriter write = new BufferedWriter(new FileWriter("angry.out"));
        String s = read.readLine(); String[] arr = s.split(" ");
        int N = Integer.parseInt(arr[0]);
        cows = Integer.parseInt(arr[1]);
        haybales = new TreeSet<>();
        for (int i = 0; i < N; i ++){
            haybales.add(Integer.parseInt(read.readLine()));
        }
        // looping through values of R
        int l = 0;
        int h = haybales.last() - haybales.first();
        while (l < h){
            int mid = (l + h)/2;
            if (check(mid)) h = mid;
            else l = mid + 1;
        }
        write.write(l + "");
        write.close();
    }
    private static boolean check(int R){
        int first = haybales.first();
        for (int i = 0; i < cows; i ++) {
            int highestNum = first + 2 * R;
            if (haybales.higher(highestNum) != null) first = haybales.higher(highestNum);
            else return true;
        }
        return false;
    }
}
