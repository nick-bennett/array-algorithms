import {expect, test} from "vitest";
import {binaryIterative, binaryRecursive, linear} from "../src/search.js";
import * as haystacks from "./haystacks.js";

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
