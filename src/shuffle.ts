export function shuffle(data: any[]) {
  for (let targetIndex: number = data.length - 1; targetIndex > 0; targetIndex--) {
    const sourceIndex = Math.floor(Math.random() * (targetIndex + 1));
    if (targetIndex != sourceIndex) {
      const temp = data[targetIndex];
      data[targetIndex] = data[sourceIndex];
      data[sourceIndex] = temp;
    }
  }
}
