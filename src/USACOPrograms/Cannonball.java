package USACOPrograms;
import java.util.*;

//USACO 2024 January Contest (Bronze)

public class Cannonball {
    static class Numberline{
        int type, power;
    }
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt(), S = scan.nextInt(), targets = 0, tot_targets = 0;
        long count = 0;
        Numberline[] location = new Numberline[N];
        boolean[] target = new boolean[N];

        for (int i = 0; i < N; i ++){
            location[i] = new Numberline();
            location[i].type = scan.nextInt();
            if (location[i].type == 1) tot_targets ++;
            location[i].power = scan.nextInt();
        }
        int pos = S - 1, power = 1, direction = 1;
        while (pos >= 0 && pos < N && count <= Math.pow(10, 8)){
            if (location[pos].type == 1 && Math.abs(power) >= location[pos].power && !target[pos]){
                targets ++; target[pos] = true;
                if (targets == tot_targets) break;
            }
            else if (location[pos].type == 0){
                if (direction == -1) power -= location[pos].power;
                else power += location[pos].power;
                power *= -1; direction *= -1;
            }
            pos += power;
            count ++;
        }
        System.out.println(targets);
    }
}
