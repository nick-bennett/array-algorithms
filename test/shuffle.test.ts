// noinspection SpellCheckingInspection

import {expect, test} from "vitest";
import {shuffle} from "../src/shuffle.js";

const smallDataSize = 100;
const unshuffledSmallData = Array.from(
    {length: smallDataSize},
    (_, index) => index + 1
);
const smallDataToShuffle = [...unshuffledSmallData];
const smallExpectedSet = new Set(unshuffledSmallData);

const largeDataSize = 1_000_000;
const unshuffledLargeData = Array.from(
    {length: largeDataSize},
    (_, index) => index + 1
);
const largeDataToShuffle = [...unshuffledLargeData];
const largeExpectedSet = new Set(unshuffledLargeData);

test("Shuffle: check for correct contents of small array", () => {
  shuffle(smallDataToShuffle);
  console.log(smallDataToShuffle);
  expect(new Set(smallDataToShuffle)).toStrictEqual(smallExpectedSet);
});

test("Shuffle: check for correct contents of large array", () => {
  shuffle(largeDataToShuffle);
  console.log(largeDataToShuffle);
  expect(new Set(largeDataToShuffle)).toStrictEqual(largeExpectedSet);
});
