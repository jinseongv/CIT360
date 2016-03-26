public class Player_Piece extends Player {
    // class constants
    // Colors for the players piece 
    public static final String BLUE = "Blue";
    public static final String RED = "red";
    public static final String YELLOW = "Yellow";
    public static final String BLACK = "Black";

    // Types for each players piece. 
    public static final String PLAYER1PIECE = "player one's piece";
    public static final String PLAYER2PIECE = "player two's piece";
    public static final String PLAYER3PIECE = "player three's piece";
    public static final String PLAYER4PIECE = "player four's piece";


    // fields
    private String color;
    private String type;
    private int row;
    private int column;

    // constructors
    /**
     * Constructs a new player piece with a colour and type at the given position.
     * @param color  The piece's color must be one of the following: BLUE, RED, YELLOW or BLACK.
     * @param type   The piece's type must either PLAYER1PIECE, PLAYER2PIECE, PLAYER3PIECE, PLAYER4PIECE.
     */
    public Player_Piece(String color, String type, int row, int column) {


        this.color  = color;
        this.type   = type;
        this.row    = row;
        this.column = column;

    }

    // methods for the class
    /**
     * Returns this players piece color. 
     * @return the color; either BLUE, RED, YELLOW or BLACK.
     */
    public String getColor() {
        return this.color;
    }

    /**
     * Returns this player piece's type.
     * @return the type; either PLAYER1PIECE, PLAYER2PIECE, PLAYER3PIECE, PLAYER4PIECE.
     */
    public String getType() {
        return this.type;
    }

    /**
     * Returns this player's piece row position.
     * @return the position of the piece.
     */
    public int getRow() {
        return this.row;
    }

    /**
     * Returns this player's piece column position.
     * @return the  position of the piece at the column
     */
    public int getColumn() {
        return this.column;
    }

    /**
     * Returns a String  of this piece.
     * @return a three letter String, such as "P1P" for player one's piece.
     */
    public String toString() {
        return this.type.substring(0, 1);
    }

    /**
     * Moves the piece to the  position.
     * 
     * @param row The row position for the piece to move to.
     * @param column The column position for the piece to move to.
     */
    public void move(int row, int column) {
        this.row    = row;
        this.column = column;


      }
}