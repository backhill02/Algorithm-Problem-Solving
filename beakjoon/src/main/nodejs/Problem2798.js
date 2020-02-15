let lines = [];

require('readline')
    .createInterface(process.stdin, process.stdout)
    .on('line', function (line) {
        lines.push(line);
    })
    .on('close', function () {
        const firstLine = lines[0].split(' ');
        const n = parseInt(firstLine[0], 10);
        const m = parseInt(firstLine[1], 10);
        const arr = lines[1].split(' ').map(line => parseInt(line, 10));
        console.log(solve(n, m, arr));
    });

function solve(n, m, arr) {
    let result = 0;
    for (let i = 0; i < n; i++) {
        for (let j = i + 1; j < n; j++) {
            for (let k = j + 1; k < n; k++) {
                let sum = arr[i] + arr[j] + arr[k];
                if (sum <= m) {
                    result = Math.max(result, sum);
                }
            }
        }
    }
    return result;
}
