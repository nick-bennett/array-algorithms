import {expect, test} from "vitest";
import {shuffle} from "../src/shuffle.js";

const dataSize = 100;

const unshuffledData = Array.from(
    {length: dataSize},
    (_, index) => index + 1
);

const dataToShuffle = [...unshuffledData];
const expectedSet = new Set(unshuffledData);

test("Shuffle: check for correct contents", () => {
  shuffle(dataToShuffle);
  console.log(dataToShuffle);
  expect(new Set(dataToShuffle)).toStrictEqual(expectedSet);
});

