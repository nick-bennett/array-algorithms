// Distinct even numbers.
const haystackSize = 500_000;
const upperBound = 1_000_000_000;
const numNeedles = 10_000;

export const unsortedHaystack = [
  ...new Set(
    Array.from(
      { length: haystackSize },
      () => 2 * Math.floor((Math.random() * upperBound) / 2),
    ),
  ),
];

// Random array positions
export const presentNeedlePositionsInUnsortedHaystack = Array.from(
  { length: numNeedles },
  () => Math.floor(Math.random() * unsortedHaystack.length),
);

// Values in unsortedHaystack at the random array positions obtained above.
export const presentNeedles = presentNeedlePositionsInUnsortedHaystack.map(
  (value) => unsortedHaystack[value],
);

// Values in present needles, each shifted up or down by 1.
export const absentNeedles = presentNeedles.map(
  (value) => value + 2 * Math.floor(Math.random() * 2) - 1,
);

// Linear search can only return -1 for items not found.
export const absentNeedlePositionsInUnsortedHaystack = Array.from(
  { length: absentNeedles.length },
  () => -1,
);

// Sorted copy of unsortedHaystack.
export const sortedHaystack = [...unsortedHaystack];
sortedHaystack.sort((a, b) => a - b);

export const presentNeedlePositionsInSortedHaystack = presentNeedles.map(
  (value) => sortedHaystack.indexOf(value),
);

export const absentNeedlePositionsInSortedHaystack = absentNeedles.map(
  (needleValue) =>
    -(sortedHaystack.findIndex((haystackValue) => haystackValue > needleValue) + 1)
);
