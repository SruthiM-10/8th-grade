package USACOPrograms;
import java.io.*;

//2017 January Silver Contest

public class HoofPaperScissors {
    public static void main(String[] args) throws IOException{
        BufferedReader scan = new BufferedReader (new FileReader ("hps.in"));
        BufferedWriter write = new BufferedWriter (new FileWriter ("hps.out"));
        int N = Integer.parseInt(scan.readLine());
        int[] paperWins = new int[N + 1];
        int[] hoofWins = new int[N + 1];
        int[] scissorWins = new int[N + 1];
        for (int i = 0; i < N; i ++){
            String sign = scan.readLine();
            if (sign.equals("H")) paperWins[i + 1] = paperWins[i] + 1; else paperWins[i + 1] = paperWins[i];
            if (sign.equals("S")) hoofWins[i + 1] = hoofWins[i] + 1; else hoofWins[i + 1] = hoofWins[i];
            if (sign.equals("P")) scissorWins[i + 1] = scissorWins[i] + 1; else scissorWins[i + 1] = scissorWins[i];
        }
        int ans = 0;
        for (int x = 1; x <= N; x ++){
            //first x games
            int games1 = Math.max(Math.max(paperWins[x], hoofWins[x]), scissorWins[x]);
            //last N - x games
            int games2 = Math.max(Math.max(paperWins[N] - paperWins[x], hoofWins[N] - hoofWins[x]), scissorWins[N] - scissorWins[x]);
            ans = Math.max(ans, games1 + games2);
        }
        write.write(ans + "");
        write.close();
    }
}
