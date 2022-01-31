package edu.cnm.deepdive;

import java.util.Random;

/**
 * Implements the <a href="https://en.wikipedia.org/wiki/Fisher%E2%80%93Yates_shuffle">Fisher-Yates</a>
 * shuffling algorithm for different array types.
 */
public class Shuffler {

  private final Random rng;

  /**
   * Initializes this instance with the specified source of randomness. The source of randomness may
   * be an instance of any subclass of {@link Random}; however, note that {@link Random} itself is a
   * low-quality pseudo-random number generator (PRNG).
   *
   * @param rng Source of randomness.
   */
  public Shuffler(Random rng) {
    this.rng = rng;
  }

  /**
   * Shuffles the contents of {@code data} in-place. That is, a new array is not created and
   * returned; instead, {@code data} is modified directly.
   *
   * @param data Array to be shuffled.
   */
  public void shuffle(int[] data) {
    // Iterate over data from end to start, swapping with a randomly selected element.
    for (int targetIndex = data.length - 1; targetIndex > 0; targetIndex--) {
      int sourceIndex = rng.nextInt(targetIndex + 1);
      if (sourceIndex != targetIndex) {
        int temp = data[targetIndex];
        data[targetIndex] = data[sourceIndex];
        data[sourceIndex] = temp;
      }
    }
  }

}
