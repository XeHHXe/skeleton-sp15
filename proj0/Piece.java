public class Piece {
	private boolean isFire;
	private Board b;
	private int x;
	private int y;
	private String type;
	private boolean isKing = false;
	private boolean isCaptured = false;

	/* Constructor for a piece. */
	public Piece(boolean isFire, Board b, int x, int y, String type) {
		this.isFire = isFire;
		this.b = b;
		this.x = x;
		this.y = y;
		this.type = type;
	}

	/* Returns whether or not the piece is a fire piece. */
	public boolean isFire() {
		return isFire;
	}

	/* Returns 0 if the piece is a fire piece, or 1 if the piece is a water piece. */
	public int side() {
		return isFire ? 0 : 1;
	}

	/* Returns whether or not the piece has been crowned. */
	public boolean isKing() {
		return isKing;
	}

	/* Returns whether or not the piece is a Bomb Piece. */
	public boolean isBomb() {
		return type == "bomb";
	}

	/* Returns whether or not the piece is a Shield Piece. */
	public boolean isShield() {
		return type == "shield";
	}

	/* Assumes this Piece's movement from its current position to (x, y) is valid. */
	public void move(int x, int y) {

	}

	/* Returns whether or not this Piece has captured another piece this turn. */
	public boolean hasCaptured() {
		return isCaptured;
	}
	
	/* Called at the end of each turn on the Piece that moved. 
	 * Makes sure the piece's hasCaptured() value returns to false. */
	public void doneCapturing() {
		isCaptured = false;
	}
}