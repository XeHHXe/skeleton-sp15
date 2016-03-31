public class Piece {

    public final boolean side; // true means this is a fire piece
    private String type;

    /** Determines whether or not this piece is a King. */
    private boolean isKing;

    /* True if this piece has captured a piece this turn and is considering a
	  multi-capture.*/
    private boolean hasCaptured;

    /** Represents the piece's current position on its board. */
    private int x, y;
    /** Keeps track of the board to which this piece belongs.
     *  Necessary for callbacks. */

    /** Returns whether or not this piece is on the Fire team. */
    public boolean isFire() {
        return side;
    }

    /**
     * Constructs a new Piece.
     * 
     * @param team Which team the Piece will belong to.
     * @param b    Which board the Piece is on.
     * @param x    The initial X position of the Piece.
     * @param y    The initial Y position of the Piece.
     */
    public Piece(boolean isFire, int x, int y, String type, boolean isKing) {
        side = isFire;
        this.isKing = isKing;
        this.x = x;
        this.y = y;
        this.type = type;
        hasCaptured = false;
    }

    /** Returns whether or not this piece is a Bomb Piece. Overridden in
     *  subclasses. */
    public boolean isBomb() {
        return type.equalsIgnoreCase("bomb");
    }

    /** Promotes this piece to a king, if not already done so. */
    public void promote() {
        this.isKing = true;
    }

    /** Returns whether or not this piece is a Shield Piece. Overridden in
     *  subclasses. */
    public boolean isShield() {
        return type.equalsIgnoreCase("shield");
    }

    /** Returns whether or not the piece is a King. */
    public boolean isKing() {
        return isKing;
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof Piece) {
            Piece p = (Piece) o;
            if (this.side == p.side && this.type == p.type 
                && this.isKing == p.isKing && this.hasCaptured == p.hasCaptured 
                && this.x == p.x && this.y == p.y) {
                return true;
            }
        }
        return false;
    }

    @Override
    public int hashCode() {
        int type;
        switch (this.type) {
            case "regular": type = 0; break;
            case "bomb": type = 1; break;
            case "shield": type = 2; break;
            default: type = 0;
        }
        return ((side ? 1 : 0) << 10) + (type << 9) + ((isKing ? 1 : 0) << 7) 
                + ((hasCaptured ? 1 : 0) << 6) + (x << 3) + y;
    }

    public static void main(String[] args) {
        Piece p1 = new Piece(false, 0, 0, "bomb", false);
        Piece p1AndHalf = new Piece(true, 0, 0, "regular", true);
        System.out.println(p1.hashCode());
        System.out.println(p1AndHalf.hashCode());
        Piece p2 = new Piece(false, 1, 0, "bomb", false);
        System.out.println(p2.hashCode());
    }
}
