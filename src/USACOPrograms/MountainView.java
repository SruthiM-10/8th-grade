package USACOPrograms;
import java.io.*;
import java.util.*;

//USACO 2019 Jan Contest, Silver

public class MountainView {
    public static class Mountain{
        long startX, endX;
        int mountainNum;
        public Mountain(int startX, int endX, int mountainNum){
            this.startX = startX;
            this.endX = endX;
            this.mountainNum = mountainNum;
        }
    }
    public static class Comp implements Comparator<Mountain> {
        public int compare(Mountain a, Mountain b){
            if (a.startX != b.startX)
                return Long.compare(a.startX, b.startX);
            return -Long.compare(a.endX, b.endX);
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader read = new BufferedReader(new FileReader("mountains.in"));
        BufferedWriter write = new BufferedWriter (new FileWriter ("mountains.out"));
        int N = Integer.parseInt(read.readLine());
        int ans = N;
        Mountain[] mountains = new Mountain[N];
        for (int i = 0; i < N; i ++){
            String s = read.readLine();
            String[] arr = s.split(" ");
            int peak_x = Integer.parseInt(arr[0]), peak_y = Integer.parseInt(arr[1]);
            mountains[i] = new Mountain(peak_x - peak_y, peak_x + peak_y, i);
        }
        Arrays.sort(mountains, new Comp());

        long rightmostEnd = -1;
        for (Mountain obj : mountains) {
            if (obj.endX > rightmostEnd)
                rightmostEnd = obj.endX;
            else
                ans --;
        }
        write.write(ans + "");
        write.close();
    }
}
