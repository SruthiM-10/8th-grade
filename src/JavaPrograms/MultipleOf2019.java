package JavaPrograms;

import java.util.*;

public class MultipleOf2019 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String s = scan.nextLine();
        int pow = 1;
        Map<Integer, Integer> mods = new HashMap<>();
        mods.put(0, 1); // maps each mod to its frequency

        int num = 0;
        for (int i = s.length() - 1; i >= 0; i --){
            num = (num + pow * (s.charAt(i) - '0')) % 2019;
            pow = (pow * 10) % 2019;
            mods.put(num, mods.getOrDefault(num, 0) + 1);
        }
        int ans = 0;
        for (int mod : mods.keySet()){
            ans += (mods.get(mod)) * (mods.get(mod) - 1)/2;
        }
        System.out.println(ans);
    }
}
