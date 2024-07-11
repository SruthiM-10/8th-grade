package JavaPrograms;
import java.io.*;

//(CSES Problem) USACO Guide Two Pointers

public class SubarraySumsI {
    public static void main(String[] args) throws IOException{
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        String s = read.readLine();
        String[] arr = s.split(" ");
        int N = Integer.parseInt(arr[0]), X = Integer.parseInt(arr[1]);
        s = read.readLine(); arr = s.split(" ");

        int[] num = new int[N];
        for (int i = 0; i < N; i ++){
            num[i] = Integer.parseInt(arr[i]);
        }
        int ans = 0;
        int left = 0, right = 0, cur = 0;
        while (left < N && right < N){
            while (right < N){
                cur += num[right];
                right ++;
                if (cur == X) {
                    ans++;
                    break;
                }
                if (cur > X){
                    cur -= num[right - 1];
                    right --;
                    break;
                }
            }
            if (left == right) right ++;
            if (cur != 0) cur -= num[left];
            left ++;
        }
        System.out.println(ans);
    }
}
