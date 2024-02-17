package USACOPrograms;
import java.util.*;

//USACO 2024 January Contest (Bronze)

public class MajorityOpinion {
    public static void main(String[] args) {
        Scanner scan = new Scanner (System.in);
        int T = scan.nextInt();
        for (int testcase = 0; testcase < T; testcase ++){
            int N = scan.nextInt(), numOfTypes = 0;
            ArrayList<Integer> haytypes = new ArrayList<>();
            boolean[] successful_type = new boolean[N];
            Arrays.fill(successful_type, false);
            for (int i = 0; i < N; i ++){
                int type = scan.nextInt();
                if (type > numOfTypes) numOfTypes = type;
                haytypes.add(type);
                if (successful_type[type - 1]) continue;
                if (i != 0 && haytypes.get(i).equals(haytypes.get(i - 1))){
                    successful_type[type - 1] = true;
                }
                if (i >= 2 && haytypes.get(i).equals(haytypes.get(i - 2))){
                    successful_type[type - 1] = true;
                }
            }
            boolean print = false;
            for (int i = 0; i < numOfTypes; i ++){
                if (successful_type[i] && !print) {
                    System.out.print((i + 1)); print = true;
                }
                else if (successful_type[i]) System.out.print(" " + (i + 1));
                else if (i == numOfTypes - 1 && !print) System.out.print("-1");
            }
            if (testcase < T - 1) System.out.println();
        }
    }
}
