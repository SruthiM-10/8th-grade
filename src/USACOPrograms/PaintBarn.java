package USACOPrograms;
import java.io.*;

//USACO 2019 Feb Contest, Silver

public class PaintBarn {
    public static void main(String[] args) throws IOException{
        BufferedReader read = new BufferedReader(new FileReader("paintbarn.in"));
        BufferedWriter write = new BufferedWriter (new FileWriter( "paintbarn.out"));
        String s = read.readLine();
        String[] arr = s.split(" ");
        int N = Integer.parseInt(arr[0]), K = Integer.parseInt(arr[1]);
        int[][] barn = new int[1001][1001];

        for (int i = 0; i < N; i ++){
            s = read.readLine(); arr = s.split(" ");
            int start_x = Integer.parseInt(arr[0]), start_y = Integer.parseInt(arr[1]);
            int end_x = Integer.parseInt(arr[2]), end_y = Integer.parseInt(arr[3]);

            barn[start_x][start_y] ++;
            barn[end_x][end_y] ++;
            barn[start_x][end_y] --;
            barn[end_x][start_y] --;
        }

        int[][] prefix = new int[1001][1001];
        int validArea = 0;
        for (int x = 0; x < 1001; x++){
            for (int y = 0; y < 1001; y ++){
                int value = barn[x][y];
                if (x > 0) value += prefix[x - 1][y];
                if (y > 0) value += prefix[x][y - 1];
                if (x > 0 && y > 0) value -= prefix[x - 1][y - 1];
                prefix[x][y] = value;
                if (value == K) validArea ++;
            }
        }
        write.write(validArea + "");
        write.close();
    }
}
