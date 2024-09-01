package ACSLPrograms;
import java.util.*;

public class Thirteen {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int players = scan.nextInt(); scan.nextLine();
        String s = scan.nextLine(), s2 = scan.nextLine(), s3 = scan.nextLine();
        List<String> cards = new ArrayList<>();
        cards.add(0, s); cards.add(1, s2); cards.add(2, s3);

        ArrayList<String[]> playerCards = new ArrayList<>();
        for (int i = 0; i < players; i ++){
            String l = cards.get(i);
            String[] arr = l.split(" ");
            playerCards.add(arr);
        }
        ArrayList<Integer> frequency = new ArrayList<>();
        for (int x = 0; x < 15; x ++) frequency.add(0);
        for (int x = 0; x < playerCards.get(0).length; x ++){
            char val = playerCards.get(0)[x].charAt(0);
            if (val == '3') frequency.set(0, frequency.get(0) + 1);
            if (val == '4') frequency.set(1, frequency.get(1) + 1);
            if (val == '5') frequency.set(2, frequency.get(2) + 1);
            if (val == '6') frequency.set(3, frequency.get(3) + 1);
            if (val == '7') frequency.set(4, frequency.get(4) + 1);
            if (val == '8') frequency.set(5, frequency.get(5) + 1);
            if (val == '9') frequency.set(6, frequency.get(6) + 1);
            if (val == 'T') frequency.set(7, frequency.get(7) + 1);
            if (val == 'J') frequency.set(8, frequency.get(8) + 1);
            if (val == 'Q') frequency.set(9, frequency.get(9) + 1);
            if (val == 'K') frequency.set(10, frequency.get(10) + 1);
            if (val == '2') frequency.set(11, frequency.get(11) + 1);
        }
        ArrayList<Integer> frequency1 = new ArrayList<>();
        for (int x = 0; x < 15; x ++) frequency1.add(0);
        for (int x = 0; x < playerCards.get(1).length; x ++){
            char val = playerCards.get(1)[x].charAt(0);
            if (val == '3') frequency1.set(0, frequency1.get(0) + 1);
            if (val == '4') frequency1.set(1, frequency1.get(1) + 1);
            if (val == '5') frequency1.set(2, frequency1.get(2) + 1);
            if (val == '6') frequency1.set(3, frequency1.get(3) + 1);
            if (val == '7') frequency1.set(4, frequency1.get(4) + 1);
            if (val == '8') frequency1.set(5, frequency1.get(5) + 1);
            if (val == '9') frequency1.set(6, frequency1.get(6) + 1);
            if (val == 'T') frequency1.set(7, frequency1.get(7) + 1);
            if (val == 'J') frequency1.set(8, frequency1.get(8) + 1);
            if (val == 'Q') frequency1.set(9, frequency1.get(9) + 1);
            if (val == 'K') frequency1.set(10, frequency1.get(10) + 1);
            if (val == '2') frequency1.set(11, frequency1.get(11) + 1);
        }
        ArrayList<Integer> frequency2 = new ArrayList<>();
        for (int x = 0; x < 15; x ++) frequency2.add(0);
        for (int x = 0; x < playerCards.get(2).length; x ++){
            char val = playerCards.get(2)[x].charAt(0);
            if (val == '3') frequency2.set(0, frequency2.get(0) + 1);
            if (val == '4') frequency2.set(1, frequency2.get(1) + 1);
            if (val == '5') frequency2.set(2, frequency2.get(2) + 1);
            if (val == '6') frequency2.set(3, frequency2.get(3) + 1);
            if (val == '7') frequency2.set(4, frequency2.get(4) + 1);
            if (val == '8') frequency2.set(5, frequency2.get(5) + 1);
            if (val == '9') frequency2.set(6, frequency2.get(6) + 1);
            if (val == 'T') frequency2.set(7, frequency2.get(7) + 1);
            if (val == 'J') frequency2.set(8, frequency2.get(8) + 1);
            if (val == 'Q') frequency2.set(9, frequency2.get(9) + 1);
            if (val == 'K') frequency2.set(10, frequency2.get(10) + 1);
            if (val == '2') frequency2.set(11, frequency2.get(11) + 1);
        }
        int playernum = 1, startplayer = 1;
        int[] deleted_cards = new int[3];
        String ans = "";
        boolean flag1 = true, flag2 = true, flag3 = true;
        while(ans.length() < 2) {
            int X;
            if (startplayer == 1) X = Collections.max(frequency);
            else if (startplayer == 2) X = Collections.max(frequency1);
            else X = Collections.max(frequency2);
            playernum = startplayer;
            int prev = -1;
            boolean highf1 = true, highf2 = true, highf3 = true;
            while ((highf1 || highf2 || highf3) && ans.length() < 2) {
                if (playernum == 1 && flag1) {
                    for (int i = 0; i < frequency.size(); i++) {
                        if (frequency.get(i) == X && i > prev) {
                            frequency.set(i, 0);
                            deleted_cards[0] += X;
                            if (deleted_cards[0] == playerCards.get(0).length) {
                                ans += "1";
                                flag1 = false;
                            }
                            startplayer = 1;
                            prev = i;
                            break;
                        }
                        else if (i == frequency.size() - 1) highf1 = false;
                    }
                    playernum = 2;
                }
                else if (playernum == 2 && flag2) {
                    for (int i = 0; i < frequency1.size(); i++) {
                        if (frequency1.get(i) == X && i > prev) {
                            frequency1.set(i, 0);
                            deleted_cards[1] += X;
                            if (deleted_cards[1] == playerCards.get(1).length) {
                                ans += "2";
                                flag2 = false;
                            }
                            startplayer = 2;
                            prev = i;
                            break;
                        }
                        else if (i == frequency1.size() - 1) highf2 = false;
                    }
                    playernum = 3;
                }
                else if (playernum == 3 && flag3) {
                    for (int i = 0; i < frequency2.size(); i++) {
                        if (frequency2.get(i) == X && i > prev) {
                            frequency2.set(i, 0);
                            deleted_cards[2] += X;
                            if (deleted_cards[2] == playerCards.get(2).length) {
                                ans += "3";
                                flag3 = false;
                            }
                            prev = i;
                            startplayer = 3;
                            break;
                        }
                        else if (i == frequency2.size() - 1) highf3 = false;
                    }
                    playernum = 1;
                }
            }
        }
        String[] arr = ans.split("");
        if (1 != Integer.parseInt(arr[0]) && 1 != Integer.parseInt(arr[1])) ans += "1";
        if (2 != Integer.parseInt(arr[0]) && 2 != Integer.parseInt(arr[1])) ans += "2";
        if (3 != Integer.parseInt(arr[0]) && 3 != Integer.parseInt(arr[1])) ans += "3";
        System.out.println(arr[0] + " " + arr[1] + " " + arr[2]);
    }
}
