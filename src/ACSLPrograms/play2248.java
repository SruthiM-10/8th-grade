package ACSLPrograms;
import java.util.*;

public class play2248 {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        String boardValues = scan.nextLine();
        String[] boardValue2 = boardValues.split(" ");
        String[] boardValue = new String[boardValue2.length];
        int pos = 0, maxPower = 0;
        for (int i = 0; i < boardValue2.length; i ++){
            if (!boardValue2[i].equals("") && !boardValue2[i].equals(" ")){
                boardValue[pos] = boardValue2[i]; pos ++;
            }
        }
        ArrayList<ArrayList<Integer>> board = new ArrayList<>();
        for (int i = 0; i < 8; i ++){
            board.add(new ArrayList<>());
            for (int j = 0; j < 5; j ++){
                board.get(i).add(Integer.parseInt(boardValue[5*i + j]));
                if (powerOf(board.get(i).get(j)) > maxPower)
                    maxPower = powerOf(board.get(i).get(j));
            }
        }
        //path
        int i = 0, j = 0, sum = 0;
        //start
        while (true){
            int value = board.get(i).get(j);
            if (j < 4 && board.get(i).get(j + 1) == value){
                sum += value;
                board.get(i).set(j, 0); j ++;
                break;
            }
            else if (i < 7 && j > 0 && board.get(i + 1).get(j - 1) == value) {
                sum += value;
                board.get(i).set(j, 0); i ++; j --;
                break;
            }
            else if (i < 7 && board.get(i + 1).get(j) == value){
                sum += value;
                board.get(i).set(j, 0); i ++;
                break;
            }
            else if (i < 7 && j < 4 && board.get(i + 1).get(j + 1) == value) {
                sum += value;
                board.get(i).set(j, 0); i ++; j ++;
                break;
            }
            else{
                if (j < 4) j ++;
                else {i ++; j = 0;}
            }
        }
        //rest of the path
        while(true){
            int value = board.get(i).get(j);
            if (j > 0 && (board.get(i).get(j - 1) == value || board.get(i).get(j - 1) == value * 2)){
                sum += value;
                board.get(i).set(j, 0); j --;
            }
            else if (j < 4 && (board.get(i).get(j + 1) == value
                    || board.get(i).get(j + 1) == value * 2)){
                sum += value;
                board.get(i).set(j, 0); j ++;
            }
            else if (i < 7 && j > 0 && (board.get(i + 1).get(j - 1) == value
                    || board.get(i + 1).get(j - 1) == value * 2)) {
                sum += value;
                board.get(i).set(j, 0); i ++; j --;
            }
            else if (i < 7 && (board.get(i + 1).get(j) == value
                    || board.get(i + 1).get(j) == value * 2)){
                sum += value;
                board.get(i).set(j, 0); i ++;
            }
            else if (i < 7 && j < 4 && (board.get(i + 1).get(j + 1) == value
                    || board.get(i + 1).get(j + 1) == value * 2)) {
                sum += value;
                board.get(i).set(j, 0); i ++; j ++;
            }
            else break;
        }
        //replacing last tile
        sum += board.get(i).get(j);
        int power = powerOf(sum);
        board.get(i).set(j, (int) Math.pow(2, power));
        //8 powers of 2
        if (power > maxPower){
            for (int r = 0; r < 8; r ++){
                for (int c = 0; c < 5; c ++){
                    if (powerOf(board.get(r).get(c)) <= power - 8) board.get(r).set(c, 0);
                }
            }
        }
        //moving the tiles down
        for (int c = 0; c < 5; c ++){
            ArrayList<Integer> newCol = new ArrayList<>();
            int zeros = 0;
            for (int r = 0; r < 8; r ++){
                if (board.get(r).get(c) == 0) zeros ++;
                else newCol.add(board.get(r).get(c));
            }
            for (int z = 0; z < zeros; z ++) board.get(z).set(c, 0);
            for (int z = zeros; z < 8; z ++) board.get(z).set(c, newCol.get(z - zeros));
        }
        //Filling in empty locations
        if (power < 8) power = 8;
        int original = power;
        for (int r = 0; r < 8; r ++){
            for (int c = 0; c < 5; c ++){
                if (board.get(r).get(c) == 0){
                    board.get(r).set(c, (int) Math.pow(2, power));
                    power --;
                    if (power == original - 8) power = original;
                }
            }
        }
        //output
        String ans = "";
        for (int r = 0; r < 8; r ++){
            for (int c = 0; c < 5; c ++){
                ans += board.get(r).get(c) + " ";
            }
        }
        System.out.println(ans);
    }
    public static int powerOf (int number){
        int pow = 0;
        while (true){
            pow ++;
            if ((int) Math.pow(2, pow) >= number) break;
        }
        return pow;
    }
}
