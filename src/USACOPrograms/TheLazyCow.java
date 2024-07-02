package USACOPrograms;
import java.io.*;

//USACO 2014 March Contest, Silver

public class TheLazyCow {
    public static void main(String[] args) throws IOException {
        BufferedReader read = new BufferedReader (new FileReader ("lazy.in"));
        BufferedWriter write = new BufferedWriter (new FileWriter ("lazy.out"));
        String s = read.readLine();
        String[] arr = s.split(" ");
        int N = Integer.parseInt(arr[0]), K = Integer.parseInt(arr[1]);
        int[][] field = new int[N][N];
        for (int i = N - 1; i >= 0; i --){
            s = read.readLine();
            arr = s.split(" ");
            for (int j = 0; j < N; j ++){
                field[i][j] = Integer.parseInt(arr[j]);
            }
        }
        int[][] newField = new int[2 * N - 1][2 * N - 1];
        for (int i = 0; i < 2*N - 1; i ++){
            for (int j = 0; j < 2*N - 1; j ++){
                newField[i][j] = -1;
            }
        }
        for (int i = 0; i < N; i ++){
            for (int j = 0; j < N; j ++){
                newField[N - 1 - j + i][j + i] = field[i][j];
            }
        }

        int[][] prefix = new int[2*N][2*N];
        for (int i = 1; i < 2*N; i ++){
            for (int j = 1; j < 2*N; j ++){
                int val = Math.max(newField[i - 1][j - 1], 0);
                prefix[i][j] =
                        val + prefix[i][j - 1] + prefix[i - 1][j] - prefix[i - 1][j - 1];
            }
        }

        int mostGrass = 0;
        for (int i = K; i < 2*N - 1 - K; i ++){
            for (int j = K; j < 2*N - 1 - K; j ++){
                if (newField[i][j] == -1) continue;
                mostGrass = Math.max(mostGrass, prefix[i + K + 1][j + K + 1] -
                                                prefix[i - K][j + K + 1] -
                                                prefix[i + K + 1][j - K] +
                                                prefix[i - K][j - K]);
            }
        }
        if (K >= N)
            mostGrass = prefix[2 * N - 1][2 * N - 1];
        write.write(mostGrass + "");
        write.close();
    }
}
