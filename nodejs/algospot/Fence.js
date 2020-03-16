let lines = [];

require('readline')
    .createInterface(process.stdin, process.stdout)
    .on('line', function (line) {
        lines.push(line);
    })
    .on('close', function () {
        const testCnt = parseInt(lines[0], 10);
        for (let t = 0; t < testCnt; t++) {
            const n = parseInt(lines[(t + 1) * 2 - 1], 10);
            const arr = lines[(t + 1) * 2].split(' ').map(n => parseInt(n, 10));
            console.log(solve(arr, 0, n - 1));
        }
    });

function solve(arr, left, right) {
    if (left === right) return arr[left];
    let mid = Math.floor((left + right) / 2);
    let ret = Math.max(solve(arr, left, mid), solve(arr, mid + 1, right));
    let lo = mid;
    let hi = mid + 1;
    let height = Math.min(arr[lo], arr[hi]);
    ret = Math.max(ret, height * 2);
    while (lo > left || hi < right) {
        if (hi < right && (lo === left || arr[lo - 1] < arr[hi + 1])) {
            hi++;
            height = Math.min(height, arr[hi]);
        } else {
            lo--;
            height = Math.min(height, arr[lo]);
        }
        ret = Math.max(ret, height * (hi - lo + 1));
    }
    return ret;
}

