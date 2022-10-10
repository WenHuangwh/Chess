package chess;

/**
 * The type Rook.
 */
public class Rook extends AbstractChessPiece {

  /**
   * Instantiates a new Rook with row, column, color.
   *
   * @param row   the row
   * @param col   the col
   * @param color the color
   */
  public Rook(int row, int col, Color color) {
    super(row, col, color);
  }

  @Override
  public boolean canMove(int row, int col) {
    // If the given location is outside chess board or is the same position of this piece.
    if (outsideBoard(row, col) || (this.row == row && this.col == col)) {
      return false;
    }
    // Moving any spaces horizontally or vertically.
    if (this.row == row || this.col == col) {
      return true;
    }
    return false;
  }
}
