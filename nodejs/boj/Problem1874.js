let lines = [];

require('readline')
    .createInterface(process.stdin, process.stdout)
    .on('line', function (line) {
        lines.push(line);
    })
    .on('close', function () {
        const n = parseInt(lines[0], 10);
        const arr = lines.slice(1).map(num => parseInt(num, 10));
        console.log(solve(n, arr));
    });

function solve(n, arr) {
    let result = [];
    let stack = [];
    let cnt = 1;
    for (let i = 0; i < n; i++) {
        const num = arr[i];
        while (cnt <= num) {
            stack.push(cnt++);
            result.push('+');
        }
        if (stack.length > 0 && stack[stack.length - 1] === num) {
            stack.pop();
            result.push('-');
        }
    }

    if(stack.length === 0) {
        return result.join('\n');
    } else {
        return 'NO';
    }
}

module.exports = solve;
