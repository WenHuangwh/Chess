package chess;

/**
 * The interface Chess piece. This is the super-type for all chess pieces.
 */
public interface ChessPiece {

  /**
   * Gets the row of piece (integer from 0 to 7).
   *
   * @return the row
   */
  int getRow();

  /**
   * Gets the column of piece (integer from 0 to 7).
   *
   * @return the column
   */
  int getColumn();

  /**
   * Gets color of chess piece (Black or White).
   *
   * @return the color
   */
  Color getColor();

  /**
   * Whether a chess piece can move to a given location.
   *
   * @param row the row
   * @param col the col
   * @return the boolean
   */
  boolean canMove(int row, int col);

  /**
   * Whether a chess piece can kill a given chess piece.
   *
   * @param piece the piece
   * @return the boolean
   */
  boolean canKill(ChessPiece piece);

  /**
   * Whether a location is outside the chess board.
   *
   * @param row the row
   * @param col the col
   * @return the boolean
   */
  boolean outsideBoard(int row, int col);
}
