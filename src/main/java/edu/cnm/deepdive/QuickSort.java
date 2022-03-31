package edu.cnm.deepdive;

public class QuickSort {

  public void sort(int[] data) {
    sort(data, 0, data.length);
  }

  public void sort(int[] data, int startPosition, int endPosition) {
    if (endPosition > startPosition + 1) {
      // Divide
      int pivotValue = data[startPosition];
      int dividerPosition = startPosition;
      for (int currentPosition = startPosition + 1; currentPosition < endPosition; currentPosition++) {
        int currentValue = data[currentPosition];
        if (currentValue <= pivotValue) {
          dividerPosition++;
          if (dividerPosition < currentPosition) {
            data[currentPosition] = data[dividerPosition];
            data[dividerPosition] = currentValue;
          }
        }
      }
      data[startPosition] = data[dividerPosition];
      data[dividerPosition] = pivotValue; // Value is FIXED in final position!!!!
      sort(data, startPosition, dividerPosition); // Sort left-hand partition.
      sort(data, dividerPosition + 1, endPosition); // Sort right-hand partition.
      // Conquer?????
    }
  }

}
