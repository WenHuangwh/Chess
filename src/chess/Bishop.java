package chess;

/**
 * The type Bishop.
 */
public class Bishop extends AbstractChessPiece {

  /**
   * Instantiates a new Bishop with given row, column and color.
   *
   * @param row   the row
   * @param col   the column
   * @param color the color
   */
  public Bishop(int row, int col, Color color) {

    super(row, col, color);
  }

  @Override
  public boolean canMove(int row, int col) {
    // If the given location is outside chess board or is the same position of this piece.
    if (this.outsideBoard(row, col) || (this.row == row && this.col == col)) {
      return false;
    }
    // Moving diagonally.
    if (Math.abs(this.row - row) == Math.abs(this.col - col)) {
      return true;
    }
    return false;
  }

}
