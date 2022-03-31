package edu.cnm.deepdive;

import java.util.Random;
import java.util.stream.IntStream;

public class SearchTest {

  private static final int HAYSTACK_SIZE = 10_000_000;
  private static final int NUM_NEEDLES = 10_000;

  public static void main(String[] args) {
    Random rng = new Random();
    int[] haystack = IntStream
        .generate(() -> rng.nextInt(HAYSTACK_SIZE))
        .limit(HAYSTACK_SIZE)
        .toArray();
    int[] needles = IntStream
        .generate(() -> rng.nextInt(HAYSTACK_SIZE))
        .limit(NUM_NEEDLES)
        .toArray();
    timeLinearSearch(haystack, needles);
    timeBinarySearch(haystack, needles);
  }

  private static void timeLinearSearch(int[] haystack, int[] needles) {
    LinearSearch searcher = new LinearSearch();
    int found = 0;
    long start = System.currentTimeMillis();
    for (int needle : needles) {
      if (searcher.search(haystack, needle) >= 0) {
        found++;
      }
    }
    long finish = System.currentTimeMillis();
    System.out.printf("Found %d needles in %d milliseconds.%n", found, finish - start);
  }

  private static void timeBinarySearch(int[] haystack, int[] needles) {
    BinarySearch searcher = new BinarySearch();
    int found = 0;
    long start = System.currentTimeMillis();
    QuickSort sorter = new QuickSort();
    sorter.sort(haystack);
    long finish = System.currentTimeMillis();
    System.out.printf("Sorted haystack in %d milliseconds.%n", finish - start);
    start = System.currentTimeMillis();
    for (int needle : needles) {
      if (searcher.search(haystack, needle) >= 0) {
        found++;
      }
    }
    finish = System.currentTimeMillis();
    System.out.printf("Found %d needles in %d milliseconds.%n", found, finish - start);
  }

}
