public class Board {
	/* Starts a GUI supported version of the game */
	public static void main(String[] args) {
		int N = 8;
		StdDrawPlus.setXscale(0, N);
		StdDrawPlus.setYscale(0, N);
		pieces = new boolean[N][N];

		/* Monitors for mouse presses. Wherever the mouse is pressed,
		 * a new piece appears. */
		// while(true) {
		// 	drawBoard(N);
		// 	if (StdDrawPlus.mousePressed()) {
		// 		double x = StdDrawPlus.mouseX();
		// 		double y = StdDrawPlus.mouseY();
		// 		pieces[(int) x][(int) y] = true;
		// 	}            
		// 	StdDrawPlus.show(100);
		// }
	}

	/* Draws a N * N board in gray and red color. */
	private static drawBoard(int N) {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if ((i + j) % 2 == 0) {
					StdDrawPlus.setPenColor(StdDrawPlus.GRAY);
				} else {
					StdDrawPlus.setPenColor(StdDrawPlus.RED);
				}
				StdDrawPlus.filledSquare(i + .5, j + .5, .5);
				StdDrawPlus.setPenColor(StdDrawPlus.WHITE);
				if (pieces[i][j]) {
					StdDrawPlus.picture(i + .5, j + .5, "img/bomb-fire-crowned.png", 1, 1);
				}
			}
		}
	}

	/* The constructor for Board. If shouldBeEmpty is true, initializes an empty Board.
	 * Otherwise, initializes a Board with the default configuration. Note that an empty
	 * Board could possibly be useful for testing purposes. */
	public Board(boolean shouldBeEmpty) {

	}

	/* Gets the piece at position (x, y) on the board, or null if there is no piece.
	 * If (x, y) are out of bounds, returns null. */
	public Piece pieceAt(int x, int y) {

	}

	/* Returns true if the square at (x, y) can be selected. */
	public boolean canSelect(int x, int y) {

	}

	/* Returns true if the piece at (xi, yi) can either move to (xf, yf) or capture to
	 * (xf, yf), strictly from a geometry/piece-race point of view. */
	private boolean validMove(int xi, int yi, int xf, int yf) {

	}

	/* Selects the square at (x, y). */
	public void select(int x, int y) {

	}

	/* Places p at (x, y). */
	public void place(Piece p, int x, int y) {

	}

	/* Executes a remove. */
	public Piece remove(int x, int y) {

	}

	/* Returns whether or not the the current player can end their turn. */
	public boolean canEndTurn() {

	}

	/* Called at the end of each turn. */
	public void endTurn() {

	}

	/* Returns the winner of the game: "Fire", "Water", "No one", or null. */
	public String winner() {

	}
}