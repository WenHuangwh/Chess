package chess;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;

/**
 * The type Rook test.
 */
public class RookTest {

  /**
   * The Rook.
   */
  Rook rook;

  /**
   * Sets up.
   */
  @Before
  public void setUp() {
    rook = new Rook(2, 3, Color.WHITE);
    // Test valid black color
    Rook testBlack = new Rook(3, 5, Color.BLACK);
  }

  /**
   * Test bad set up.
   */
  @Test
  public void testBadSetUp() {
    try {
      new Rook(-1, 1, Color.WHITE);
      fail("Illegal row or column.");
    } catch (IllegalArgumentException e) {
    }
    try {
      new Rook(9, 1, Color.BLACK);
      fail("Illegal row or column.");
    } catch (IllegalArgumentException e) {
    }
    try {
      new Rook(9, -1, Color.WHITE);
      fail("Illegal row or column.");
    } catch (IllegalArgumentException e) {
    }
  }

  /**
   * Outside board.
   */
  @Test
  public void outsideBoard() {
    assertFalse(rook.outsideBoard(5, 5));
    assertTrue(rook.outsideBoard(-1, 5));
    assertTrue(rook.outsideBoard(10, 5));
  }

  /**
   * Gets row.
   */
  @Test
  public void getRow() {
    assertEquals(2, rook.getRow());
  }

  /**
   * Gets column.
   */
  @Test
  public void getColumn() {
    assertEquals(3, rook.getColumn());
  }

  /**
   * Gets color.
   */
  @Test
  public void getColor() {
    assertEquals(Color.WHITE, rook.getColor());
    assertEquals(Color.BLACK, new Rook(1, 1, Color.BLACK).getColor());
  }

  /**
   * Test canMove.
   */
  @Test
  public void canMove() {
    // out of board
    assertFalse(rook.canMove(9, 9));
    // other position in board
    for (int i = 0; i < 8; i++) {
      for (int j = 0; j < 8; j++) {
        if (i == 2 && j == 3) {
          assertFalse(rook.canMove(i, j));
        } else if (i == 2 || j == 3) {
          assertTrue(rook.canMove(i, j));
        } else {
          assertFalse(rook.canMove(i, j));
        }
      }
    }
  }

  /**
   * Test canKill.
   */
  @Test
  public void canKill() {
    for (int i = 0; i < 8; i++) {
      for (int j = 0; j < 8; j++) {
        // same color
        assertFalse(rook.canKill(new King(i, j, Color.WHITE)));
        if (i == 2 && j == 3) {
          assertFalse(rook.canKill(new King(i, j, Color.BLACK)));
        } else if (i == 2 || j == 3) {
          assertTrue(rook.canKill(new King(i, j, Color.BLACK)));
        } else {
          assertFalse(rook.canKill(new King(i, j, Color.BLACK)));
        }
      }
    }
  }
}