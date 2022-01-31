package edu.cnm.deepdive;

import java.security.SecureRandom;
import java.util.Random;

public class Shuffler {

  private final Random rng;

  public Shuffler(Random rng) {
    this.rng = rng;
  }

  public void shuffle(int[] data) {
    for (int targetIndex = data.length - 1; targetIndex > 0; targetIndex--) {
      int sourceIndex = rng.nextInt(targetIndex + 1);
      if (sourceIndex != targetIndex) {
        int temp = data[targetIndex];
        data[targetIndex] = data[sourceIndex];
        data[sourceIndex] = temp;
      }
    }
  }

  public static void main(String[] args) {
    long timerStart;

    Random rng = new SecureRandom();
    timerStart = System.currentTimeMillis();
    repeatShuffles(rng, 100_000, 100);
    System.out.println(System.currentTimeMillis() - timerStart);

    rng = new Random();
    timerStart = System.currentTimeMillis();
    repeatShuffles(rng, 100_000, 100);
    System.out.println(System.currentTimeMillis() - timerStart);

  }

  private static void repeatShuffles(Random rng, int size, int repetitions) {
    Shuffler shuffler = new Shuffler(rng);
    int[] data = new int[size];
//    System.out.printf("Initial values = %s%n", Arrays.toString(data));
    for (int i = 0; i < data.length; i++) {
      data[i] = i;
    }
//    System.out.printf("Unshuffled values = %s%n", Arrays.toString(data));
    for (int i = 0; i < repetitions; i++) {
      shuffler.shuffle(data);
//    System.out.printf("Shuffled values = %s%n", Arrays.toString(data));
    }
  }

}
