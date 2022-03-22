package edu.cnm.deepdive;

public class MergeSort {


  public void sort(int[] data) {
    sort(data, 0, data.length);
  }

  public void sort(int[] data, int startPosition, int endPosition) {
    if (endPosition > startPosition + 1) {
      // Divide
      int midPosition = (startPosition + endPosition) / 2;
      // Conquer
      sort(data, startPosition, midPosition); // Sort left subarray
      sort(data, midPosition, endPosition); // Sort right subarray
      // Merge
      int[] merged = new int[endPosition - startPosition];
      int mergedPosition = 0;
      int leftPosition = startPosition;
      int rightPosition = midPosition;
      while (leftPosition < midPosition && rightPosition < endPosition) {
        int leftValue = data[leftPosition];
        int rightValue = data[rightPosition];
        if (leftValue <= rightValue) {
          merged[mergedPosition] = leftValue;
          leftPosition++;
        } else {
          merged[mergedPosition] = rightValue;
          rightPosition++;
        }
        mergedPosition++;
      }
      if (leftPosition < midPosition) {
        System.arraycopy(data, leftPosition, merged, mergedPosition, midPosition - leftPosition);
      } else {
        System.arraycopy(data, rightPosition, merged, mergedPosition, endPosition - rightPosition);
      }
      System.arraycopy(merged, 0, data, startPosition, merged.length);
    }
  }

}
