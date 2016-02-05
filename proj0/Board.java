public class Board {
	private static int N = 8;
	private boolean shouldBeEmpty;
	private Piece[][] pieces = new Piece[N][N];
	private boolean fireTurn = false;

	/* Starts a GUI supported version of the game */
	public static void main(String[] args) {
		StdDrawPlus.setXscale(0, N);
		StdDrawPlus.setYscale(0, N);
		Board b = new Board(false);
		b.drawBoard(N);
		b.updateBoard();
		// pieces = new boolean[N][N];

		/* Monitors for mouse presses. Wherever the mouse is pressed,
		 * a new piece appears. */
		// while (true) {
		// 	drawBoard(N);
		// 	if (StdDrawPlus.mousePressed()) {
		// 		double x = StdDrawPlus.mouseX();
		// 		double y = StdDrawPlus.mouseY();
		// 		pieces[(int) x][(int) y] = true;
		// 	}            
		// 	StdDrawPlus.show(100);
		// }
	}

	/* The constructor for Board. If shouldBeEmpty is true, initializes an empty Board.
	 * Otherwise, initializes a Board with the default configuration. Note that an empty
	 * Board could possibly be useful for testing purposes. */
	public Board(boolean shouldBeEmpty) {
		this.shouldBeEmpty = shouldBeEmpty;
		if (!shouldBeEmpty) {
			for (int i = 0; i < N; i += 2) {
				// fire pieces
				pieces[i][0] = new Piece(true, this, i, 0, "pawn");
				pieces[i + 1][1] = new Piece(true, this, i + 1, 1, "shield");
				pieces[i][2] = new Piece(true, this, i, 2, "bomb");
				// water pieces
				pieces[i + 1][7] = new Piece(false, this, i + 1, 7, "pawn");
				pieces[i][6] = new Piece(false, this, i, 6, "shield");
				pieces[i + 1][5] = new Piece(false, this, i + 1, 5, "bomb");				
			}
		}
	}

	/* Gets the piece at position (x, y) on the board, or null if there is no piece.
	 * If (x, y) are out of bounds, returns null. */
	public Piece pieceAt(int x, int y) {
		if (x < 0 || x > N - 1 || y < 0 || y > N - 1) {
			return null;
		} else {
			return pieces[x][y];
		}
	}

	/* Returns true if the square at (x, y) can be selected. */
	public boolean canSelect(int x, int y) {
		return false;
	}

	/* Returns true if the piece at (xi, yi) can either move to (xf, yf) or capture to
	 * (xf, yf), strictly from a geometry/piece-race point of view. */
	private boolean validMove(int xi, int yi, int xf, int yf) {
		return false;
	}

	/* Selects the square at (x, y). */
	public void select(int x, int y) {

	}

	/* Places p at (x, y). */
	public void place(Piece p, int x, int y) {
		if (x < 0 || x > N - 1 || y < 0 || y > N - 1 || p == null) {
			return;
		} else {
			// Checking before placing p!
			pieces[x][y] = p;
		}
	}

	/* Executes a remove. */
	public Piece remove(int x, int y) {
		return null;
	}

	/* Returns whether or not the the current player can end their turn. */
	public boolean canEndTurn() {
		return false;
	}

	/* Called at the end of each turn. */
	public void endTurn() {

	}

	/* Returns the winner of the game: "Fire", "Water", "No one", or null. */
	public String winner() {
		return null;
	}

	/* Draws a N * N board in gray and red color. */
	private static void drawBoard(int N) {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if ((i + j) % 2 == 0) {
					StdDrawPlus.setPenColor(StdDrawPlus.GRAY);
				} else {
					StdDrawPlus.setPenColor(StdDrawPlus.RED);
				}
				StdDrawPlus.filledSquare(i + .5, j + .5, .5);
				// StdDrawPlus.setPenColor(StdDrawPlus.WHITE);
			}
		}
	}

	private void drawPieces(Piece p, int x, int y) {
		String img = "";
		if (p != null) {
			if (p.isFire()) {
				if (p.isBomb()) {
					if (p.isKing()) {
						img = "img/bomb-fire-crowned.png";
					} else {
						img = "img/bomb-fire.png";
					}
				} else if (p.isShield()) {
					if (p.isKing()) {
						img = "img/shield-fire-crowned.png";
					} else {
						img = "img/shield-fire.png";
					}					
				} else {
					if (p.isKing()) {
						img = "img/pawn-fire-crowned.png";
					} else {
						img = "img/pawn-fire.png";
					}						
				}
			} else {
				if (p.isBomb()) {
					if (p.isKing()) {
						img = "img/bomb-water-crowned.png";
					} else {
						img = "img/bomb-water.png";
					}
				} else if (p.isShield()) {
					if (p.isKing()) {
						img = "img/shield-water-crowned.png";
					} else {
						img = "img/shield-water.png";
					}					
				} else {
					if (p.isKing()) {
						img = "img/pawn-water-crowned.png";
					} else {
						img = "img/pawn-water.png";
					}						
				}
			}
		}
		if (img != "") {
			StdDrawPlus.picture(x + .5, y + .5, img, 1, 1);
		}
	}

	private void updateBoard() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				drawPieces(pieces[i][j], i, j);
			}
		}		
	}
}