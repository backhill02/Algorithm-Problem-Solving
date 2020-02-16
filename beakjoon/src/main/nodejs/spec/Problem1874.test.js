const solve = require('../Problem1874');

describe('tests for Problem1874', () => {
    test('n:8, arr: [4, 3, 6, 8, 7, 5, 2, 1]', () => {
        expect(solve(8, [4, 3, 6, 8, 7, 5, 2, 1])).toEqual('+\n+\n+\n+\n-\n-\n+\n+\n-\n+\n+\n-\n-\n-\n-\n-');
    });

    test('n:5, arr: [1, 2, 5, 3, 4]', () => {
        expect(solve(5, [1, 2, 5, 3, 4])).toEqual('NO');
    });
});
