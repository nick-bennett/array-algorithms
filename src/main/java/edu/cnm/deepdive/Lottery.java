package edu.cnm.deepdive;

import java.security.SecureRandom;
import java.util.Arrays;
import java.util.Random;

public class Lottery {

  private final int poolSize;
  private final int drawSize;
  private final Random rng;
  private final Shuffler s;
  private int[] pool;

  public Lottery(String[] args) {
    poolSize = Integer.parseInt(args[0]);;
    drawSize = Integer.parseInt(args[1]);
    rng = new SecureRandom();
    s = new Shuffler(rng);
    pool = new int[poolSize];
    for (int i = 0; i < poolSize; i++) {
      pool[i] = i + 1;
    }
  }

  public int[] draw(boolean sorted) {
    int[] sample = s.draw(pool, drawSize);
    if (sorted) {
      Arrays.sort(sample);
    }
    return sample;
  }

  public void display(int[] draw) {
    System.out.printf("Drawing %d numbers from a pool of %d: %s%n",
        drawSize, poolSize, Arrays.toString(draw));
  }

  public static void main(String[] args) {
    Lottery lotto = new Lottery(args);
    int[] draw = lotto.draw(true);
    lotto.display(draw);
  }

}
