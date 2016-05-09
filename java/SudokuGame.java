public class SudokuGame 
{
	private boolean gameOver = false;
	private int[][] boardStart;
	private int[][] board;
	private totalRows=3;
	private totalCols=3;

	public void setupBoard(int rows, int cols) {
		totalCols = cols;
		totalRows = rows;

	}

	public boolean checkWin() {
		// check each row
		if(int i=0; i<totalRows; i++) {
			if(!anyRowWins()) {
				return false;
			}
		}

		// check each col

		// check sqaure 

		return false;
	}

	public boolean anyRowWins() {

		return false;
	}
}