import java.util.Scanner;

/**
 * This problem represents a 2-player game of Battleship.
 * There is one board for each player in the game.
 * The boards are first filled with boats and then the players start shooting each other to destroy the boats.
 * Each player's board is printed on the console and the final game result is also determined.
 * Lastly, the bombs in the neighbouring cells of a given coordinate is filled with 'X' and is printed to the console.
 *
 * @author Nilay Das
 */
public class Game2 {

    public static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {

        //Representing board size
        int boardSize = in.nextInt();

        //Character array for Player 1 board
        char[][] board1 = new char[boardSize][boardSize];

        //Character array for Player 2 board
        char[][] board2 = new char[boardSize][boardSize];

        //Input to represent how many boats each player will add to their board
        int addBoat = in.nextInt();

        //Method calling to fill both arrays with "-"
        fill(board1);
        fill(board2);

        //Method calling for boat representation
        for (int i = 0; i < addBoat * 2; i++) {
            representation(i, board1, board2);
        }

        //Method calling for printing the board with boats using \t
        printBoard(board1, board2);

        System.out.println();

        //Input representing shots fired
        int shotCount = in.nextInt();

        //Processing code for shots fired by both the players and drawing "X" on the board.
        for (int i = 0; i < shotCount * 2 - 2; i++) {
            int xCor = in.nextInt();
            int yCor = in.nextInt();

            if (xCor >= boardSize || yCor >= boardSize || xCor < 0 || yCor < 0) {
                continue;
            }
            // Shot of first player changes the second player's board.
            // Shot of second player changes the first player's board.
            if (i % 2 == 0) {
                board2[xCor][yCor] = 'X';
            } else {
                board1[xCor][yCor] = 'X';
            }
        }

        //Method calling for finding out the neighbors in the board.
        bombsInTheNeighborCells(board2);
        bombsInTheNeighborCells(board1);

        //Method calling for printing the board with boats and shots fired using \t
        printBoard(board1, board2);

        //Variables to hold how many boats are left on the board after all the shots have been fired by both players
        int board1BoatCount = countBoat(board1);
        int board2BoatCount = countBoat(board2);

        //Method calling for representing game result
        String result = finalGameState(board1BoatCount, board2BoatCount);
        System.out.println();
        System.out.println(result);


    }

    /**
     * This method determines the bombs in the neighbour cells of a given coordinate.
     *
     * @param board represents the board of Player 1 and Player 2.
     */
    public static void bombsInTheNeighborCells(char[][] board) {
        int xCor = in.nextInt();
        int yCor = in.nextInt();

        int xValue[] = {0, 1, 2, -1, -2, 0, 0, 0, 0, -1, -1, 1, 1};
        int yValue[] = {0, 0, 0, 0, 0, 1, 2, -1, -2, 1, -1, 1, -1};

        for (int i = 0; i < xValue.length; i++) {
            int xIndex = xCor + xValue[i];
            int yIndex = yCor + yValue[i];

            if (xIndex < board.length && yIndex < board.length) {
                if (xIndex >= 0 && yIndex >= 0) {
                    board[xIndex][yIndex] = 'X';
                }

            }


        }
    }

    /**
     * This method is used to determine the final result of the game.
     *
     * @param board1BoatCount holds the number of total boats player 1 has in the board.
     * @param board2BoatCount holds the number of total boats player 2 has in the board.
     * @return a string representing whether Player 1 Won or Player 2 Won or if the game is a draw.
     */
    public static String finalGameState(int board1BoatCount, int board2BoatCount) {

        String result = "";

        if (board1BoatCount > 0 && board2BoatCount > 0) {
            result = "Draw!";
        }

        if (board2BoatCount == 0 && board1BoatCount > 0) {
            result = "P1 Won!";
        }

        if (board1BoatCount == 0 && board2BoatCount > 0) {
            result = "P2 Won!";
        }

        if (board1BoatCount == 0 && board2BoatCount == 0) {
            //Not sure what to write.
            result = "All destroyed";
        }

        return result;
    }

    /**
     * This method is used to count the number of boats in each players' board
     *
     * @param board is the character array that represents the board of each player
     * @return the total number of boats in each players' board.
     */
    public static int countBoat(char[][] board) {
        int boatNumber = 0;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                if (board[i][j] == 'B') {
                    boatNumber++;
                }
            }
        }
        return boatNumber;
    }

    /**
     * This method is used to fill the character array which represents the board with "-".
     *
     * @param board is the character array that represents the board of each player.
     */
    public static void fill(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                board[i][j] = '-';

            }
        }
    }

    /**
     * This method is used to represent the boats in each players' board.
     *
     * @param count  is a counter to determine the turn of each player
     * @param board1 represents the board of player 1
     * @param board2 represents the board of player 2
     */
    public static void representation(int count, char[][] board1, char[][] board2) {

        //Inputs for boat representation
        int xCor = in.nextInt();
        int yCor = in.nextInt();
        int boatSize = in.nextInt();
        int orientation = in.nextInt();

        //Boat representation on the board based on the input of orientation.
        if (orientation == 0) {
            for (int i = yCor; i < yCor + boatSize; i++) {
                if (i >= board1.length) {
                    continue;
                }
                if (count % 2 == 0) {
                    board1[xCor][i] = 'B';
                } else {
                    board2[xCor][i] = 'B';
                }
            }
        }


        if (orientation == 1) {
            for (int i = xCor; i < xCor + boatSize; i++) {

                if (i >= board1.length) {
                    continue;
                }

                if (count % 2 == 0) {
                    board1[i][yCor] = 'B';
                } else {
                    board2[i][yCor] = 'B';
                }
            }
        }


    }

    /**
     * This method is used to print the board with all the boats and the boats that have been destroyed.
     *
     * @param board1 is the character array that represents the board of Player 1
     * @param board2 is the character array that represents the board of Player 2
     */
    public static void printBoard(char[][] board1, char[][] board2) {
        for (int i = 0; i < board1.length; i++) {
            for (int j = 0; j < board1.length; j++) {
                System.out.print(board1[i][j]);

            }
            System.out.print("\t");

            for (int j = 0; j < board2.length; j++) {
                System.out.print(board2[i][j]);
            }
            System.out.println();
        }
    }

}


