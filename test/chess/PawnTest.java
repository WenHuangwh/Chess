package chess;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;

/**
 * The type Pawn test.
 */
public class PawnTest {

  /**
   * The Pawn.
   */
  Pawn pawn;

  /**
   * Sets up.
   */
  @Before
  public void setUp() {
    pawn = new Pawn(2, 3, Color.WHITE);
    // Test valid black color
    Pawn testBlack = new Pawn(3, 5, Color.BLACK);
  }

  /**
   * Test bad set up.
   */
  @Test
  public void testBadSetUp() {
    try {
      new Pawn(-1, 1, Color.WHITE);
      fail("Illegal row or column.");
    } catch (IllegalArgumentException e) {
    }
    try {
      new Pawn(9, 1, Color.BLACK);
      fail("Illegal row or column.");
    } catch (IllegalArgumentException e) {
    }
    try {
      new Pawn(9, -1, Color.WHITE);
      fail("Illegal row or column.");
    } catch (IllegalArgumentException e) {
    }
  }

  /**
   * Test outside board.
   */
  @Test
  public void outsideBoard() {
    assertFalse(pawn.outsideBoard(5, 5));
    assertTrue(pawn.outsideBoard(-1, 5));
    assertTrue(pawn.outsideBoard(10, 5));
  }

  /**
   * Gets row.
   */
  @Test
  public void getRow() {
    assertEquals(2, pawn.getRow());
  }

  /**
   * Gets column.
   */
  @Test
  public void getColumn() {
    assertEquals(3, pawn.getColumn());
  }

  /**
   * Gets color.
   */
  @Test
  public void getColor() {
    assertEquals(Color.WHITE, pawn.getColor());
    assertEquals(Color.BLACK, new Pawn(1, 1, Color.BLACK).getColor());
  }

  /**
   * Test canMove.
   */
  @Test
  public void canMove() {
    // out of board.
    assertFalse(pawn.canMove(9, 9));
    // White Pawn at row 1.
    Pawn pawnWhite1 = new Pawn(1, 3, Color.WHITE);
    for (int i = 0; i < 8; i++) {
      for (int j = 0; j < 8; j++) {
        if (i <= 1 || i > 3) {
          assertFalse(pawnWhite1.canMove(i, j));
        } else if (j == 3) {
          assertTrue(pawnWhite1.canMove(i, j));
        } else {
          assertFalse(pawnWhite1.canMove(i, j));
        }
      }
    }
    // White Pawn at row other than 1.
    Pawn pawnWhite2 = new Pawn(2, 3, Color.WHITE);
    for (int i = 0; i < 8; i++) {
      for (int j = 0; j < 8; j++) {
        if (i != 3) {
          assertFalse(pawnWhite2.canMove(i, j));
        } else if (j == 3) {
          assertTrue(pawnWhite2.canMove(i, j));
        } else {
          assertFalse(pawnWhite2.canMove(i, j));
        }
      }
    }
    // Black Pawn at row 6.
    Pawn pawnBlack6 = new Pawn(6, 3, Color.BLACK);
    for (int i = 0; i < 8; i++) {
      for (int j = 0; j < 8; j++) {
        if (i != 4 && i != 5) {
          assertFalse(pawnBlack6.canMove(i, j));
        } else if (j == 3) {
          assertTrue(pawnBlack6.canMove(i, j));
        } else {
          assertFalse(pawnBlack6.canMove(i, j));
        }
      }
    }
    // Black Pawn at row other than 6.
    Pawn pawnBlack5 = new Pawn(5, 3, Color.BLACK);
    for (int i = 0; i < 8; i++) {
      for (int j = 0; j < 8; j++) {
        if (i != 4) {
          assertFalse(pawnBlack5.canMove(i, j));
        } else if (j == 3) {
          assertTrue(pawnBlack5.canMove(i, j));
        } else {
          assertFalse(pawnBlack5.canMove(i, j));
        }
      }
    }
  }

  /**
   * Test canKill.
   */
  @Test
  public void canKill() {
    // White Pawn
    for (int i = 0; i < 8; i++) {
      for (int j = 0; j < 8; j++) {
        // same color
        assertFalse(pawn.canKill(new King(i, j, Color.WHITE)));
        if (i == 3 && Math.abs(pawn.col - j) == 1) {
          assertTrue(pawn.canKill(new King(i, j, Color.BLACK)));
        } else {
          assertFalse(pawn.canKill(new King(i, j, Color.BLACK)));
        }
      }
    }

    // Black Pawn
    Pawn balckPawn = new Pawn(6, 3, Color.BLACK);
    for (int i = 0; i < 8; i++) {
      for (int j = 0; j < 8; j++) {
        // same color
        if (i == 5 && Math.abs(balckPawn.col - j) == 1) {
          assertTrue(balckPawn.canKill(new King(i, j, Color.WHITE)));
        } else {
          assertFalse(balckPawn.canKill(new King(i, j, Color.WHITE)));
        }
      }
    }
  }
}