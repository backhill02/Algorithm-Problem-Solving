const readLine = require('readline');

const rl = readLine.createInterface({
  input: process.stdin,
  output: process.stdout
});

rl.on('line', function (line) {
  let num = parseInt(line);
  let five = 5;
  let three = 3;

  let fiveCnt = Math.floor(num / five);
  num %= five;
  let threeCnt = 0;

  while (fiveCnt > 0) {
    if (num % three === 0) {
      threeCnt = num / three;
      num %= three;
      break;
    }

    fiveCnt--;
    num += five;
  }

  console.log(num === 0 ? fiveCnt + threeCnt : -1);

  rl.close();
});
