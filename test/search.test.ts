import {expect, test} from "vitest";
import {binaryIterative, binaryRecursive, linear} from "../src/search.js";
import * as haystacks from "./haystacks.js";

test("Linear search: single needle in small haystack", () => {
  expect(linear(12, [1, 3, 2, 10, 4, 5, 12, 6])).toBe(6);
});

test("Linear search: single needle not in small haystack", () => {
  expect(linear(12, [1, 3, 2, 10, 4, 5, 11, 6])).toBe(-1);
});

test("Iterative binary search: single needle in small haystack", () => {
  expect(binaryIterative(4, [0, 2, 3, 4, 5, 6, 10, 12])).toBe(3);
});

test("Iterative binary search: single needle not in small haystack", () => {
  expect(binaryIterative(7, [0, 2, 3, 4, 5, 6, 10, 12])).toBe(-7);
});

test("Recursive binary search: single needle in small haystack", () => {
  expect(binaryRecursive(4, [0, 2, 3, 4, 5, 6, 10, 12])).toBe(3);
});

test("Recursive binary search: single needle not in small haystack", () => {
  expect(binaryRecursive(7, [0, 2, 3, 4, 5, 6, 10, 12])).toBe(-7);
});

test("Linear search: many needles in large haystack", () => {
  expect(
      haystacks.presentNeedles.map((value) =>
          linear(value, haystacks.unsortedHaystack),
      ),
  ).toStrictEqual(haystacks.presentNeedlePositionsInUnsortedHaystack);
});

test("Linear search: many needles not in large haystack", () => {
  expect(
      haystacks.absentNeedles.map((value) =>
          linear(value, haystacks.unsortedHaystack),
      ),
  ).toStrictEqual(haystacks.absentNeedlePositionsInUnsortedHaystack);
});

test("Linear search via Array.indexOf: many needles in large haystack", () => {
  expect(
      haystacks.presentNeedles.map((value) =>
          haystacks.unsortedHaystack.indexOf(value),
      ),
  ).toStrictEqual(haystacks.presentNeedlePositionsInUnsortedHaystack);
});

test("Linear search via Array.indexOf: many needles not in large haystack", () => {
  expect(
      haystacks.absentNeedles.map((value) =>
          haystacks.unsortedHaystack.indexOf(value),
      ),
  ).toStrictEqual(haystacks.absentNeedlePositionsInUnsortedHaystack);
});

test("Iterative binary search: many needles in large sorted haystack, not including sort", () => {
  expect(
      haystacks.presentNeedles.map((value) =>
          binaryIterative(value, haystacks.sortedHaystack),
      ),
  ).toStrictEqual(haystacks.presentNeedlePositionsInSortedHaystack);
});

test("Iterative binary search: many needles in large sorted haystack, including sort", () => {
  const sortedHaystack = [...haystacks.unsortedHaystack];
  sortedHaystack.sort((a, b) => a - b);
  expect(
      haystacks.presentNeedles.map((value) =>
          binaryIterative(value, sortedHaystack),
      ),
  ).toStrictEqual(haystacks.presentNeedlePositionsInSortedHaystack);
});

test("Iterative binary search: many needles not in large sorted haystack, not including sort", () => {
  expect(
      haystacks.absentNeedles.map((value) =>
          binaryIterative(value, haystacks.sortedHaystack),
      ),
  ).toStrictEqual(haystacks.absentNeedlePositionsInSortedHaystack);
});

test("Iterative binary search: many needles not in large sorted haystack, including sort", () => {
  const sortedHaystack = [...haystacks.unsortedHaystack];
  sortedHaystack.sort((a, b) => a - b);
  expect(
      haystacks.absentNeedles.map((value) =>
          binaryIterative(value, sortedHaystack),
      ),
  ).toStrictEqual(haystacks.absentNeedlePositionsInSortedHaystack);
});

test("Recursive binary search: many needles in large sorted haystack, not including sort", () => {
  expect(
      haystacks.presentNeedles.map((value) =>
          binaryRecursive(value, haystacks.sortedHaystack),
      ),
  ).toStrictEqual(haystacks.presentNeedlePositionsInSortedHaystack);
});

test("Recursive binary search: many needles in large sorted haystack, including sort", () => {
  const sortedHaystack = [...haystacks.unsortedHaystack];
  sortedHaystack.sort((a, b) => a - b);
  expect(
      haystacks.presentNeedles.map((value) =>
          binaryRecursive(value, sortedHaystack),
      ),
  ).toStrictEqual(haystacks.presentNeedlePositionsInSortedHaystack);
});

test("Recursive binary search: many needles not in large sorted haystack, not including sort", () => {
  expect(
      haystacks.absentNeedles.map((value) =>
          binaryRecursive(value, haystacks.sortedHaystack),
      ),
  ).toStrictEqual(haystacks.absentNeedlePositionsInSortedHaystack);
});

test("Recursive binary search: many needles not in large sorted haystack, including sort", () => {
  const sortedHaystack = [...haystacks.unsortedHaystack];
  sortedHaystack.sort((a, b) => a - b);
  expect(
      haystacks.absentNeedles.map((value) =>
          binaryRecursive(value, sortedHaystack),
      ),
  ).toStrictEqual(haystacks.absentNeedlePositionsInSortedHaystack);
});
