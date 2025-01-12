package JavaPrograms;
import java.util.*;

//USACO Guide Silver PrefixSums Part 1, Problem: IrreducibleAnagrams on Codeforces

public class IrreducibleAnagrams {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String template = scan.nextLine();
        int queries = scan.nextInt();
        for (int q = 0; q < queries; q ++){
            String s = template.substring(scan.nextInt() - 1, scan.nextInt());
            if (s.length() == 1){
                System.out.println("YES");
                continue;
            }
            if (s.length() == 2){
                if (s.charAt(0) == s.charAt(1))
                    System.out.println("NO");
                else
                    System.out.println("YES");
                continue;
            }
            if (s.charAt(0) != s.charAt(s.length() - 1)){
                System.out.println("YES");
                continue;
            }
            int[] alphabet = new int[26];
            for (int i = 0; i < s.length(); i ++){
                alphabet[s.charAt(i) - 'a'] ++;
            }
            int count = 0;
            for (int i = 0; i < 26; i ++){
                if (alphabet[i] != 0)
                    count ++;
            }
            if (count > 2){
                System.out.println("YES");
                continue;
            }
            System.out.println("NO");
        }
    }
}
