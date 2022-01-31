package edu.cnm.deepdive;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Scratch {

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

    for (int i = 0; i < data.length; i++) {
      data[i] = i;
    }

    List<Integer> dataList = new ArrayList<>(size);
    for (int value : data) {
      dataList.add(value);
    }


    for (int i = 0; i < repetitions; i++) {
      Collections.shuffle(dataList, rng);
//      shuffler.shuffle(data);
    }
  }

}
