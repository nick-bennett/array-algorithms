package edu.cnm.deepdive;

public class BinarySearch {

  public int search(int[] haystack, int needle) {
    return search(haystack, needle, 0, haystack.length);
  }

  public int search(int[] haystack, int needle, int startPosition, int endPosition) {
    int foundPosition = -startPosition - 1; // Same as ~startPosition
    if (endPosition > startPosition) {
      int midpointPosition = (startPosition + endPosition) / 2;
      int midpointValue = haystack[midpointPosition];
      if (midpointValue == needle) {
        // Found it and midpointPosition!
        foundPosition = midpointPosition;
      } else if (midpointValue < needle) {
        // Search right-hand side.
        foundPosition = search(haystack, needle, midpointPosition + 1, endPosition);
      } else {
        // Search left-hand side.
        foundPosition = search(haystack, needle, startPosition, midpointPosition);
      }
    }
    return foundPosition;
  }
}
