package edu.cnm.deepdive;

import java.util.Arrays;
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

  public boolean[] draw(boolean[] data, int drawSize) {
    shuffle(data, drawSize);
    return Arrays.copyOfRange(data, data.length - drawSize, data.length);
  }

  public byte[] draw(byte[] data, int drawSize) {
    shuffle(data, drawSize);
    return Arrays.copyOfRange(data, data.length - drawSize, data.length);
  }

  public char[] draw(char[] data, int drawSize) {
    shuffle(data, drawSize);
    return Arrays.copyOfRange(data, data.length - drawSize, data.length);
  }

  public short[] draw(short[] data, int drawSize) {
    shuffle(data, drawSize);
    return Arrays.copyOfRange(data, data.length - drawSize, data.length);
  }

  public int[] draw(int[] data, int drawSize) {
    shuffle(data, drawSize);
    return Arrays.copyOfRange(data, data.length - drawSize, data.length);
  }

  public long[] draw(long[] data, int drawSize) {
    shuffle(data, drawSize);
    return Arrays.copyOfRange(data, data.length - drawSize, data.length);
  }

  public float[] draw(float[] data, int drawSize) {
    shuffle(data, drawSize);
    return Arrays.copyOfRange(data, data.length - drawSize, data.length);
  }

  public double[] draw(double[] data, int drawSize) {
    shuffle(data, drawSize);
    return Arrays.copyOfRange(data, data.length - drawSize, data.length);
  }

  public Object[] draw(Object[] data, int drawSize) {
    shuffle(data, drawSize);
    return Arrays.copyOfRange(data, data.length - drawSize, data.length);
  }

  /**
   * Shuffles the contents of {@code data} in-place. That is, a new array is not created and
   * returned; instead, {@code data} is modified directly.
   *
   * @param data Array to be shuffled.
   */
  public void shuffle(boolean[] data) {
    shuffle(data, data.length - 1);
  }

  /**
   * Shuffles the contents of {@code data} in-place. That is, a new array is not created and
   * returned; instead, {@code data} is modified directly.
   *
   * @param data Array to be shuffled.
   */
  public void shuffle(byte[] data) {
    shuffle(data, data.length - 1);
  }

  /**
   * Shuffles the contents of {@code data} in-place. That is, a new array is not created and
   * returned; instead, {@code data} is modified directly.
   *
   * @param data Array to be shuffled.
   */
  public void shuffle(char[] data) {
    shuffle(data, data.length - 1);
  }

  /**
   * Shuffles the contents of {@code data} in-place. That is, a new array is not created and
   * returned; instead, {@code data} is modified directly.
   *
   * @param data Array to be shuffled.
   */
  public void shuffle(short[] data) {
    shuffle(data, data.length - 1);
  }

  /**
   * Shuffles the contents of {@code data} in-place. That is, a new array is not created and
   * returned; instead, {@code data} is modified directly.
   *
   * @param data Array to be shuffled.
   */
  public void shuffle(int[] data) {
    shuffle(data, data.length - 1);
  }

  /**
   * Shuffles the contents of {@code data} in-place. That is, a new array is not created and
   * returned; instead, {@code data} is modified directly.
   *
   * @param data Array to be shuffled.
   */
  public void shuffle(long[] data) {
    shuffle(data, data.length - 1);
  }

  /**
   * Shuffles the contents of {@code data} in-place. That is, a new array is not created and
   * returned; instead, {@code data} is modified directly.
   *
   * @param data Array to be shuffled.
   */
  public void shuffle(float[] data) {
    shuffle(data, data.length - 1);
  }

  /**
   * Shuffles the contents of {@code data} in-place. That is, a new array is not created and
   * returned; instead, {@code data} is modified directly.
   *
   * @param data Array to be shuffled.
   */
  public void shuffle(double[] data) {
    shuffle(data, data.length - 1);
  }

  /**
   * Shuffles the contents of {@code data} in-place. That is, a new array is not created and
   * returned; instead, {@code data} is modified directly.
   *
   * @param data Array to be shuffled.
   */
  public void shuffle(Object[] data) {
    shuffle(data, data.length - 1);
  }

  private void shuffle(boolean[] data, int drawSize) {
    for (int targetIndex = data.length - 1; targetIndex >= data.length - drawSize; targetIndex--) {
      int sourceIndex = rng.nextInt(targetIndex + 1);
      if (sourceIndex != targetIndex) {
        boolean temp = data[targetIndex];
        data[targetIndex] = data[sourceIndex];
        data[sourceIndex] = temp;
      }
    }
  }

  private void shuffle(byte[] data, int drawSize) {
    for (int targetIndex = data.length - 1; targetIndex >= data.length - drawSize; targetIndex--) {
      int sourceIndex = rng.nextInt(targetIndex + 1);
      if (sourceIndex != targetIndex) {
        byte temp = data[targetIndex];
        data[targetIndex] = data[sourceIndex];
        data[sourceIndex] = temp;
      }
    }
  }

  private void shuffle(char[] data, int drawSize) {
    for (int targetIndex = data.length - 1; targetIndex >= data.length - drawSize; targetIndex--) {
      int sourceIndex = rng.nextInt(targetIndex + 1);
      if (sourceIndex != targetIndex) {
        char temp = data[targetIndex];
        data[targetIndex] = data[sourceIndex];
        data[sourceIndex] = temp;
      }
    }
  }

  private void shuffle(short[] data, int drawSize) {
    for (int targetIndex = data.length - 1; targetIndex >= data.length - drawSize; targetIndex--) {
      int sourceIndex = rng.nextInt(targetIndex + 1);
      if (sourceIndex != targetIndex) {
        short temp = data[targetIndex];
        data[targetIndex] = data[sourceIndex];
        data[sourceIndex] = temp;
      }
    }
  }

  private void shuffle(int[] data, int drawSize) {
    for (int targetIndex = data.length - 1; targetIndex >= data.length - drawSize; targetIndex--) {
      int sourceIndex = rng.nextInt(targetIndex + 1);
      if (sourceIndex != targetIndex) {
        int temp = data[targetIndex];
        data[targetIndex] = data[sourceIndex];
        data[sourceIndex] = temp;
      }
    }
  }

  private void shuffle(long[] data, int drawSize) {
    for (int targetIndex = data.length - 1; targetIndex >= data.length - drawSize; targetIndex--) {
      int sourceIndex = rng.nextInt(targetIndex + 1);
      if (sourceIndex != targetIndex) {
        long temp = data[targetIndex];
        data[targetIndex] = data[sourceIndex];
        data[sourceIndex] = temp;
      }
    }
  }

  private void shuffle(float[] data, int drawSize) {
    for (int targetIndex = data.length - 1; targetIndex >= data.length - drawSize; targetIndex--) {
      int sourceIndex = rng.nextInt(targetIndex + 1);
      if (sourceIndex != targetIndex) {
        float temp = data[targetIndex];
        data[targetIndex] = data[sourceIndex];
        data[sourceIndex] = temp;
      }
    }
  }

  private void shuffle(double[] data, int drawSize) {
    for (int targetIndex = data.length - 1; targetIndex >= data.length - drawSize; targetIndex--) {
      int sourceIndex = rng.nextInt(targetIndex + 1);
      if (sourceIndex != targetIndex) {
        double temp = data[targetIndex];
        data[targetIndex] = data[sourceIndex];
        data[sourceIndex] = temp;
      }
    }
  }

  private void shuffle(Object[] data, int drawSize) {
    for (int targetIndex = data.length - 1; targetIndex >= data.length - drawSize; targetIndex--) {
      int sourceIndex = rng.nextInt(targetIndex + 1);
      if (sourceIndex != targetIndex) {
        Object temp = data[targetIndex];
        data[targetIndex] = data[sourceIndex];
        data[sourceIndex] = temp;
      }
    }
  }

}
