package com.motus;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the dimension 2-10: ");
        int n = Integer.parseInt(scanner.nextLine().trim());
        String[][] board = new String[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(board[i], "#");
        }
        double turn = Math.floor(Math.random()*(100+1));
        boolean isO = true;
        if (turn % 2 == 0) {
            isO = false;
        }
        while(true) {
            if (isO) {
                System.out.println("O turn");
            } else {
                System.out.println("X turn");
            }

            System.out.println("Enter move a b: ");
            String[] move = scanner.nextLine().split(" ");
            int row = Integer.parseInt(move[0]);
            int col = Integer.parseInt(move[1]);
            if (row >= board.length || col>= board.length || row < 0 || col < 0 || !board[row][col].equals("#")) {
                System.out.println("Invalid move!!!");
                continue;
            }
            if (isO) {
                board[row][col] = "O";
            } else {
                board[row][col] = "X";
            }
            printBoard(board);
            if (checkWinner(n, board, row, col)) {
                if (isO) {
                    System.out.println("O win");
                } else {
                    System.out.println("X win");
                }
                break;
            };
            isO = !isO;
            turn++;
        }

    }


    private static boolean checkWinner(int n, String[][] board, int row, int col) {
        int countO = 0;
        int countX = 0;


        // check row

        for (int i = 0; i < n; i++) {
            if (board[row][i] .equals("O")) {
                countO++;
            }
            if (board[row][i].equals("X")) {
                countX++;
            }
        }
        if (countO == n  || countX == n) {
            return true;
        }
        // check col
        countO = 0;
        countX = 0;
        for (int i = 0; i < n; i++) {
                if (board[i][col] .equals("O")) {
                    countO++;
                }
                if (board[i][col].equals("X")) {
                    countX++;
                }
        }
        if (countO == n || countX == n ) {
            return true;
        }

        countO = 0;
        countX = 0;
        //check diagno from left to right
            // go up left
            int tempRow = row;
            int tempCol = col;

            while(tempRow >= 0 && tempCol >= 0) {
                if (board[tempRow][tempCol] .equals("O")) {
                    countO++;
                }
                if (board[tempRow][tempCol].equals("X")) {
                    countX++;
                }
                tempRow--;
                tempCol--;
            }
            // go gown right
            tempRow = row + 1;
            tempCol = col + 1;

             while(tempRow < n && tempCol < n) {
                if (board[tempRow][tempCol] .equals("O")) {
                    countO++;
                }
                if (board[tempRow][tempCol].equals("X")) {
                    countX++;
                }
                tempRow++;
                tempCol++;
            }

            if (countO == n || countX == n) {
                return true;
            }

        //check diagno from right to left
            // go up right
        tempRow = row;
        tempCol = col;
        countO = 0;
        countX = 0;
        while(tempRow >= 0 && tempCol < n) {
            if (board[tempRow][tempCol] .equals("O")) {
                countO++;
            }
            if (board[tempRow][tempCol].equals("X")) {
                countX++;
            }
            tempRow--;
            tempCol++;
        }
        // go gown left
        tempRow = row + 1;
        tempCol = col - 1;

        while(tempRow < n && tempCol > 0) {
            if (board[tempRow][tempCol].equals("O")) {
                countO++;
            }
            if (board[tempRow][tempCol].equals("X")) {
                countX++;
            }
            tempRow++;
            tempCol--;
        }

        if (countO == n || countX == n ) {
            return true;
        }

        return false;
    }

    private static void printBoard(String[][] board){
        for (int i = 0; i < board.length; i++) {
            String s = String.join("|",board[i]);
            System.out.println(s);
        }
        System.out.println();
    }

}
