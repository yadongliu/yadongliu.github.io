import java.util.Scanner;

public class TicTacToe {
    private char[] board = {'1','2','3','4','5','6','7','8','9'};
    private String winner = null;
    private int player = 0;

	public static void main(String[] args) {
        TicTacToe game = new TicTacToe();
        game.startGame();
	}

    public void startGame() {
        boolean won = hasWinner();
        int moves = 0;

        printBoard();
        while (!won && moves<9) {

            char mark = player==0 ? 'A' : 'B';

            System.out.print(String.format("Player %c's turn: ", mark));
            Scanner in = new Scanner(System.in);
            int i = in.nextInt();

            if (i >= 1 && i <= 9 && board[i-1]==i+'0') {
                // System.out.println("You choose: " + board[i-1]);
                board[i-1] = mark;
                player = player==0 ? 1 : 0;
                moves += 1;

                won = hasWinner();
                printBoard();
        } else {
                System.out.println("Try again with a number between 1-9.");
            }
        }

        if(winner!=null) {
            System.out.println("Winner is: " + winner);
        } else {
            System.out.println("No Winner this round.");
        }
    }

    // print board
    public void printBoard() {
        int gridCount = board.length;
        for(int row=0; row<3; row++) {
            System.out.println(board[row*3] + "\t" +
                    board[row*3+1] + "\t" +
                    board[row*3+2] + "\t");
        }
    }

    public boolean hasWinner() {
        boolean won = false;
        char winningChar = '\0';

        if(board[0]==board[1] && board[1]==board[2]) {
            won = true;
            winningChar = board[0];
        } else if(board[3]==board[4] && board[4]==board[5]) {
            won = true;
            winningChar = board[3];
        } else if(board[6]==board[7] && board[7]==board[8]) {
            won = true;
            winningChar = board[6];
        } else if(board[0]==board[3] && board[3]==board[6]) {
            won = true;
            winningChar = board[0];
        } else if(board[1]==board[4] && board[4]==board[7]) {
            won = true;
            winningChar = board[1];
        } else if(board[2]==board[5] && board[5]==board[8]) {
            won = true;
            winningChar = board[2];
        } else if(board[0]==board[4] && board[4]==board[8]) {
            won = true;
            winningChar = board[0];
        } else if(board[2]==board[4] && board[4]==board[6]) {
            won = true;
            winningChar = board[2];
        }

        if(won) {
            winner = String.format("Player %c", winningChar);
        }

        return won;
    }


}