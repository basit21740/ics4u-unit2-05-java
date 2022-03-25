/*
* This program prints out the Magic Sqaures.
*
* @author  Abdul Basit
* @version 1.0
* @since   2022-02-01
*/

/**
 * This is the MagicSquares program.
 * */
 final class MagicSquares {

  /** The middle left index. */
  public static final int THREE = 3;
  /** The center index. */
  public static final int FOUR = 4;
  /** The middle right index. */
  public static final int FIVE = 5;
  /** The lower left index. */
  public static final int SIX = 6;
  /** The lower center index. */
  public static final int SEVEN = 7;
  /** The lower right index. */
  public static final int EIGHT = 8;
  /** The maximum number for magicNumbers. */
  public static final int NINE = 9;
  /** The maximum number for magicNumbers. */
  public static final int MAGICNUM = 15;

  /**
  * Prevents instantiation.
  * Throw an exception IllegalStateException when called.
  *
  * @throws IllegalStateException
  * */
  private MagicSquares() {
      throw new IllegalStateException("Cannot be instantiated");
  }

  /**
   * Generates magic squares.
   *
   * @param square the magic square.
   * @param currentSquare the extra array.
   * @param index is the index.
   * */
  public static void genSquare(final int[] square, final int[] currentSquare,
                               final int index) {

      for (int iterator = 0; iterator < square.length; iterator++) {
          if (currentSquare[iterator] == 0) {
              square[index] = iterator + 1;
              currentSquare[iterator] = 1;

              if (index < square.length - 1) {
                  genSquare(square, currentSquare, index + 1);
              } else if (isMagic(square)) {
                  printMagicSquare(square);
              }

              currentSquare[iterator] = 0;
          }
      }

  }

  /**
   * Checks if the magic square is valid.
   *
   * @param preSquare the magic square to be checked.
   *
   * @return if the square is magic or not
   * */
  public static boolean isMagic(final int[] preSquare) {
      // returns true or false for whether or not array is a magic square
      final int row1 = preSquare[0] + preSquare[1] + preSquare[2];
      final int row2 = preSquare[THREE] + preSquare[FOUR] + preSquare[FIVE];
      final int row3 = preSquare[SIX] + preSquare[SEVEN] + preSquare[EIGHT];
      final int col1 = preSquare[0] + preSquare[THREE] + preSquare[SIX];
      final int col2 = preSquare[1] + preSquare[FOUR] + preSquare[SEVEN];
      final int col3 = preSquare[2] + preSquare[FIVE] + preSquare[EIGHT];
      final int diag1 = preSquare[0] + preSquare[FOUR] + preSquare[EIGHT];
      final int diag2 = preSquare[2] + preSquare[FOUR] + preSquare[SIX];

      return row1 == MAGICNUM && row2 == MAGICNUM && row3 == MAGICNUM
             && col1 == MAGICNUM && col2 == MAGICNUM
             && col3 == MAGICNUM && diag1 == MAGICNUM && diag2 == MAGICNUM;
  }

  /**
   * Outputs the magic square.
   *
   * @param outputSquare the valid magic square.
   * */
  public static void printMagicSquare(final int[] outputSquare) {

      final String newLine = "\n*****";
      final String spaces = " ";

      // prints inputted array in a magic square format
      System.out.println(newLine);
      for (int count = 0; count < outputSquare.length; count++) {
          if (count == THREE || count == SIX) {
              System.out.println();
              System.out.print(outputSquare[count] + spaces);
          } else {
              System.out.print(outputSquare[count] + spaces);
          }
      }
      System.out.println(newLine);
  }

  /**
   * Uses recursion to generate all the valid 3x3 magic squares.
   *
   * @param args No args will be used.
   * */
  public static void main(final String[] args) {
      // main stub, get user input here
      final int[] magicSquare =
          {1, 2, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE};
      final int[] extraArray = {0, 0, 0, 0, 0, 0, 0, 0, 0};
      System.out.println("\n");
      System.out.println("All Possible Magic Squares (3x3):\n");
      genSquare(magicSquare, extraArray, 0);

      System.out.println("\nDone.");
  }
}
