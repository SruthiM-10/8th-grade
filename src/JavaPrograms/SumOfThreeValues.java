package JavaPrograms;
import java.io.*;
import java.util.*;

//(CSES) USACO Guide Section Two Pointers

public class SumOfThreeValues {
    public static class Number{
        int index;
        long num;
        public Number (int index, long num){
            this.index = index;
            this.num = num;
        }
    }
    public static class Comp implements Comparator<Number>{
        public int compare(Number a, Number b){
            return Long.compare(a.num, b.num);
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        String s = read.readLine();
        String[] arr = s.split(" ");
        int N = Integer.parseInt(arr[0]);
        long X = Long.parseLong(arr[1]);
        s = read.readLine(); arr = s.split(" ");

        Number[] num = new Number[N];
        for (int i = 0; i < N; i ++){
            num[i] = new Number(i, Long.parseLong(arr[i]));
        }
        Arrays.sort(num, new Comp());

        int left = 0, middle = 1, right = 2;
        boolean flag = true;
        for (int i = 0; i < N && flag; i ++){
            left = 0; right = N - 1;
            while (left != right){
                long target = X - num[i].num;
                if (left != i && right != i && num[left].num + num[right].num == target){
                    flag = false;
                    middle = i;
                    break;
                }
                if (num[left].num + num[right].num < target) left++;
                else right --;
            }
        }
        if (N == 1 || N == 2 || flag)
            System.out.println("IMPOSSIBLE");
        else {
            int[] indices = new int[3];
            indices[0] = num[left].index + 1;
            indices[1] = num[middle].index + 1;
            indices[2] = num[right].index + 1;
            Arrays.sort(indices);
            System.out.println(indices[0] + " " + indices[1] + " " + indices[2]);
        }
    }
}
