let input = [];

require('readline')
    .createInterface(process.stdin, process.stdout)
    .on('line', function (line) {
        input = line.split(' ');
    })
    .on('close', function() {
        console.log(solve(input));
    });

function solve(arr) {
    let asc = true;
    let desc = true;
    for (let i = 1; i < 8; i++) {
        if (arr[i - 1] > arr[i]) {
            asc = false;
        } else {
            desc = false;
        }
    }

    let result = "mixed";
    if (asc) {
        result = "ascending";
    } else if (desc) {
        result = "descending";
    }
    return result;
}
