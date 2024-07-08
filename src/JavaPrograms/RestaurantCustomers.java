package JavaPrograms;
import java.util.*;
import java.io.*;

//USACO Guide Silver Custom Comparators Problem 1

public class RestaurantCustomers {
    static class Comp implements Comparator<int[]>{
        public int compare(int[] a, int[] b){
            return Integer.compare(a[0], b[0]);
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        ArrayList<int[]> allTimes = new ArrayList<>();

        for(int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            allTimes.add(new int[]{a, 1});
            allTimes.add(new int[]{b, -1});
        }

        allTimes.sort(new Comp());
        int maxNum = -1;
        int numPeople = 0;
        int numQueries = 0;
        for (int i = 0; i < 2*N; i ++){
            if (numQueries == 2*N)
                break;
            numPeople += allTimes.get(i)[1];
            if (numPeople > maxNum) maxNum = numPeople;
            if (allTimes.get(i)[1] != 0)
                numQueries ++;

        }
        System.out.println(maxNum);
    }
}
