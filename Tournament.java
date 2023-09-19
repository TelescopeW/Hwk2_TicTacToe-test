import java.util.Scanner;

/**
 *
 * @Alex Wang
 * @version 1.2
 */
public class Tournament {

    /**
     * this method takes 2 input players and gives them proper symbols using setSymbol()
     * then the method uses while loop to let the 2 players make move by turns, while
     * also checking whether there is one of them wins or the game draws. 
     */
    public Player playGame(Player playerX, Player playerO) {
        Board board = new Board();

        playerX.setSymbol(Board.X);
        playerO.setSymbol(Board.O);

        // Play the game until there is a winner or the board is filled
        while (true) {
            playerX.makeMove(board);
            //System.out.println(board.toString()); //test statement

            //playerX win
            if (board.getWinner() == Board.X) {
                System.out.println(playerX.celebrate());
                System.out.println(playerO.mourn());
                System.out.println("Board state after X wins:\n" + board.toString());
                return playerX;
            }

            //draw situation
            if (board.boardFilled()) {
                System.out.println("It's a draw!");
                System.out.println("Board state after draw:\n" + board.toString());
                return null;
            }

            playerO.makeMove(board);

            //playerO wins
            if (board.getWinner() == Board.O) {
                System.out.println(playerO.celebrate());
                System.out.println(playerX.mourn());
                System.out.println("Board state after O wins:\n" + board.toString());
                return playerO;
            }

            //draw
            if (board.boardFilled()) {
                System.out.println("It's a draw!");
                System.out.println("Board state after draw:\n" + board.toString());
                return null;
            }
        }
    }

    public void awPlayGame(Player aw, Player o) {
    Board b = new Board();

    aw.setSymbol(Board.X);
    o.setSymbol(Board.O);

    // Create a scanner for user input
    Scanner scanner = new Scanner(System.in);

    while (true) {
        // Display the current state of the board
        System.out.println(b.toString());

        // Player X's turn (assuming AI is Player X)
        if (aw.symbol == Board.X) {
            aw.makeMove(b);
        } else {
            // If AI is Player O, you can replace this with AI logic
            o.makeMove(b);
        }

        // Check for a winner or a draw
        int winner = b.getWinner();
        if (winner == Board.X) {
            System.out.println("Player X wins!");
            break;
        } else if (winner == Board.O) {
            System.out.println("Player O wins!");
            break;
        } else if (b.boardFilled()) {
            System.out.println("It's a draw!");
            break;
        }

        // Display the current state of the board
        System.out.println(b.toString());

        // Player O's turn (assuming AI is Player O)
        if (aw.symbol == Board.O) {
            aw.makeMove(b);
        } else {
            // If AI is Player X, you can replace this with AI logic
            o.makeMove(b);
        }

        // Check for a winner or a draw
        winner = b.getWinner();
        if (winner == Board.X) {
            System.out.println("Player X wins!");
            break;
        } else if (winner == Board.O) {
            System.out.println("Player O wins!");
            break;
        } else if (b.boardFilled()) {
            System.out.println("It's a draw!");
            break;
        }
    }

    // Close the scanner
    scanner.close();
}


    /*
     * main method that specifically uses a A_W_Player and a RandomPlayer to 
     * play game
     */
    public static void main(String[] args) {
        /*for(int i=0; i<10; i++){
        Player playerX = new RandomPlayer(Board.X, "O Player");
        Player playerO = new A_W_Player(Board.O, "X Player");
        

        Tournament tournament = new Tournament();
        Player winner = tournament.playGame(playerX, playerO);
        //Player winner2 = tournament.playGame2(playerX,playerO); 

        if (winner != null) {
        System.out.println("The winner is: " + winner.toString());
        } else {
        System.out.println("The game ended in a draw.");
        }
        }*/

        /*Board b = new Board();
        b.fillPosition(0,2,Board.O);
        b.fillPosition(0,1,Board.X); 
        b.fillPosition(0,0,Board.X);
        b.fillPosition(1,0,Board.O);
        b.fillPosition(2,0,Board.O);
        b.fillPosition(2,2,Board.X); 
        System.out.println(b.toString()); 
        
        Player playerX = new A_W_Player(Board.X, "AW");
        
        //Player playerO = new RandomPlayer(Board.O, "O Player");
        playerX.makeMove(b); 
        System.out.println(b.toString()); 
        //playerO.makeMove(b); 
        //System.out.println("Initial board state: \n" + b.toString());
        
        //playerX.makeMove(b); 
        //playerO.makeMove(b); 
        //System.out.println("2 turns state \n" + b.toString());
        */

    }

}

