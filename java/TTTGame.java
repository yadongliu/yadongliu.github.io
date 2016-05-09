import java.util.Scanner;

public class TTTGame {
	char[] board = {'1', '2', '3', '4', '5', '6', '7', '8', '9'};
	char piece = 'A'; // the other piece is "B"
	String currentPlayer;
	String winner = null; 

	public static void main(String[] args) {
		TTTGame game = new TTTGame();

		game.playGame();
	}

	public void playGame() {
		boolean hasWinnerYet = hasWinner();

		printBoard();
		while(!hasWinnerYet) {
	        Scanner in = new Scanner(System.in);
    	    System.out.print("Player "+piece + " turn: ");
    	    int position = in.nextInt();

    	    if(position>=0 && position<=9 && 
    	    	board[position-1]==position+'0') {
    	    // place the new piece
    	    System.out.print("placed "+piece + " turn: ");
    	    board[position-1] = piece;
    	    piece = piece=='A' ? 'B' : 'A';

    	    printBoard();
    	    hasWinnerYet = hasWinner();
    	    }
		}

		if(hasWinnerYet) {
			System.out.println(winner + " won!");
		} else {
			System.out.println("A tie!");
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

	public void printBoard() {
		for(int row=0; row<3; row++) {
			System.out.println(board[row*3+0] + "\t" +
				board[row*3 + 1] + "\t" +
				board[row*3 + 2] );
		}
	}


}