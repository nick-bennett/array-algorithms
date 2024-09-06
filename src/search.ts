export function linear(needle: number, haystack: number[]): number {
  let position = -1;
  for (let i = 0; i < haystack.length; i++) {
    if (haystack[i] == needle) {
      position = i;
      break;
    }
  }
  return position;
}

export function binaryIterative(needle: number, haystack: number[]): number {
  let position: number = -1;
  let fromIndex = 0;
  let toIndex = haystack.length;
  while (fromIndex < toIndex) {
    const midIndex = Math.floor((fromIndex + toIndex) / 2);
    const midValue = haystack[midIndex];
    if (midValue > needle) {
      toIndex = midIndex;
    } else if (midValue < needle) {
      fromIndex = midIndex + 1;
    } else {
      position = midIndex;
      break;
    }
  }
  return position >= 0 ? position : -(fromIndex + 1);
}

export function binaryRecursive(
    needle: number,
    haystack: number[],
    fromIndex: number = 0,
    toIndex: number = haystack.length
): number {
  let position: number = -(fromIndex + 1);
  if (toIndex > fromIndex) {
    const midIndex = Math.floor((fromIndex + toIndex) / 2);
    const midValue = haystack[midIndex];
    if (midValue > needle) {
      position = binaryRecursive(needle, haystack, fromIndex, midIndex);
    } else if (midValue < needle) {
      position = binaryRecursive(needle, haystack, midIndex + 1, toIndex);
    } else {
      position = midIndex;
    }
  }
  return position;
}
