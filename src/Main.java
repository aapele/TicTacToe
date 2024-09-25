import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        char[][] board = {
                {' ', ' ', ' '},
                {' ', ' ', ' '},
                {' ', ' ', ' '}
        };
        int row;
        int col;
        char mark;
        int markChoice;
        boolean gameOver = false;


        System.out.println("Hello, this is a Tic Tac Toe game");
        System.out.println("You will be asked to enter a row and column");
        printBoard(board);
        System.out.println("Choose '0' for Upper, '1' for Middle, and '2' for Lower row");
        System.out.println("Choose '0' for Left, '1' for Middle, and '2' for Right column\n");

        Scanner in = new Scanner(System.in);

        do {
            System.out.println("Player One, choose your mark - '1' for X or '2' for O");
            markChoice = in.nextInt();
            if (markChoice == 1) {
                mark = 'X';
            } else {
                mark = 'O';
            }
        } while (markChoice != 1 && markChoice != 2);

        System.out.println("Great, let's start the game!\n");

        while (!gameOver){
            System.out.println("Player '" + mark + "' choose a row: ");
            row = in.nextInt();
            System.out.println("Player '" + mark + "' choose a column: ");
            col = in.nextInt();

            if(isValid(board, row, col)){
                placeMark(board, row, col, mark);
                printBoard(board);

                if (checkWin(board, row, col, mark)){
                    gameOver = true;
                    System.out.println("Player '" + mark + "' wins!");
                    break;
                }

                if(checkTie(board)){
                    gameOver = true;
                    System.out.println("The game is over, it is a tie");
                    break;
                }

                if (mark == 'X'){
                    mark = 'O';
                } else {
                    mark = 'X';
                }

            } else {
                System.out.println("Invalid move, try again");
            }
        }
        in.close();
    }

    public static void printBoard(char[][] array){
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                System.out.print(array[i][j]+ "|");
            }
            System.out.println();
            System.out.println("------");
        }
        System.out.println();
    }

    public static boolean isValid(char[][] array, int row, int col){
        if(array[row][col] == ' '){
            return true;
        } else {
            return false;
        }
    }

    public static char[][] placeMark(char[][] array, int row, int col, char mark){
        array[row][col] = mark;
        return array;
    }

    public static boolean checkWin(char[][] array, int row, int col, char mark){
        if (array[row][0] == mark && array[row][1] == mark && array[row][2] == mark){
            return true;
        }
        if (array[0][col] == mark && array[1][col] == mark && array[2][col] == mark){
            return true;
        }
        if (array[0][0] == mark && array[1][1] == mark && array[2][2] == mark){
            return true;
        }
        if (array[0][2] == mark && array[1][1] == mark && array[2][0] == mark){
            return true;
        }
        return false;
    }

    public static boolean checkTie(char[][] array){
        for(int i = 0; i < array.length; i++){
            for(int j = 0; j < array[i].length; j++){
                if(array[i][j] == ' '){
                    return false;
                }
            }
        }
        return true;
    }

}