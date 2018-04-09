const readline = require('readline');

const rl = readline.createInterface({
    input: process.stdin,
    output: process.stdout
});

rl.on('line', function (line) {
    var num = parseInt(line);
    var five = 5;
    var three = 3;

    var fiveCnt = Math.floor(num / five);
    num %= five;
    var threeCnt = 0;

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
