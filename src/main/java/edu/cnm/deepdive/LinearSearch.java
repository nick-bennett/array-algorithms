package edu.cnm.deepdive;

public class LinearSearch {

  public int search(int[] haystack, int needle) {
    int foundPosition = -1;
    for (int i = 0; i < haystack.length; i++) {
      if (haystack[i] == needle) {
        foundPosition = i;
        break;
      }
    }
    return foundPosition;
  }

}
