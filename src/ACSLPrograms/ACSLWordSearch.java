package ACSLPrograms;
import java.util.*;

public class ACSLWordSearch {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String rows_cols = scan.nextLine();
        String gridLetters = scan.nextLine();
        String words = scan.nextLine();
        String[] arr = rows_cols.split(" ");
        int row = Integer.parseInt(arr[0]), col = Integer.parseInt(arr[1]);
        char[][] grid = new char[row][col];
        int pos = 0;
        for (int i = 0; i < row; i ++){
            for (int j = 0; j < col; j ++){
                grid[i][j] = gridLetters.charAt(pos);
                pos ++;
            }
        }
        String[][] finished_letters = new String[row][col];
        String[] word = words.split(" ");
        ArrayList<String> letters = null;
        for (int x = 0; x < word.length; x ++){
            for (int i = 0; i < row; i++){
                for (int j = 0; j < col; j++){
                    pos = 0;
                    if (grid[i][j] == word[x].charAt(pos)){
                        int r = i, c = j;
                        pos ++;
                        boolean flag = false;
                        if (r + 1 < row && grid[r + 1][c] == word[x].charAt(1)){
                            letters = new ArrayList<>();
                            letters.add(i + " " + j);
                            while (pos < word[x].length() && r + 1 < row && grid[r + 1][c] == word[x].charAt(pos)) {r = r+1; letters.add( r + " " + c); pos ++;}
                            r = i; c = j;
                        }
                        if(pos < word[x].length() && c + 1 < col && grid[r][c + 1] == word[x].charAt(1)){
                            letters = new ArrayList<>();
                            letters.add(i + " " + j); pos = 1;
                            while(pos < word[x].length() && c + 1 < col && grid[r][c + 1] == word[x].charAt(pos)) {c = c+1; letters.add( r + " " + c); pos ++; }
                            r = i; c = j;
                        }
                        if (pos < word[x].length() && r > 0 && grid[r - 1][c] == word[x].charAt(1)){
                            letters = new ArrayList<>();
                            letters.add(i + " " + j); pos = 1;
                            while(pos < word[x].length() && r > 0 && grid[r - 1][c] == word[x].charAt(pos)) {r = r-1; letters.add( r + " " + c); pos ++; }
                            r = i; c = j;
                        }
                        if (pos < word[x].length() && c > 0 && grid[r][c - 1] == word[x].charAt(1)){
                            letters = new ArrayList<>();
                            letters.add(i + " " + j); pos = 1;
                            while(pos < word[x].length() && c > 0 && grid[r][c - 1] == word[x].charAt(pos)) {c = c - 1; letters.add( r + " " + c); pos ++;}
                            r = i; c = j;
                        }
                        if (pos < word[x].length() && r + 1 < row && c + 1< col && grid[r + 1][c + 1] == word[x].charAt(1)){
                            letters = new ArrayList<>();
                            letters.add(i + " " + j); pos = 1;
                            while (pos < word[x].length() && r + 1 < row && c + 1< col && grid[r + 1][c + 1] == word[x].charAt(pos)) {r = r+1; c ++; letters.add( r + " " + c); pos ++;}
                            r = i; c = j;
                        }
                        if (pos < word[x].length() && r + 1 < row && c > 0 && grid[r + 1][c - 1] == word[x].charAt(1)){
                            letters = new ArrayList<>();
                            letters.add(i + " " + j); pos = 1;
                            while (pos < word[x].length() && r + 1 < row && c > 0 && grid[r + 1][c - 1] == word[x].charAt(pos)) {r = r+1; c --; letters.add( r + " " + c); pos ++;}
                            r = i; c = j;
                        }
                        if (pos < word[x].length() && r > 0 && c + 1 < col && grid[r - 1][c + 1] == word[x].charAt(1)){
                            letters = new ArrayList<>();
                            letters.add(i + " " + j); pos = 1;
                            while (pos < word[x].length() && r > 0 && c + 1 < col && grid[r - 1][c + 1] == word[x].charAt(pos)) {r --; c ++; letters.add( r + " " + c); pos ++;}
                            r = i; c = j;
                        }
                        if (pos < word[x].length() && r > 0 && c > 0 && grid[r - 1][c - 1] == word[x].charAt(1)){
                            letters = new ArrayList<>();
                            letters.add(i + " " + j); pos = 1;
                            while (pos < word[x].length() && r > 0 && c > 0 && grid[r - 1][c - 1] == word[x].charAt(pos)) {r --; c --; letters.add( r + " " + c);}
                        }
                        if (pos == word[x].length()){
                            for (int a = 0; a < letters.size(); a ++){
                                arr = letters.get(a).split(" ");
                                finished_letters[Integer.parseInt(arr[0])][Integer.parseInt(arr[1])] = "*";
                            }
                        }
                    }
                }
            }
        }
        String ans = "";
        for (int r = 0; r < row; r ++) {
            for (int c = 0; c < col; c++) {
                if (finished_letters[r][c] != "*") ans += grid[r][c];
            }
        }
        System.out.println(ans);
    }
}
