package com.company;
import java.util.Scanner;
public class Main {
    static String[][] board = new String[6][7];
    static String playerWin =".";

    public static void main(String[] args) {
	// write your code here
        System.out.println("welcome to connect 4");

        int turnCount = 0;
        String player ="[r]";
        // makes the board
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 7; j++) {
                board[i][j] = "[ ]";
            }
        }
        printBoard(board);
        while( turnCount < 42){
            System.out.println("it is "+player+" turn");
            // play a token
            placeCoin(board,player);
            printBoard(board);
            checkBoard(board,player);
            // changes player
            if (player.equals("[r]")){
                player ="[y]";
            }
            else{
                player ="[r]";
            }
            turnCount += 1;
            System.out.println(turnCount);
            if (!playerWin.equals(".")){
                break;
            }

        }
        if(turnCount == 42){
            System.out.println("game is a draw");
        }
        if (!playerWin.equals(".")){
            System.out.println("player "+playerWin+" wins");
        }

    }

    public static void printBoard (String[][] board) {
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 7; j++) {
                System.out.print(board[i][j]);
            }
            System.out.println(" ");
        }
    }

    public static void placeCoin (String[][] board,String player) {
        Scanner input = new Scanner(System.in);
        boolean valid = false;
        int collum = 0;
        // get valid of collum
        while(!valid) {
            try {
                System.out.println("place coin in collum 1 to 7");
                collum = input.nextInt();
                collum -= 1;
                if ((collum >= 0) && (collum <= 6)){
                    for (int j = 0; j < 6; j++) {
                        // see if full collum
                        if (board[j][collum].equals("[ ]")){
                            valid = true;
                            break;
                        }
                        else{
                            System.out.println("collum is full pick anther collum");
                        }
                    }
                } else {
                    System.out.println("number not in range 1 to 7 ");
                }
            } catch (Exception e) {
                System.out.println("not a valid input " + e);
                input.next();
            }
        }
        //  add token to board
        for (int j = 0; j < 6; j++) {
            if (!board[j][collum].equals("[ ]")) {
                board[j-1][collum]= player;
                break;
            }
            if(j==5){
                board[j][collum]= player;
                break;
            }
        }

    }

    public static void checkBoard (String[][] board, String player){
        String token1 ;
        String token2 ;
        String token3 ;
        String token4 ;
        // rows check
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 4; j++) {
                token1 = board[i][j];
                token2 = board[i][j + 1];
                token3 = board[i][j + 2];
                token4 = board[i][j + 3];
                if (token1.equals(player)) {
                    if (token2.equals(player)) {
                        if (token3.equals(player)) {
                            if (token4.equals(player)) {
                                playerWin = player;
                            }
                        }
                    }
                }

            }
        }

        // collum check
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 7; j++) {
                token1 = board[i][j];
                token2 = board[i+1][j];
                token3 = board[i+2][j];
                token4 = board[i+3][j];
                if (token1.equals(player)) {
                    if (token2.equals(player)) {
                        if (token3.equals(player)) {
                            if (token4.equals(player)) {
                                playerWin = player;
                            }
                        }
                    }
                }

            }
        }

        // y=-x check
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 4; j++) {
                token1 = board[i][j];
                token2 = board[i+1][j+1];
                token3 = board[i+2][j+2];
                token4 = board[i+3][j+3];
                if (token1.equals(player)) {
                    if (token2.equals(player)) {
                        if (token3.equals(player)) {
                            if (token4.equals(player)) {
                                playerWin = player;
                            }
                        }
                    }
                }

            }
        }
        
        // y=x check
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 4; j++) {
                token1 = board[i+3][j];
                token2 = board[i+2][j+1];
                token3 = board[i+1][j +2 ];
                token4 = board[i][j+3];
                if (token1.equals(player)) {
                    if (token2.equals(player)) {
                        if (token3.equals(player)) {
                            if (token4.equals(player)) {
                                playerWin = player;
                            }
                        }
                    }
                }

            }
        }

    }

}
