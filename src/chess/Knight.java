package chess;

/**
 * The type Knight.
 */
public class Knight extends AbstractChessPiece {

  /**
   * Instantiates a new Knight with row, column, color.
   *
   * @param row   the row
   * @param col   the col
   * @param color the color
   */
  public Knight(int row, int col, Color color) {
    super(row, col, color);
  }

  @Override
  public boolean canMove(int row, int col) {
    // If the given location is outside chess board or is the same position of this piece.
    if (this.outsideBoard(row, col) || (this.row == row && this.col == col)) {
      return false;
    }
    // Moving two space vertically one space horizontally or vice versa.
    if ((Math.abs(this.row - row) == 2 && Math.abs(this.col - col) == 1) || (
        Math.abs(this.row - row) == 1 && Math.abs(this.col - col) == 2)) {
      return true;
    }
    return false;
  }
}
