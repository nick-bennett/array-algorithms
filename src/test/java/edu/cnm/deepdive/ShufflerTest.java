package edu.cnm.deepdive;

import static org.junit.jupiter.api.Assertions.*;

import java.security.SecureRandom;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import org.junit.jupiter.api.Test;

class ShufflerTest {

  static final int ARRAY_SIZE = 100;

  @Test
  void shuffle() {
    int[] data = new int[ARRAY_SIZE];
    Set<Integer> before = new HashSet<>();
    for (int i = 0; i < data.length; i++) {
      data[i] = i;
      before.add(i);
    }
    int[] preshuffle = Arrays.copyOf(data, data.length);
    Shuffler s = new Shuffler(new SecureRandom());
    s.shuffle(data);
    Set<Integer> after = new HashSet<>();
    for (int value : data) {
      after.add(value);
    }
    assertEquals(before, after);
    if (Arrays.equals(preshuffle, data)) {
      s.shuffle(data);
      assertFalse(Arrays.equals(preshuffle, data));
    }
  }

}