const readLine = require('readline');

const rl = readLine.createInterface({
  input: process.stdin,
  output: process.stdout
});

rl.on('line', function (line) {
  let input = line.split(" ");
  let a = parseInt(input[0]);
  let b = parseInt(input[1]);
  console.log(a + b);
  rl.close();
});
