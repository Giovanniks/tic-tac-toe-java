import java.util.Scanner;

public class TicTacToe {

    private static char[][] board = new char[3][3];
    private static char currentPlayer = 'X';

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        initializeBoard();

        boolean gameActive = true;
        int movesCount = 0;

        System.out.println("=== TIC-TAC-TOE IN JAVA ===");

        while (gameActive) {
            displayBoard();
            System.out.println("\nPlayer " + currentPlayer + ", enter row and column (0, 1, or 2):");

            System.out.print("Row: ");
            int row = scanner.nextInt();
            System.out.print("Column: ");
            int col = scanner.nextInt();

            if (row < 0 || row > 2 || col < 0 || col > 2) {
                System.out.println("Invalid position! Please choose numbers between 0 and 2.");
                continue;
            }

            if (board[row][col] != ' ') {
                System.out.println("This position is already occupied! Try again.");
                continue;
            }

            board[row][col] = currentPlayer;
            movesCount++;

            if (checkWin()) {
                displayBoard();
                System.out.println("\nCongratulations! Player " + currentPlayer + " wins!");
                gameActive = false;
            } else if (movesCount == 9) {
                displayBoard();
                System.out.println("\nIt's a draw!");
                gameActive = false;
            } else {
                currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
            }
        }

        scanner.close();
    }

    private static void initializeBoard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = ' ';
            }
        }
    }

    private static void displayBoard() {
        System.out.println("\n  0   1   2");
        for (int i = 0; i < 3; i++) {
            System.out.print(i + " ");
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j]);
                if (j < 2) System.out.print(" | ");
            }
            System.out.println();
            if (i < 2) System.out.println(" ---+---+---");
        }
    }

    private static boolean checkWin() {

        for (int i = 0; i < 3; i++) {
            if (board[i][0] == currentPlayer && board[i][1] == currentPlayer && board[i][2] == currentPlayer) {
                return true;
            }
            if (board[0][i] == currentPlayer && board[1][i] == currentPlayer && board[2][i] == currentPlayer) {
                return true;
            }
        }

        if (board[0][0] == currentPlayer && board[1][1] == currentPlayer && board[2][2] == currentPlayer) {
            return true;
        }
        if (board[0][2] == currentPlayer && board[1][1] == currentPlayer && board[2][0] == currentPlayer) {
            return true;
        }

        return false;
    }
}