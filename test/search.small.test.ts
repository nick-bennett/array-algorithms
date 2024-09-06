import {expect, test} from "vitest";
import {binaryIterative, binaryRecursive, linear} from "../src/search.js";

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
