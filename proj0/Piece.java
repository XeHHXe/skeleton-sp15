public class Piece {
	/* Constructor for a piece. */
	public Piece(boolean isFire, Board b, int x, int y, String type) {

	}

	/* Returns whether or not the piece is a fire piece. */
	public boolean isFire() {

	}

	/* Returns 0 if the piece is a fire piece, or 1 if the piece is a water piece. */
	public int side() {

	}

	/* Returns whether or not the piece has been crowned. */
	public boolean isKing() {

	}

	/* Returns whether or not the piece is a Bomb Piece. */
	public boolean isBomb() {

	}

	/* Returns whether or not the piece is a Shield Piece. */
	public boolean isShield() {

	}

	/* Assumes this Piece's movement from its current position to (x, y) is valid. */
	public void move(int x, int y) {

	}

	/* Returns whether or not this Piece has captured another piece this turn. */
	public boolean hasCaptured() {

	}
	
	/* Called at the end of each turn on the Piece that moved. 
	 * Makes sure the piece's hasCaptured() value returns to false. */
	public void doneCapturing() {

	}
}